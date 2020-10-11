package Main;

import java.util.ArrayList;

public class Monopoly {

    public static void play(int playerCount, int dollarCount) {
        ArrayList<Player> players = new ArrayList<>();
        Board board = new Board();

        boardSetup(playerCount, dollarCount, board, players);

        while (players.size() > 1) {
            for (int i = 0; i < players.size(); i++) {
                players.get(i).takeTurn();
                System.out.println();
            }
        }

        System.out.println(players.get(0).getName() + " wins!!!");
    }

    private static void boardSetup(int pc, int dc, Board board, ArrayList<Player> players) {
        for(int i = 0; i < pc; i++) {
            players.add(new Player(dc, board, players));
        }
    }
}