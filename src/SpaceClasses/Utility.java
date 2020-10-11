package SpaceClasses;

import java.util.Random;

public class Utility extends Property {
    int one, two;

    public Utility(char type, String name, int cost, int one, int two) {
        super(type, name, cost, 0);

        this.one = one;
        this.two = two;
    }

    @Override
    protected int getRent() {
        switch (developmentSize) {
            case 0: return (new Random().nextInt(6) + new Random().nextInt(6) + 2) * this.one;
            case 1: return (new Random().nextInt(6) + new Random().nextInt(6) + 2) * this.two;
            default: return -1;
        }
    }

    @Override
    public void setDevelopmentSize(int developmentSize) {

        this.developmentSize = developmentSize;

        switch (developmentSize) {
            case 0: System.out.println(this.name + " is no longer part of a Monopoly.   :(");
            case 1: System.out.println(this.name + " IS NOW PART OF A MONOPOLY!");
        }
    }
}