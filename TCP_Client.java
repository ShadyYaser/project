package shady_main;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class TCP_Client extends ConcreteSubject implements Runnable{
	String host;
	int port;
	int power_threshold = 20;
	JSONParser parser = new JSONParser();
	int unLockCount = 0;
	private static TCP_Client instance;
	Thread t;
	
	private TCP_Client () {
		Scanner scan = new Scanner(System.in);
		 String c = "test";
		 do {
			 UI.printNormal("Enter IP: ");
	            if(scan.hasNextLine()) {
	                String ip = scan.nextLine();
	                this.host = ip;
	            }
	            UI.printNormal("Enter port: ");
	            if(scan.hasNextLine()) {
	                String port = scan.nextLine();
	                this.port = Integer.parseInt(port);
	            }
	            do {
	            	UI.printNormal("IP: " + this.host + " | Port: " + this.port + ". Are you sure? [y/n]: ");
	                if(scan.hasNextLine())
	                {
	                    c = scan.nextLine();
	                }
	            } while (!(c.equalsIgnoreCase("y")) && !(c.equalsIgnoreCase("n")));
	        } while(!(c.equalsIgnoreCase("y")));
		 scan.close();
		//this.host = "10.25.158.69";
		//this.port = 59610;
		t = new Thread(this);
		t.start();
	}

	public void setPowerThreshold(int power) {
		this.power_threshold = power;
	}
	
	public static synchronized TCP_Client getInstance(){
        if(instance == null) instance = new TCP_Client();
        return instance;
    }
	
	public Thread getThread() {
		return t;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				Socket socket = new Socket(this.host, this.port);
				InputStream input = socket.getInputStream();
				InputStreamReader reader = new InputStreamReader(input);
				BufferedReader br = new BufferedReader(reader);
				String line = "";
				while((line = br.readLine()) != null) {
					JSONObject jsonObject = (JSONObject) parser.parse(line);
					String logS = (String) jsonObject.get("avAudioRecorderAveragePower");
					String accx = (String) jsonObject.get("accelerometerAccelerationX");
					String accy = (String) jsonObject.get("accelerometerAccelerationY");
					String accz = (String) jsonObject.get("accelerometerAccelerationZ");
					String devR = (String) jsonObject.get("deviceOrientation");

					int deviceR = Integer.parseInt(devR);
					float acc = Float.parseFloat(accx);//x-axis: no need
					float acc2 = Float.parseFloat(accy); //y-axis
					float acc3 = Float.parseFloat(accz); //z-axis
					float power = Float.parseFloat(logS);

					if(deviceR == 3) {//device orientation sensor
						Message m1 = new Message(this, "landscape", "yes");
						publishMessage(m1);
					}
					if (Math.abs(power) < this.power_threshold) { //sound sensor
						Message m2 = new Message(this, "speaking", "yes");
						publishMessage(m2);
					}

					if (acc2 > 1 && (acc3 < 1 && acc3 > -1) ){//accelerometer sensor
						Message m3 = new Message(this, "shoot", "yes");
						publishMessage(m3);
					}
					
				}}catch (Exception e) {
					e.printStackTrace();}
			
		}

	}}
