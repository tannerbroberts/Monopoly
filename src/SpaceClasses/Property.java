package SpaceClasses;

import Main.Classes.MyInput;
import Main.Classes.Player;

public abstract class Property extends Space {
    protected Player owner;
    protected int developmentSize;
    protected boolean mortgaged;

    public Property(char type, String name, int cost, int developmentSize) {
        super(name, cost);
        this.developmentSize = developmentSize;
        mortgaged = false;
    }

    @Override
    public void interact(Player player) {
        if (owner == null) {
            System.out.print("buy " + this.name + " for $" + this.cost + "?\n");

            while (true) {
                String[] strings = {"y", "n"};
                switch (MyInput.validate_string(strings)) {
                    case "y": {
                        this.owner = player;
                        System.out.println(owner.getName() + " bought " + this.name);
                        player.addProperty(this);
                        player.setDollarCount(-1 * this.cost);
                        return;
                    }
                    case "n": {
                        System.out.println(player.getName() + " didn't buy " + this.name);
                        System.out.println("It should have gone to auction, but I'll write that code later");
                        return;
                    }
                    default:
                        System.out.println("enter y or n");
                }
            }
        } else if(!owner.equals(player)) {
            int amount = getRent();
            player.setDollarCount(-1 * amount);
            owner.setDollarCount(amount);
            System.out.println("(" + player.getName() + " payed " + owner.getName() + ") $" + amount);
        }
    }

    protected abstract int getRent();

    public abstract void setDevelopmentSize(int developmentSize);

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {

        return name;
    }
}