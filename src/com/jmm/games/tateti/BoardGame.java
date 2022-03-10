package com.jmm.games.tateti;


public class BoardGame {
    public static final int INIT_VALUE = -10;
    int x_size = 3;
    int y_size = 3;
    int movements = 0;
    int [][] board = new int[x_size][y_size];
    void init(){
        for (int i=0; i < x_size; i ++ ){
            for (int j = 0; j < y_size; j++){
                board[i][j] = INIT_VALUE;
            }
        }
    }
    public BoardGame(){
        init();
    }
    public void draw(char first, char last){

        System.out.println("   Y_0 Y_1 Y_2");
        for (int x = 0; x < x_size; x ++){

           // sb.append("| ");
            System.out.println();
            System.out.print("X_"+x + " ");
            for (int y = 0; y < y_size; y++){
                if (board[x][y] == INIT_VALUE){
                    System.out.print(" - ");
                }else if (board[x][y]==1){
                    System.out.print(" "+ first+ " ");
                }else {
                    System.out.print(" "+ last+ " ");
                }
            }
        }
        System.out.println();
    }

    public boolean setMove(int type, int i, int j){

        if (board[i][j]!=INIT_VALUE){
           return false;
        }
        board[i][j] = type;
        movements++;
        return true;
    }
    public boolean isFull(){
        return movements == 9;
    }
    public boolean winningMovement(int x, int y) {
       if (isCorner(x,y)|| isCenter(x, y))  {
            return checkRow(y)|| checkColumn(x) || checkDiagonal(x,y);
        }else {
            return checkRow(y)|| checkColumn(x) ;
       }
    }

    private boolean isCenter(int x, int y) {
        return x == 1 && y == 1;
    }

    private boolean isCorner(int x, int y) {
        if ( (x == 0 && y==0)|| (x==0 && y == 2) || (x==2 && y == 0) || x == 2 && y == 2  ) {
            return true;
        }
        return false;
    }

    private boolean checkDiagonal(int x,int y) {
         if (x == 0){
             return  (board[0][0] != INIT_VALUE) && (board[0][0] == board[1][1]) && (board[0][0] == board[2][2]);
         }else if (x == x_size-1) {
            return  (board[2][0] != INIT_VALUE) && (board[2][0] == board[1][1]) && (board[2][0] == board[0][2]);
        }else if (isCenter(x,y) ) { //is center
            return  ((board[0][0] != INIT_VALUE) && (board[0][0] == board[1][1]) && (board[0][0] == board[2][2]))
                    ||( (board[2][0] != INIT_VALUE) && (board[2][0] == board[1][1]) && (board[2][0] == board[0][2]));
        }
        return false;
    }

    private boolean checkRow( int y) {
           return  (board[0][y] != INIT_VALUE) && (board[0][y] == board[1][y]) &&  (board[1][y] == board[2][y]);
    }
    private boolean checkColumn( int x) {
        return   (board[x][0] != INIT_VALUE)  && (board[x][0] == board[x][1]) && (board[x][1] == board[x][2]);
    }

}
