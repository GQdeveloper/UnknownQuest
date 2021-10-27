
package unknownquest;
import java.io.File;
import java.util.Scanner;

public class UnknownQuest {
	static PlayerNpc gameHero;
	static boolean startGame = true; 
	static Scanner in;
	
    public static void main(String[] args) {

    	//reading the introduction file
    	try {
    		File introFile = new File("src/intro.txt");
    		Scanner intro = new Scanner(introFile);
    		while(intro.hasNextLine()) {
    			System.out.println(intro.nextLine());
    		}
    		intro.close();    		
		} catch(Exception e) {
			System.out.println("wrong file path!!");
		}	    	
    	
    	playerInfo();
    	Game game = new Game();
        game.playing(startGame, in, gameHero);
    }
    
    //Player input name 
    public static void playerInfo() {
    	
    	//player input name
    	Scanner in = new Scanner(System.in);
    	System.out.println("what is your name hero: ");
    	String heroName = in.nextLine();   	    	
    	
    	System.out.println("Hello " + heroName + " Would you like to start the journey.");    	
    	String start = in.nextLine();
    	
    	if(start.equals("yes")) {
    		startGame = true;
    		gameHero = new PlayerNpc(heroName, 100, 0);    		
    	}
    	else {    		
    		System.out.println("Good choice you would have fail anyways, good luck"); 
    		System.exit(0);
    	}	
    }
    
    
}
