package SpaceClasses;

import Main.Classes.Player;

public abstract class Space {
    public String name;
    public Integer cost;

    public Space(String name, int cost) {

        this.name = name;
        this.cost = cost;
    }

    public abstract void interact(Player player);

    @Override
    public String toString() {

        return name;
    }
}