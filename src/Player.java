import java.util.ArrayList;
import java.util.Random;

public class Player {
    private static final Random random = new Random();

    private final String name;
    private int dollarCount;
    private final Board board;
    private int location;
    private ArrayList<Player> otherPlayers;
    private ArrayList<Property> properties;

    private boolean inJail = false;
    private int jailSentence = 0;
    private boolean getOutOfJailFree;

    public Player(int dollarCount, Board board, ArrayList<Player> otherPlayers) {

        System.out.print("Player name: ");
        this.name = MyInput.get_string();

        this.dollarCount = dollarCount;

        this.location = 0;
        System.out.println(name + " has been added with $" + dollarCount + " on the GO space");

        this.board = board;

        this.otherPlayers = otherPlayers;

        this.properties = new ArrayList<>();

        this.getOutOfJailFree = false;
    }

    public void takeTurn() {

        if(inJail) interactWithSpace(board.get(10));
        else noJailPlay();
    }

    public void noJailPlay() {

        interactWithSpace(myNewLocationAfterRolling());

        while (true) {
            System.out.print("pass, trade, post, build, mortgage: ");

            String[] acceptable_strings = {"pass", "trade", "post", "build", "mortgage"};
            switch (MyInput.validate_string(acceptable_strings)) {
                case "post": {
                    makeTrade();
                }
                break;
                case "trade": {
                    trade();
                }
                break;
                case "mortgage": {
                    mortgage();
                }
                break;
                case "build": {
                    build();
                }
                break;
                case "pass": {
                    return;
                }
                default: {
                    System.out.println("bad input");
                }
            }
        }
    }

    public void trade() {
        while (true) {
            System.out.print("take, make: ");

            String[] acceptable_strings = {"take", "make"};
            switch (MyInput.validate_string(acceptable_strings)) {
                case "take": {
                    takeTrade();
                    return;
                }
                case "make": {
                    makeTrade();
                    return;
                }
                default: {
                    System.out.println("bad input");
                }
            }
        }
    }

    public void takeTrade() {

        if(board.tradeListSize() == 0) {
            System.out.println("no trades available");
            return;
        }

        System.out.println(board.tradesListTranscript());
        int input = MyInput.validate_integer(board.tradeListSize() - 1, 0);
        board.takeTrade(input, this);
    }

    public void makeTrade() {

        while(true) {
            System.out.print("offer, ask, done: ");
            String[] acceptable_strings = {"offer", "ask", "done"};
            switch (MyInput.validate_string(acceptable_strings)) {
                case "offer": {
                    offer();
                }
                case "ask": {
                    ask();
                }
                case "done": {
                    break;
                }
            }
        }
    }

    public void offer() {
        // get the list of properties offered
        while(properties.size() > 0) {
            
        }

        // get the dollar amount offered
    }

    public void ask() {

    }

    public void mortgage() {

        System.out.println("not happening yet");

        // print a list of owned properties and their mortgage values

        // pick from a list of properties that you own
    }

    public void build() {


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

    public static boolean doubles() {

        return random.nextInt(6) == 0;
    }

    public int getDollarCount() {

        return dollarCount;
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
    }

    public void removeProperty(Property property) {

        properties.remove(property);
    }

    public boolean isInJail() {

        return inJail;
    }

    public void setInJail(boolean inJail) {

        this.inJail = inJail;
    }

    public int getJailSentence() {

        return jailSentence;
    }

    public void setJailSentence(int jailSentence) {

        this.jailSentence = jailSentence;
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