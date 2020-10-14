package SpaceClasses;

import Main.Classes.Player;

import java.util.Random;

public class ChanceCard extends Space {
    private static final Random random = new Random();

    public ChanceCard() {

        super("Chance", 0);
    }

    @Override
    public void interact(Player player) {

        System.out.print("Chance: ");

        switch (random.nextInt(15)) {
            case 0:
                goBackThreeSpaces(player);
                break;
            case 1:
                electedChairmanOfTheBoard(player);
                break;
            case 2:
                goToJail(player);
                break;
            case 3:
                goToReadingRailroad(player);
                break;
            case 4:
                generalRepairs(player);
                break;
            case 5:
                goToSaintCharlesPlace(player);
                break;
            case 6:
                goToIllinoisAvenue(player);
                break;
            case 7:
                payMoreForUtility(player);
                break;
            case 8:
                goToBoardwalk(player);
                break;
            case 9:
                advanceToGo(player);
                break;
            case 10:
                buildingAndLoan(player);
                break;
            case 11:
                speedingFine(player);
                break;
            case 12:
            case 13:
                payMoreForRailroad(player);
                break;
            case 14:
                getOutOfJailFree(player);
        }
    }

    private void goBackThreeSpaces(Player player) {

        System.out.println("go back three spaces");

        player.moveSpecificAmount(-3);
    }

    private void electedChairmanOfTheBoard(Player player) {

        System.out.println("you are elected chairman of the board. Pay each player $50");

        for (Player otherPlayer: player.getOtherPlayers()) {
            player.setDollarCount(-50);
            otherPlayer.setDollarCount(50);
        }
    }

    private void goToJail(Player player) {

        System.out.println("go to jail, go directly to jail, do not pass go, do not collect $200");

        player.goToJail();
    }

    private void goToReadingRailroad(Player player) {

        System.out.println("advance to reading railroad");

        player.moveToSpecificSpace(5);
    }

    private void generalRepairs(Player player) {

        System.out.println("you are assessed for general repairs. pay $25 per house you own and $125 for every hotel");

        int repairCost = 0;
        for (Property property: player.getProperties()) {
            if(property instanceof ColorProperty && property.developmentSize > 0) {
                repairCost += property.developmentSize*25;
            }
        }
        System.out.println(player.getName() + " payed $" + repairCost + " for property repairs");
    }

    private void goToSaintCharlesPlace(Player player) {

        System.out.println("advance to st. charles place");

        player.moveToSpecificSpace(11);
    }

    private void payMoreForRailroad(Player player) {

        System.out.println("advance to the nearest railroad. If unowned, you may purchase it. If owned, pay the owner twice the rent to which they are otherwise entitled.");

        int location = player.getLocation();
        location += 5 - (player.getLocation() % 5);
        if(location % 10 == 0) location += 5;

        player.moveToSpecificSpace(location);
        player.interactWithSpace(player.getBoard().get(location));
        player.interactWithSpace(player.getBoard().get(location));
    }

    private void payMoreForUtility(Player player) {

        System.out.println("advance to the nearest utility, if unowned, pay the owner twice... just roll twice");

        if(player.getLocation() < 12) {
            player.moveToSpecificSpace(12);
        }else if(player.getLocation() < 28) {
            player.moveToSpecificSpace(28);
        }

        player.interactWithSpace(player.getBoard().get(player.getLocation()));
        player.interactWithSpace(player.getBoard().get(player.getLocation()));
    }

    private void goToBoardwalk(Player player) {

        System.out.println("advance to boardwalk ");
        player.moveToSpecificSpace(39);
    }

    private void advanceToGo(Player player) {

        System.out.println("advance to go ");
        player.moveToSpecificSpace(0);
    }

    private void buildingAndLoan(Player player) {

        System.out.println("your building and loan matures ");
        player.setDollarCount(150);
    }

    private void speedingFine(Player player) {

        System.out.print("speeding fine\n");
        player.setDollarCount(-15);
    }

    private void goToIllinoisAvenue(Player player) {

        System.out.println("advance to illinois avenue");
        player.moveToSpecificSpace(24);
    }

    private void getOutOfJailFree(Player player) {

        player.setGetOutOfJailFreeOwnership(true);
        System.out.println(player.getName() + " got a get out of jail free card");
    }
}