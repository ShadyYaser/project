package shady_main;

public class Soldier implements NPC{

	String name;
	Location currentLocation;
	MainPlayer joel;
	private static Soldier instance;

	private Soldier(MainPlayer joel) {
		this.joel = joel;
		this.name = "Soldier";
		this.currentLocation = new JoelsHouse(joel);
	}

	public static synchronized Soldier getInstance(MainPlayer joel) {
		if(instance == null) 
			instance = new Soldier(joel);
		return instance;	
	}

	@Override
	public void talk() {
		System.out.println("                              --===+=--                    ");
		System.out.println("                            %##%###***++--                 ");
		System.out.println("                            %%%%%#%%###*+-+                ");
		System.out.println("                           %###**++*####*+=-               ");
		System.out.println("                          %@@@%%%%%%@#%###*+               ");
		System.out.println("                          @@@@#####*#%#####*               ");
		System.out.println("                   @=:*##+-:%@*######%#%#%**      %%#      ");
		System.out.println("                 @@%%+-===+++@#*%##*#%%#%##*      @=@      ");
		System.out.println("   %             %@@%##%%@#%%@@*#**##%%%#**+*#    @=@      ");
		System.out.println("   ##             --%*+**** %#%@@%%%%%%%%%#==##   @+@      ");
		System.out.println("%#++*+===*+=++**=++=+*+++*##%#%%@%%%%##*++*+*+*#* @@@      ");
		System.out.println(" ##%%      %%@@@%%@@#**+**##@@%%%%%#+==+++++*#***#@@%++-   ");
		System.out.println("           %@%@@%%%@%%%###%#@%%@%**=+******#*++**#%@%*-==  ");
		System.out.println("            @@@@@@@%%%%#%%@%%#%#*#*#####*#*+##*##%@@@##%+-");
		System.out.println("             %@@@@%@%##%%%%@%%#%#*#*##*###%%#%%%%%@%%#%%**");
		System.out.println("                  @%%***+*##%#*++***####*#*#*%@%%%#@%%%#*+-");
		System.out.println("                  %#####%%%%#*#%%%####*###*##%@@@%%%###%%##");
		System.out.println("                  #%%@@@@@%%%#*##%%###*#**%%%@@@%%%%@%%##+*");
		System.out.println("                   #%%%%%@%####%%#*###%#@%%#%%%@%%%%%%%##+*");
		System.out.println("                     %%###%###*+++*###%@%%%#%%@%%%%%%###%#*");
		System.out.println("                        %#%%#%**#+#%%@%%##*#%%%%%@@%%###=-");
		System.out.println("                        @**%%%%####%%%%%@@%##%%%%%%#%#*##+ ");
		System.out.println("                         +*%%%%%%%@%%@@@@@%##%%%%%%##*=   ");
		System.out.println("                       @@@@@@@@@@@@%%%%%%@%##%%%#%%##%=    ");
		System.out.println("                     %%###%%@@@@@@@%%%@@@%%%%%%@%##*##*    ");
		System.out.println("                          %@@@@@@@@@@@@@@%%%@@@%%%%%**     ");
		System.out.println("                          #%%#%%%%###%%%%%#*#@@@@@%%##     ");
		System.out.println("                         %%##*#%%%%%#######*+#%   %#       ");
		System.out.println("                        #%#%%%#****%%%%%%%%%%%@@%          ");
		System.out.println("                       @%******##%%%#*#*#%%##@@%#%         ");
		System.out.println("                       %#######*#%##*####*###%@%#+         ");
		System.out.println("                        #%%%%##%%###%#***+*++#@%%          ");
		System.out.println("                        ##%%%%@@#%%%##*=***=-              ");
		System.out.println("                         ##%%@@@@%%%%##*#*+*+              ");
		System.out.println("                         #%%%@%%%%%%%#*=*#+*+              ");
		System.out.println("                         %@%#%%%%%%%###*==+-=              ");
		System.out.println("                         %%##%#**#%%****=+*=               ");
		System.out.println("                         ######%%#####*+=*=-               ");
		System.out.println("                         ###**+++*****##*##*               ");
		System.out.println("                         *####*+****#####**%               ");
		System.out.println("                         **%**##*****##*+*=                ");
		System.out.println("                         =+#*%%%#%##%###*=*                ");
		System.out.println("                          %@###%%#######%#*                ");
		System.out.println("                         #%@%****##%%%@@@@%*               ");
		System.out.println("                         #%%@%##%#***##%%%%#               ");
		System.out.println("                         #%%@##*##**##%%#%%#               ");
		System.out.println("                          #%%%*#%%%#***#%%#**              ");
		System.out.println("                            %@#%%%%%%%%#%@%@%#             ");
		System.out.println("                             @%%%%%%###%%%%@@#             ");
		System.out.println("                               =***##*#%%%%%@%             ");
		System.out.println("                                +**###%%##%%%%             ");
		System.out.println("                                 +#*#%%%%#*%%%             ");
		System.out.println("                                  #%%*****%%#*             ");
		System.out.println("                                   ####%%%%%%%+            ");
		System.out.println("                                   +*%%##++####            ");
		System.out.println("                                   =+*%%@@@@@%%            ");
		System.out.println("                                    %%%%%###%%%            ");
		System.out.println("                                     @@%##*#%%%            ");
		System.out.println("                                     %%+#%%%%%%            ");
		System.out.println("                                 %%%%%%%%%%%%%%%           ");
		System.out.println("                             %#%%%%%%%%%%%%%%%%%           ");
		System.out.println("                             %%%%%%%%@%%%%%%@%@%           ");
		System.out.println("                              %@@@@%%@@%%%%%%%%%           ");
		System.out.println("                                 %%%%%@@@@@@%%%            ");
		System.out.println("                              %%%%%%###%%%%%%%%#           ");
		System.out.println("                            %#######%%%%%%%@@@%%           ");
		System.out.println("                           %%%%%%%%%%%%@@  @%              ");
		System.out.println("                            %%%%%@@@@%%                    ");
		System.out.println("                                                            ");




		UI.printNormal("Soldier: Stop right there!\n*Talking to walkie talkie* We got a couple civilians here\n*"
				+ "someone responds through the walkie talkie*\nSoldier:Yes sir *reluctantly*\n*Fires gun at Joel and his daughter*");
		joel.soldierShotGun = true;
	}

}
