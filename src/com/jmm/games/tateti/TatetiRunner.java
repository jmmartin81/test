package com.jmm.games.tateti;

import java.util.Scanner;

public class TatetiRunner {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tateti Game!");
        Player p1 = new Player(),p2 = new Player();

        System.out.println("First Player, please Insert Your Name: ");
        p1.setName(scanner.nextLine());
        System.out.println("Choose between X or O: ");
        String selected = scanner.nextLine();
        char p1Character = validateCharacter(selected);
        p1.setChoose(p1Character);
        System.out.println("Second Player, please Insert Your Name: ");
        p2.setName(scanner.nextLine());
        p2.setChoose(characterVs(p1Character));

        boolean isGaming = true;
        BoardGame boardGame = new BoardGame();
        while (isGaming){
            boardGame.draw(p1.getChoose(),p2.getChoose());
            isGaming = selectMovement(scanner, p1, 1, boardGame);
            if (isGaming){
                boardGame.draw(p1.getChoose(),p2.getChoose());
                isGaming = selectMovement(scanner, p2, 2, boardGame);
            }
        }


    }

    private static boolean selectMovement(Scanner scanner, Player player,int order,BoardGame boardGame) {
        boolean isGaming = true;
        System.out.println(player.getName() +" choose a movement ("+ player.getChoose()+"), x: ");
        int xmove = validateChooseOption(scanner);
        System.out.println(player.getName() +" choose a movement ("+ player.getChoose()+"), y: ");
        int ymove = validateChooseOption(scanner);
        boolean validMove =  boardGame.setMove(order, xmove, ymove);

        while (!validMove) {
            System.out.println("Invalid movement");
            System.out.println(player.getName()  + "choose a movement ("+ player.getChoose()+"), x: ");
            xmove = validateChooseOption(scanner);
            System.out.println("First Player choose a movement ("+ player.getChoose()+"), y: ");
            ymove = validateChooseOption(scanner);
            validMove =  boardGame.setMove(1, xmove, ymove);
        }

        if (boardGame.winningMovement(xmove,ymove)){
            System.out.println(player.getName() +" is the WINNER!!! CONGRATS!!");
            isGaming = false;
        }else if (boardGame.isFull()){
            System.out.println(" Good battle!! PLEASE TRY IN ANOTHER MATCH");
            boardGame.draw(player.getChoose(), characterVs(player.getChoose()));
            isGaming = false;
        }
        return isGaming;
    }

    private static int validateChooseOption(Scanner scanner) {
        int choose = scanner.nextInt();
        if ((choose < 0 || choose > 2) ) {
            System.out.println("invalid Option, please enter a number from 0 to 2 ");
            return validateChooseOption(scanner);
        }else{
            return choose;
        }

    }

    private static char characterVs(char p1Character) {
        if (p1Character == 'O' || p1Character== 'o'){
            return 'X';
        }else {
            return 'O';
        }
    }

    private static char validateCharacter(String selected) {
        char[]array = selected.toCharArray();
        if (array.length ==1 && array[0] == 'O' ||array[0] == 'o' || array[0] == 'X' || array[0] == 'x'){
            return array[0];
        }else {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Invalid option, please Choose between X or O: ");
            return validateCharacter(scanner.nextLine());
        }
    }
}
