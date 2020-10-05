import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MyInput {
    public static int get_int() {
        while(true) {
            try {
                System.out.print("int:");
                return new Scanner(System.in).nextInt();
            }catch(InputMismatchException e) {
                System.out.println("bad input, you need an integer");
            }
        }
    }

    public static float get_float() {
        while(true) {
            try {
                System.out.print("float:");
                return new Scanner(System.in).nextFloat();
            }catch(InputMismatchException e) {
                System.out.println("bad input, you need a float");
            }
        }
    }

    public static String get_string() {
        while(true) {
            try {
                System.out.print("string:");
                return new Scanner(System.in).next();
            }catch(InputMismatchException e) {
                System.out.println("bad input, you need a string");
            }
        }
    }

    public static String validate_string(String[] acceptable_inputs) {
        while(true) {
            try {
                for (String word: acceptable_inputs) System.out.print(" " + word);
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
        while(true) {
            try {
                System.out.print("int:");
                int return_value = new Scanner(System.in).nextInt();
                if(return_value >= inclusive_lower && return_value <= inclusive_upper) return return_value;
            }catch(InputMismatchException e) {
                System.out.println("bad input, you need an integer");
            }
        }
    }
}