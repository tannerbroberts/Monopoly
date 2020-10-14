package Main.Classes;

import SpaceClasses.Space;
import SpaceClasses.SpaceBuilder;

import java.util.ArrayList;

public class Board {
    private final ArrayList<Space> spaces;
    private final ArrayList<Trade> trades;

    public Board() {

        spaces = new ArrayList<>();

        trades = new ArrayList<>();

        for (int i = 0; i < 40; i++) spaces.add(SpaceBuilder.make(i));
    }

    public Space get(int i) {

        return spaces.get(i);
    }

    public void takeTrade(int n, Player player) {

        trades.get(n).makeItHappen(player);
        trades.remove(n);
    }

    public void postTrade(Trade trade) {

        trades.add(trade);
    }

    public String tradesListTranscript() {

        StringBuilder sb = new StringBuilder();
        sb.append("Trades List:\n");
        for (int i = 0; i < trades.size(); i++) {
            sb.append(i);
            sb.append(") ");
            sb.append(trades.get(i).toString());
            sb.append("\n\n");
        }
        if (trades.size() == 0) sb.append("---no trades available---\n");

        return sb.toString();
    }

    public int tradeListSize() {

        return trades.size();
    }

    public ArrayList<Space> getSpaces() {
        return spaces;
    }
}