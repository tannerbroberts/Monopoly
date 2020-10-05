import java.util.ArrayList;

public class Board {
    private final ArrayList<Space> spaces;
    private ArrayList<Trade> trades;

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
    }

    public void postTrade(Player giver, int dollarOffer, ArrayList<Property> propertyOffer, int dollarRequest, ArrayList<Property> propertyRequest) {
        trades.add(
                new Trade(
                    giver,
                    dollarOffer,
                    propertyOffer,
                    dollarRequest,
                    propertyRequest));
    }

    public String tradesListTranscript() {

        StringBuilder sb = new StringBuilder();
        sb.append("Trades List:\n");
        for (int i = 0; i < trades.size(); i++) {
            sb.append("(");
            sb.append(i);
            sb.append(") ");
            sb.append(trades.toString());
            sb.append("\n");
        }

        return sb.toString();
    }

    public int tradeListSize() {

        return trades.size();
    }
}