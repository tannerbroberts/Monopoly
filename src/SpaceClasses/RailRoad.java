package SpaceClasses;

public class RailRoad extends Property {

    private final int one;
    private final int two;
    private final int three;
    private final int four;
    // developmentSize legend: one railroad, two, three, four railroads owned all by the same person... pretty simple.

    public RailRoad(String name, int purchaseCost, int one, int two, int three, int four) {
        super(name, purchaseCost);
        this.one = one;
        this.two = two;
        this.three = three;
        this.four = four;
    }

    @Override
    protected int getRent() {
        switch (developmentSize) {
            case 0:
                return one;
            case 1: return two;
            case 2: return three;
            case 3: return four;
            default: return -1;
        }
    }

    @Override
    public void setDevelopmentSize(int developmentSize) {

        this.developmentSize = developmentSize;
    }
}
