public class Jail extends Space{

    public Jail(String name, int cost) {
        super(name, cost);
    }

    @Override
    public void interact(Player player) {
        // unlike every other space, this interaction takes place BEFORE the dice are rolled
        // this is written into the Player play() function.

        if(player.isInJail() && player.getJailSentence() > 0) {

            while (true) {

                if(player.hasPass()) System.out.println("roll, pay, card");
                System.out.println("roll , pay");

                String[] strings = {"roll", "pay", "card"};
                String answer = MyInput.validate_string(strings);
                if(answer.equals("roll")) {
                    if(Player.doubles()) {
                        System.out.println(name + " rolled doubles!");
                        player.setInJail(false);
                        player.setJailSentence(0);
                        player.noJailPlay();
                    } else {
                        System.out.println(name + " didn't roll doubles");
                        player.setJailSentence(player.getJailSentence() - 1);
                        if(player.getJailSentence() == 0) {
                            player.setDollarCount(-1 * this.cost);
                            player.setInJail(false);
                            System.out.println(player.getName() + " payed " + this.cost + " after their third roll for doubles");
                            player.noJailPlay();
                        }
                    }
                    return;
                }
                else if(answer.equals("pay")) {
                    System.out.print("payed to get out, ");
                    player.setDollarCount(-1 * cost);
                    player.setInJail(false);
                    player.setJailSentence(0);
                    player.noJailPlay();
                    return;
                }
                else if(answer.equals("card") && player.hasPass()) {
                    player.setGetOutOfJailFreeOwnership(false);
                    player.setInJail(false);
                    player.setJailSentence(0);
                    System.out.println(player.getName() + " used a card to get out of jail");
                    player.noJailPlay();
                    return;
                }
                else {
                    System.out.println("bad input");
                }
            }
        }

            // TODO: 4/22/20 this isn't right, if the player ROLLS for the third time and doesn't get doubles,
            // TODO: 4/22/20 they automatically pay $50 and get out of jail on that turn

    }
}