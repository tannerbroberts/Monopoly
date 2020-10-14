package Main.Classes;

import SpaceClasses.Property;

import java.util.ArrayList;

public class Trade {
    Player tradePoster;

    ArrayList<Property> propertiesOffer;
    int dollarOffer;

    ArrayList<Property> propertyRequest;
    int dollarRequest;

    public Trade(Player tradePoster) {
        this.tradePoster = tradePoster;
        this.propertiesOffer = new ArrayList<>();
        this.propertyRequest = new ArrayList<>();
    }

    public void makeItHappen(Player taker) {
        if (dollarOffer != 0) {
            tradePoster.setDollarCount(-dollarOffer);
            taker.setDollarCount(dollarOffer);
        }
        if (dollarRequest != 0) {
            tradePoster.setDollarCount(dollarRequest);
            taker.setDollarCount(-dollarRequest);
        }

        for (Property p : propertiesOffer) {
            p.setOwner(taker);
            tradePoster.removeProperty(p);
            taker.addProperty(p);
        }
        for (Property p : propertyRequest) {
            p.setOwner(tradePoster);
            taker.removeProperty(p);
            tradePoster.addProperty(p);
        }
        // remove the trade from the list that it exists in
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(tradePoster);
        sb.append(" ->(");
        if (dollarOffer != 0) {
            sb.append("$");
            sb.append(dollarOffer);
        }
        if (propertiesOffer.size() > 0 && dollarOffer != 0) sb.append(", ");
        for (int i = 0; i < propertiesOffer.size(); i++) {
            sb.append(propertiesOffer.get(i));
            if (i < propertiesOffer.size() - 1) sb.append(", ");
        }
        sb.append(")\n");

        sb.append(String.format(("%" + tradePoster.getName().length() + "s"), " <-("));
        if (dollarRequest != 0) {
            sb.append("$");
            sb.append(dollarRequest);
        }
        if (propertyRequest.size() > 0 && dollarRequest != 0) sb.append(", ");
        for (int i = 0; i < propertyRequest.size(); i++) {
            sb.append(propertyRequest.get(i));
            if (i < propertyRequest.size() - 1) sb.append(", ");
        }
        sb.append(")");

        return sb.toString();
    }
}