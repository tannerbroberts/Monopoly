package SpaceClasses;

import Main.Player;

public class GO extends Space {

    public GO(String name, int cost) {
        super(name, cost);

    }

    @Override
    public void interact(Player player) {

        System.out.print(player.getName() + " passed go! ");
        player.setDollarCount(cost);
    }
}