package Main.Classes;

import SpaceClasses.Property;

import java.util.ArrayList;

public class Trade {
    Player giver;

    ArrayList<Property> propertiesOffer;
    int dollarOffer;

    ArrayList<Property> propertyRequest;
    int dollarRequest;

    public Trade(Player giver) {
        this.giver = giver;
        this.propertiesOffer = new ArrayList<>();
        this.propertyRequest = new ArrayList<>();
    }

    public void makeItHappen(Player taker) {
        System.out.println("We can't actually trade yet...");
        // TODO: 4/9/20 ... make it happen?
        // remove the trade from the list that it exists in
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(giver);
        sb.append(" ->($");
        sb.append(dollarOffer);
        if(propertiesOffer.size() > 0) sb.append(", ");
        for (int i = 0; i < propertiesOffer.size(); i++) {
            sb.append(propertiesOffer.get(i));
            if(i < propertiesOffer.size() - 1) sb.append(", ");
        }
        sb.append(")");

        sb.append("          <-($");
        sb.append(dollarRequest);
        if(propertyRequest.size() > 0) sb.append(", ");
        for (int i = 0; i < propertyRequest.size(); i++) {
            sb.append(propertyRequest.get(i));
            if(i < propertyRequest.size() -1) sb.append(", ");
        }
        sb.append(")");

        return sb.toString();
    }
}