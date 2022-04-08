public class View {



    public static void display(int[][] Board){
        for(int j = 0 ; j < Board[0].length ; j++){
            for(int i = 0 ; i < Board.length; i++){
                int t = Board[i][j];
                if(t == 0){
                    System.out.print(" | " + Integer.toString(t) + " | ");
                }
                else if(t == 1){
                    System.out.print(" | " + "R" + " | ");
                }
                else{
                    System.out.print(" | " + "B" + " | ");
                }
            }
            System.out.println();
        }
    }
}
