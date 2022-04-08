import java.util.InputMismatchException;
import java.util.Scanner;

//assumption - negative array values for drop if not possible
public class Controller {
    static boolean p1turn = true;
    static Board b = new Board();

    public static void main(String[] args){
        Scanner s = new Scanner(System.in); 
        int t;
        while(true){
            try{
            t = 1;
            View.display(b.get_B());
            if(!p1turn){
                t = 2;
                System.out.println("Player 2: Input the cell you wish to drop your token.");
            }
            else{
                System.out.println("Player 1: Input the cell you wish to drop your token.");
            }

            int c = s.nextInt();
            int[] d = b.drop(t, c);

            if(d[0] < 0){
                throw new InputMismatchException();
            }

            if(b.game_end(t, d[0], d[1])){
        
                System.out.println("Game Over!");
                s.close();
                return;
            }
            change_turn();

            }

            catch(InputMismatchException e){
                System.out.println("Try again");
                continue;
            }

        }

    }

    private static void change_turn(){
        p1turn = !p1turn;
    }



}
