package SpaceClasses;

public class ColorProperty extends Property {

    private final int rent;
    private final int oneHouse;
    private final int twoHouse;
    private final int threeHouse;
    private final int fourHouse;
    private final int hotel;
    // developmentSize legend: 0 = rent, 1 = house, 2 = two house, 3 = three house, 4 = four house, 5 = hotel, 6 = double rent

    public ColorProperty(char color_type, String name, int buyCost, int rent, int oneHouse, int twoHouse, int threeHouse, int fourHouse, int hotel) {
        super(color_type, name, buyCost, 0);
        this.rent = rent;
        this.oneHouse = oneHouse;
        this.twoHouse = twoHouse;
        this.threeHouse = threeHouse;
        this.fourHouse = fourHouse;
        this.hotel = hotel;
    }

    @Override
    public int getRent() {
        switch (developmentSize) {
            case 0: return rent;
            case 1: return oneHouse;
            case 2: return twoHouse;
            case 3: return threeHouse;
            case 4: return fourHouse;
            case 5: return hotel;
            case 6: return rent*2;
            default: return -1;
        }
    }

    @Override
    public void setDevelopmentSize(int developmentSize) {

        this.developmentSize = developmentSize;

        switch (developmentSize) {
            case 0: System.out.println(this.name + " is no longer part of a Monopoly  ):"); break;
            case 1: System.out.println(this.name + " now has one house");
            case 2: System.out.println(this.name + " now has two houses");
            case 3: System.out.println(this.name + " now has three houses");
            case 4: System.out.println(this.name + " now has four houses");
            case 5: System.out.println(this.name + " NOW HAS A HOTEL!");
            case 6: System.out.println(this.name + " IS NOW A MONOPOLY!");
        }
    }
}