package SpaceClasses;

import Main.Player;

public class Tax extends Space {

    public Tax(String name, int cost) {
        super(name, cost);
    }

    @Override
    public void interact(Player player) {

        System.out.println(player.getName() + " got ROASTED!" + " by " + this.name);

        player.setDollarCount(-1 * this.cost);
    }
}
