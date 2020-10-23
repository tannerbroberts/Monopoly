package Main.Classes;

import SpaceClasses.Property;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MyInput {
    public static int get_int() {
        while (true) {
            try {
                System.out.print("int:");
                return new Scanner(System.in).nextInt();
            }catch(InputMismatchException e) {
                System.out.println("bad input, you need an integer");
            }
        }
    }

    public static float get_float() {
        while (true) {
            try {
                System.out.print("float:");
                return new Scanner(System.in).nextFloat();
            } catch (InputMismatchException e) {
                System.out.println("bad input, you need a float");
            }
        }
    }

    public static Player get_player(ArrayList<Player> players) {
        for (Player player : players) {
            System.out.println(player.getName());
        }

        do {
            System.out.print("Enter player name: ");
            String chosenPlayer = get_string();
            for (Player player : players) {
                if (player.getName().equals(chosenPlayer)) {
                    return player;
                }
            }
            System.out.println("That's not a player's name");
        } while (true);
    }

    public static String get_string() {
        while (true) {
            try {
                System.out.print("string:");
                return new Scanner(System.in).nextLine();
            } catch (InputMismatchException e) {
                System.out.println("bad input, you need a string");
            }
        }
    }

    public static String validate_string(String[] acceptable_inputs) {
        while(true) {
            try {
                for (String word : acceptable_inputs) System.out.print(word + ".");
                System.out.print(":");
                String return_value = new Scanner(System.in).next();
                for(String word: acceptable_inputs) if(return_value.equals(word)) return return_value;
                System.out.println("that's not one of the words");
            }catch(InputMismatchException e) {
                System.out.println("bad input, you need one of the words presented");
            }
        }
    }

    public static int validate_integer(int inclusive_upper, int inclusive_lower) {
        while (true) {
            try {
                System.out.print("int:");
                int return_value = new Scanner(System.in).nextInt();
                if (return_value >= inclusive_lower && return_value <= inclusive_upper) return return_value;
            } catch (InputMismatchException e) {
                System.out.println("bad input, you need an integer");
            }
        }
    }

    public static Property get_property_from_player_list(Player player_im_asking_from) {

        if (player_im_asking_from.getProperties().size() == 0) {
            System.out.println("That player owns no properties");
            return null;
        }
        while (true) {
            for (Property property :
                    player_im_asking_from.getProperties()) {
                System.out.println(property.toString());
            }

            String property_name_input = get_string();
            if (property_name_input.equals("cancel")) return null;

            for (Property property :
                    player_im_asking_from.getProperties()) {
                if (property.name.equals(property_name_input)) {
                    return property;
                }
            }
            System.out.println("Can't ask for that... That wasn't one of the options");
        }
    }
}