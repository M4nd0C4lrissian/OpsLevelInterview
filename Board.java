public class Board {
    //0 indicates empty cell, 1 for p1, 2 for p2
    private static int[][] Board = new int[7][6];
    
    public static void reset(){
        for(int i = 0 ; i < Board.length ; i++){
            for(int j = 0 ; j < Board[0].length ; j++){
                Board[i][j] = 0;
            }
        }
    }

    public int[][] get_B(){
        return Board;
    }


    public static void main(String[] args){
        Board B = new Board();
        B.drop(1,0);
    }

    //attempts to drop the token, returns false if invalid drop, else true
    public int[] drop(int t, int c){

        int[] index = new int[] {-1,-1};
        if(Board[c][0] != 0){
            return index;
        }
        for(int i = Board[c].length - 1; i >= 0 ; i--){
            if(Board[c][i] == 0){
                Board[c][i] = t;
                index[0] = c;
                index[1] = i;
                break;
            }
        }

        return index;
    }

    
    public boolean game_end(int t, int c, int r){
        return(check_h(t,c,r) || check_v(t, c, r) || check_neg_d(t, c, r) || check_pos_d(t, c, r));
    }
    


    //c,r are column and row of source node
    public static boolean check_h(int t, int c, int r){
        int count = 0;
        //boolean b = false;
        

        for(int i = Math.max(0, c - 3)  ; i <= Math.min(Board.length - 1, c+3) ; i++){
            if(Board[i][r] == t){
                count++;
                if(count >= 4){
                    return true;
                }
            }
            else{
                count = 0;
            }
        }
        return false;
    }

    public static boolean check_v(int t, int c, int r){
        int count = 0;
        //boolean b = false;
        

        for(int i = Math.max(0, r - 3)  ; i <= Math.min(Board[0].length - 1, r+3) ; i++){
            if(Board[c][i] == t){
                count++;
                if(count >= 4){
                    return true;
                }
            }
            else{
                count = 0;
            }
        }
        return false;
    }

    public static boolean check_neg_d(int t, int c, int r){
        int count = 0;
        int j = Math.max(0, r-3); 
        for(int i = Math.max(0, c-3) ; i < Math.min(Board.length, c+3); i++){
            if(j >= Board[0].length){
                break;
            }
            if(Board[i][j] == t){
                count++;
                if(count >= 4){
                    return true;
                }
            }
            else{
                count = 0;
            }
            j++;
        }
        return false;
    }

    public static boolean check_pos_d(int t, int c, int r){
        int count = 0;
        int j = Math.min(r+3, Board[0].length-1); 
        for(int i = Math.max(0, c-3) ; i < Math.min(Board.length, c+3); i++){
            if(j < 0){
                break;
            }
            if(Board[i][j] == t){
                count++;
                if(count >= 4){
                    return true;
                }
            }
            else{
                count = 0;
            }
            j--;
        }
        return false;
    }
    
}
