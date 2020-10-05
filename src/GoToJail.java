public class GoToJail extends Space{

    public GoToJail(String name) {
        super(name, 0);
    }

    @Override
    public void interact(Player player) {
        System.out.println(player.getName() + " goes to jail, goes DIRECTLY to jail, does not pass GO, does not collect $200");

        player.goToJail();
    }
}
