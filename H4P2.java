// This class runs the game of Pig against the computer. Whoever reaches 100 points first wins.
// @Author (Sabrina Hong)
// @Date (11/2/25)
import java.util.*;
public class H4P2
{
    //Game of Pig where the human and computer takes turns rolling. First to 100 points wins.
    //If you roll a 1, your turn ends immediately and lose your rolled points that turn.
    //You can choose to hold(H) to safely end your turn and add the points to your total.
	public static void main(String[] args) {
        final int WIN_SCORE = 100; //Threshold points to win
        final int ROLL_THRESHOLD = 20; //Computer's hold threshold
        
        //Game values
        Random rand = new Random();
        Scanner s = new Scanner(System.in);
        int computer = 0;
        int human = 0;
        int rollingCount = 0;
        int previousRoll = 0;
        String choice = "";
        boolean humanTurn = true;
        boolean busted = false;
        
        //Game continues until someone reaches the winning score of 100
        while(computer < WIN_SCORE && human < WIN_SCORE){
            while(true){
                //Human rolls until hits 1 or chooses to hold
                if(humanTurn){
                    System.out.printf("Computer's Score: %d\n",computer);
                    System.out.printf("Human's Score: %d\n",human);
                    System.out.printf("Human's rolling score this turn: %d\n",rollingCount);
                    if(previousRoll!=0)
                        System.out.printf("Previous Roll: %d\n", previousRoll);
                    System.out.println("Do you wish to roll(R) or hold(H)?");
                    choice = s.nextLine();
                    //Roll
                    if(choice.equals("R"))
                        previousRoll = rand.nextInt(6)+1;
                    //Hold, add points this turn to total
                    else{
                        human+=rollingCount;
                        break;
                    }
                    //If rolled 1, end turn and lose all rolled points
                    if(previousRoll==1){
                        System.out.println("Uh oh! You rolled a 1. Your turn ends.");
                        break;
                    }
                    //Otherwise, add to rollingcount
                    else{
                        rollingCount+=previousRoll;
                    }
                }
                
                //Computer rolls until score passes 20 or hits 1
                else{
                    previousRoll = rand.nextInt(6)+1;
                    //If rolled 1, end turn and lose all rolled points
                    if(previousRoll==1){
                        break;
                    }
                    rollingCount+=previousRoll;
                    //If rollingCount exceeds 20, end the turn and add points
                    if(rollingCount >= ROLL_THRESHOLD){
                        computer+=rollingCount;
                        break;
                    }
                }
            }
            //Switch turns and reset values
            humanTurn = !humanTurn;
            busted = false;
            rollingCount = 0;
            previousRoll = 0;
        }
        //Based on points, determines who won.
        if(computer >= WIN_SCORE)
            System.out.printf("Computer has reached %d! Computer has won!\n",computer);
        else
            System.out.printf("Human has reached %d! Human won the game!\n",human);
        s.close();
	}
}
