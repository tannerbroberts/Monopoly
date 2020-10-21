package Main.Classes;

import SpaceClasses.Property;
import SpaceClasses.Space;

import java.util.ArrayList;
import java.util.Random;

public class Player {
    private static final Random random = new Random();

    private final String name;
    private int dollarCount;
    private final Board board;
    private int location;
    private final ArrayList<Player> otherPlayers;
    private final ArrayList<Property> properties;

    private boolean inJail = false;
    private int jailSentence = 0;
    private boolean getOutOfJailFree;

    public Player(int dollarCount, Board board, ArrayList<Player> otherPlayers) {

        System.out.print("Player name: ");
        this.name = MyInput.get_string();

        this.dollarCount = dollarCount;

        this.location = 0;
        System.out.println(name + " has been added with $" + dollarCount + " on the " + board.get(location).name + " space");

        this.board = board;

        this.otherPlayers = otherPlayers;

        this.properties = new ArrayList<>();

        this.getOutOfJailFree = false;
    }

    public void takeTurn() {

        if (inJail) interactWithSpace(board.get(10));
        else interactWithSpace(myNewLocationAfterRolling());

        while (true) {
            String[] acceptable_strings = {"pass", "trade", "build", "mortgage"};
            switch (MyInput.validate_string(acceptable_strings)) {
                case "pass": {
                    return;
                }// no break statement needed
                case "trade": {
                    trade();
                }
                break;
                case "build": {
                    build();
                }
                break;
                case "mortgage": {
                    mortgage();
                }
                break;
                default: {
                    System.out.println("bad input");
                }
            }
        }
    }

    public void trade() {
        while (true) {

            System.out.print(board.tradesListTranscript());

            String[] acceptable_strings = {"list", "accept"};
            switch (MyInput.validate_string(acceptable_strings)) {
                case "list": {
                    list();
                    return;
                }
                case "accept": {
                    accept();
                    return;
                }
                default: {
                    System.out.println("bad input");
                }
            }
        }
    }

    public static boolean rolledDoubles() {

        return random.nextInt(6) == 0;
    }

    public void accept() {
        if (board.tradeListSize() == 0) {
            System.out.println("no trades available");
            return;
        }

        int input = MyInput.validate_integer(board.tradeListSize() - 1, 0);
        board.takeTrade(input, this);
    }

    public void list() {
        // get the list of properties offered, asked, and dollars offered/asked
        Trade trade = new Trade(this);

        boolean keepGoing = true;
        while (keepGoing) {
            System.out.println("Current Offer:\n" +
                    trade);


            String[] acceptable_strings = {"ask", "offer", "askd", "offerd", "done", "cancel"};
            switch (MyInput.validate_string(acceptable_strings)) {
                case "ask": {

                    Player playerImGoingToTradeWith = MyInput.get_player(board.getPlayers());
                    String input = MyInput.get_string();
                    boolean impossible = false;
                    for (Space s : board.getSpaces()) {
                        if (s.name.equals(input) && s instanceof Property) {
                            trade.propertyRequest.add((Property) s);
                        } else if (!(s instanceof Property)) {
                            impossible = true;
                        }
                    }
                    if (impossible) {
                        System.out.println("***ERROR: You can't even own that... What are you doing?");
                    }
                }
                break;
                case "offer": {
                    String input = MyInput.get_string();
                    for (Property p : this.properties) {
                        if (p.name.equals(input)) {
                            trade.propertiesOffer.add(p);
                            break;
                        } else {
                            System.out.println("player doesn't have the property: " + input);
                        }
                    }
                }
                break;
                case "askd": {
                    System.out.print("amount: ");
                    trade.dollarRequest = MyInput.get_int();
                    trade.dollarOffer = 0;
                }
                break;
                case "offerd": {
                    System.out.println("amount: ");
                    trade.dollarOffer = MyInput.get_int();
                    trade.dollarRequest = 0;
                }
                break;
                case "done": {
                    keepGoing = false;
                }
                break;
                case "cancel": {
                    return;
                }
                default: {
                    System.out.println("This shouldn't happened because of the validateInput function from MyInput class");
                }
            }
        }
        board.postTrade(trade);
    }

    public void mortgage() {

        System.out.println("not happening yet");

        // print a list of owned properties and their mortgage values

        // pick from a list of properties that you own
    }

    public void interactWithSpace(Space space) {

        space.interact(this);
    }

    public Space myNewLocationAfterRolling() {

        int diceRoll = diceRoll();

        moveSpecificAmount(diceRoll);

        System.out.println(this.name + " landed on " + board.get(location));

        return board.get(location);
    }

    public void moveSpecificAmount(int amount) {

        location += amount;

        if(location >= 39) {
            location -= 39;
            interactWithSpace(board.get(0));
        }
    }

    public void moveToSpecificSpace(int spaceNumber) {

        this.location = spaceNumber;

        interactWithSpace(board.get(location));
    }

    public int diceRoll() {

        int r1 = random.nextInt(6) + 1,
                r2 = random.nextInt(6) + 1;

        System.out.println(this.name + " rolled " + r1 + ", " + r2);

        return r1 + r2;
    }

    public void build() {
        // look for properties that the player can build on

        // print out possible build sites and the dollar cost of each

        // build in a loop, exiting only when the player says they are done

        // accept multiple build requests in a row, building each as if it were a separate transaction

        // print out error codes that don't break the game if a player enters bad input.
    }

    public void setDollarCount(int amount) {

        if(amount > 0) System.out.println(name + "  $" + amount);
        if(amount < 0) System.out.println(name + " -$" + (-1 * amount));

        this.dollarCount += amount;
    }

    public void goToJail() {
        location = 10;
        inJail = true;
        jailSentence = 2;
    }

    public int getLocation() {

        return location;
    }

    public ArrayList<Property> getProperties() {

        return properties;
    }

    public void addProperty(Property property) {

        properties.add(property);
        System.out.println(name + " + " + property.name);
    }

    public void removeProperty(Property property) {

        properties.remove(property);
        System.out.println(name + " - " + property.name);
    }

    public boolean isInJail() {

        return inJail;
    }

    public void setInJail(boolean inJail) {

        this.inJail = inJail;
    }

    public boolean timeToGetOutOfJail() {

        return jailSentence == 0;
    }

    public void spentANightInJain() {

        this.jailSentence -= 1;
    }

    public void gotOutOfJail() {
        this.inJail = false;
        this.jailSentence = 0;
    }

    public String getName() {

        return name;
    }

    public Board getBoard() {

        return board;
    }

    public ArrayList<Player> getOtherPlayers() {

        return otherPlayers;
    }

    public boolean hasPass() {

        return getOutOfJailFree;
    }

    public void setGetOutOfJailFreeOwnership(boolean getOutOfJailFree) {

        this.getOutOfJailFree = getOutOfJailFree;
    }

    @Override
    public String toString() {

        return this.name;
    }
}