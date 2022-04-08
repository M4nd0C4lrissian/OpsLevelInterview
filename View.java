public class View {



    public static void display(int[][] Board){
        for(int i = Board.length - 1 ; i >= 0 ; i--){
            for(int j = Board[0].length - 1 ; j >= 0 ; j--){
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
