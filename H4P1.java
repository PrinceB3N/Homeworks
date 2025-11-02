// This class prints out a grid of numbers with special rules for each
// @Author (Sabrina Hong)
// @Date (11/2/25)
import java.util.*;
public class Main
{
    // Nums in odd rows are incremented by 1 and start at 1
    // Nums in even rows are incremented by 2 and start at 2
    // Nums in odd columns are then squared
	public static void main(String[] args) {
	    final int ODD_ROW_START = 2;
        final int EVEN_ROW_START = 1;
        final int ODD_ROW_ADD = 2;
        final int EVEN_ROW_ADD = 1;
        
        int increment;
        int countNum;
        //Get grid dimensions from user input
	    Scanner s = new Scanner(System.in);
	    System.out.println("Please enter column and row size for the grid.")
	    int columns = s.nextInt();
	    int rows = s.nextInt();
	    s.close();
	    
		for(int row=0;row<rows;row++){
		    for(int col=0;col<columns;col++){
		        //Nums in even rows are incremented by 2 and start at 2
		        if(row%2==0){
		            increment = EVEN_ROW_ADD;
		            countNum = EVEN_ROW_START;
		            for(int count=0;count<(columns*row/2)+col;count++){
		                countNum+=increment;
		            }
		        }
		        // Nums in odd rows are incremented by 1 and start at 1
		        else{
		            increment = ODD_ROW_ADD;
		            countNum = ODD_ROW_START;
		            for(int count=0;count<(columns*(row-1)/2)+col;count++){
		                countNum+=increment;
		            }
		        }
		        // Nums in odd columns are then squared, otherwise not
		        if(col%2==0)
		            System.out.printf("%-5d",countNum);
		        else
		            System.out.printf("%-5d",countNum*countNum);
		    }
		    System.out.println("");
		}
	}
}
