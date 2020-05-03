package ttn;
import java.util.*;
public class Main {


    public static void playGame(TTT game) {
        Scanner scan = new Scanner(System.in);
        game.initializeBoard();

        do {
            System.out.println("Current Board Layout : ");
            game.printBoard();
            int row;
            int col;
            do {

                System.out.println("player " + game.getCurrentPlayerMark() + ", enter an empty row and column to place your mark on the board !");
                row = scan.nextInt() - 1;
                col = scan.nextInt() - 1;


            }
            while (!game.placeMark(row, col));
            game.changePlayer();


        } while (!game.checkForWin() && !game.isBoardFull());
        if (game.isBoardFull() && !game.checkForWin()) {
            System.out.println("The game was a tie!");
        } else {
            System.out.println("Current board layout:");
            game.printBoard();
            game.changePlayer();
            System.out.println(Character.toUpperCase(game.getCurrentPlayerMark()) + " Wins the game!!!!");
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        TTT game = new TTT();
        char choice;
        System.out.println("Tic-Tac-Toe!");
        playGame(game);
        do {
            System.out.println("Do you want to continue the game again , enter yes for 'y' and no for 'n'");
            System.out.println("Enter your choice");
            choice = scan.next().charAt(0);
            switch (choice) {
                case 'y':
                case 'Y':
                    playGame(game);
                    break;
                case 'n':
                case 'N':
                    System.out.println("exit !!!!");
                    break;
                default:
                    System.out.println("you have enter the wrong choice..!!!");
            }
        } while (choice=='y' || choice=='Y');

    }
}
