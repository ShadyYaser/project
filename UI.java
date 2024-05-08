package shady_main;

import java.util.Scanner;

import java.util.ArrayList;

public class UI {

    public static synchronized void print(Object s) {
        for (int i = 0; i < s.toString().length(); i++) {

            System.out.print(s.toString().charAt(i));
            try {
                Thread.sleep(25);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.print("\n");
    }

    public static synchronized void printnln(Object s) {
        for (int i = 0; i < s.toString().length(); i++) {

            System.out.print(s.toString().charAt(i));
            try {
                Thread.sleep(25);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static synchronized void printNormal(Object s) {
        System.out.println(s);
    }

    public static synchronized void printArrayList(ArrayList s) {
        for (int i = 0; i < s.size(); i++) {
            UI.print(s.get(i));
        }
    }

    public static String read() {
        Scanner s = new Scanner(System.in);
        return s.nextLine();
    }
}