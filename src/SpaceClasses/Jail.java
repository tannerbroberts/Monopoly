package SpaceClasses;

import Main.Classes.MyInput;
import Main.Classes.Player;

public class Jail extends Space {

    public Jail(String name, int cost) {
        super(name, cost);
    }

    @Override
    public void interact(Player player) {
        // unlike every other space, this interaction takes place BEFORE the dice are rolled
        // this is written into the Player play() function.

        if (player.isInJail() && !player.timeToGetOutOfJail()) {

            while (true) {

                if (player.hasPass()) System.out.println("roll, pay, card");
                System.out.println("roll , pay");

                String[] strings = {"roll", "pay", "card"};
                String answer = MyInput.validate_string(strings);
                if (answer.equals("roll")) {
                    if (Player.doubles()) {
                        System.out.println(name + " rolled doubles!");
                        player.gotOutOfJail();
                        player.takeTurn();
                    } else {
                        System.out.println(name + " didn't roll doubles");
                        player.spentANightInJain();
                        if (player.timeToGetOutOfJail()) {
                            player.setDollarCount(-1 * this.cost);
                            player.setInJail(false);
                            System.out.println(player.getName() + " payed " + this.cost + " after their third roll for doubles");
                            player.takeTurn();
                        }
                    }
                    return;
                } else if(answer.equals("pay")) {
                    System.out.print("payed to get out, ");
                    player.setDollarCount(-1 * cost);
                    player.gotOutOfJail();
                    player.takeTurn();
                    return;
                } else if(answer.equals("card") && player.hasPass()) {
                    player.setGetOutOfJailFreeOwnership(false);
                    player.gotOutOfJail();
                    System.out.println(player.getName() + " used a card to get out of jail");
                    player.takeTurn();
                    return;
                } else {
                    System.out.println("bad input");
                }
            }
        }
    }
}