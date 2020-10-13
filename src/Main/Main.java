package Main;
import Main.Classes.Monopoly;

public class Main {
    public static void main(String[] args) {
        final int PLAYER_COUNT = 2;
        final int INITIAL_DOLLAR_COUNT = 1500;

        Monopoly.play(PLAYER_COUNT, INITIAL_DOLLAR_COUNT);
    }
}