package SpaceClasses;

public class SpaceBuilder {

    private static final int

            MONEY_FOR_PASSING_GO = 200,
            BAIL_COST = 50,
            INCOME_TAX = 200,
            LUXURY_TAX = 75,

    // associated Railroad values

    RR_cost = 200,
            RR1 = 25,
            RR2 = 50,
            RR3 = 100,
            RR4 = 200,

    // associated utility values

    U_cost = 150,
            U1 = 4,
            U2 = 10,

    // associated property values

    // first side
    br_a_cost = 60,
            br_build_cost = 50,
            br_a_rent = 2,
            br_a1 = 10,
            br_a2 = 30,
            br_a3 = 90,
            br_a4 = 160,
            br_a5 = 250,
            br_b_cost = 60,
            br_b_rent = 4,
            br_b1 = 8,
            br_b2 = 20,
            br_b3 = 60,
            br_b4 = 180,
            br_b5 = 450,

    lb_a_cost = 100,
            lb_build_cost = 50,
            lb_a_rent = 6,
            lb_a1 = 30,
            lb_a2 = 90,
            lb_a3 = 270,
            lb_a4 = 400,
            lb_a5 = 550,
            lb_b_cost = 120,
            lb_b_rent = 8,
            lb_b1 = 40,
            lb_b2 = 100,
            lb_b3 = 300,
            lb_b4 = 450,
            lb_b5 = 600,

    // second side
    pk_a_cost = 140,
            pk_build_cost = 100,
            pk_a_rent = 10,
            pk_a1 = 50,
            pk_a2 = 150,
            pk_a3 = 450,
            pk_a4 = 625,
            pk_a5 = 750,
            pk_b_cost = 160,
            pk_b_rent = 12,
            pk_b1 = 60,
            pk_b2 = 180,
            pk_b3 = 500,
            pk_b4 = 700,
            pk_b5 = 900,

    o_a_cost = 180,
            o_build_cost = 100,
            o_a_rent = 14,
            o_a1 = 70,
            o_a2 = 200,
            o_a3 = 550,
            o_a4 = 750,
            o_a5 = 950,
            o_b_cost = 200,
            o_b_rent = 16,
            o_b1 = 80,
            o_b2 = 220,
            o_b3 = 600,
            o_b4 = 800,
            o_b5 = 1000,

    // third side
    r_a_cost = 220,
            r_build_cost = 150,
            r_a_rent = 18,
            r_a1 = 90,
            r_a2 = 250,
            r_a3 = 700,
            r_a4 = 875,
            r_a5 = 1050,
            r_b_cost = 240,
            r_b_rent = 20,
            r_b1 = 100,
            r_b2 = 300,
            r_b3 = 750,
            r_b4 = 925,
            r_b5 = 1100,

    y_a_cost = 260,
            y_build_cost = 150,
            y_a_rent = 22,
            y_a1 = 110,
            y_a2 = 330,
            y_a3 = 800,
            y_a4 = 975,
            y_a5 = 1150,
            y_b_cost = 280,
            y_b_rent = 24,
            y_b1 = 120,
            y_b2 = 360,
            y_b3 = 850,
            y_b4 = 1025,
            y_b5 = 1200,

    // fourth side
    g_a_cost = 300,
            g_build_cost = 200,
            g_a_rent = 26,
            g_a1 = 130,
            g_a2 = 390,
            g_a3 = 900,
            g_a4 = 1100,
            g_a5 = 1275,
            g_b_cost = 320,
            g_b_rent = 28,
            g_b1 = 150,
            g_b2 = 450,
            g_b3 = 1000,
            g_b4 = 1200,
            g_b5 = 1400,

    b_a_cost = 350,
            b_build_cost = 200,
            b_a_rent = 35,
            b_a1 = 175,
            b_a2 = 500,
            b_a3 = 1100,
            b_a4 = 1300,
            b_a5 = 1500,
            b_b_cost = 400,
            b_b_rent = 50,
            b_b1 = 200,
            b_b2 = 600,
            b_b3 = 1400,
            b_b4 = 1700,
            b_b5 = 2000;

    public static Space make(int n) {

        switch (n) {
            case 0:
                return new GO("Go", MONEY_FOR_PASSING_GO);
            case 1:
                return new ColorProperty("brown1", br_a_cost, br_a_rent, br_a1, br_a2, br_a3, br_a4, br_a5);
            case 2:
                return new CommunityChest(0);
            case 3:
                return new ColorProperty("brown2", br_b_cost, br_b_rent, br_b1, br_b2, br_b3, br_b4, br_b5);
            case 4:
                return new Tax("INCOME TAX", INCOME_TAX);
            case 5:
                return new RailRoad("RR", RR_cost, RR1, RR2, RR3, RR4);
            case 6:
                return new ColorProperty("blue1", lb_a_cost, lb_a_rent, lb_a1, lb_a2, lb_a3, lb_a4, lb_a5);
            case 7:
                return new ChanceCard();
            case 8:
                return new ColorProperty("blue2", lb_a_cost, lb_a_rent, lb_a1, lb_a2, lb_a3, lb_a4, lb_a5);
            case 9:
                return new ColorProperty("blue3", lb_b_cost, lb_b_rent, lb_b1, lb_b2, lb_b3, lb_b4, lb_b5);
            case 10:
                return new Jail("Jail", BAIL_COST);
            case 11:
                return new ColorProperty("pink1", pk_a_cost, pk_a_rent, pk_a1, pk_a2, pk_a3, pk_a4, pk_a5);
            case 12:
                return new Utility('0', "Electric Company", U_cost, U1, U2);
            case 13:
                return new ColorProperty("pink2", pk_a_cost, pk_a_rent, pk_a1, pk_a2, pk_a3, pk_a4, pk_a5);
            case 14:
                return new ColorProperty("pink3", pk_b_cost, pk_b_rent, pk_b1, pk_b2, pk_b3, pk_b4, pk_b5);
            case 15:
                return new RailRoad("Pennsylvania Railroad", RR_cost, RR1, RR2, RR3, RR4);
            case 16:
                return new ColorProperty("orange1", o_a_cost, o_a_rent, o_a1, o_a2, o_a3, o_a4, o_a5);
            case 17:
                return new CommunityChest(1);
            case 18:
                return new ColorProperty("orange2", o_a_cost, o_a_rent, o_a1, o_a2, o_a3, o_a4, o_a5);
            case 19:
                return new ColorProperty("orange3", o_b_cost, o_b_rent, o_b1, o_b2, o_b3, o_b4, o_b5);
            case 20:
                return new FreeParking();
            case 21:
                return new ColorProperty("red1", r_a_cost, r_a_rent, r_a1, r_a2, r_a3, r_a4, r_a5);
            case 22:
                return new ChanceCard();
            case 23:
                return new ColorProperty("red2", r_a_cost, r_a_rent, r_a1, r_a2, r_a3, r_a4, r_a5);
            case 24:
                return new ColorProperty("red3", r_b_cost, r_b_rent, r_b1, r_b2, r_b3, r_b4, r_b5);
            case 25:
                return new RailRoad("BnO", RR_cost, RR1, RR2, RR3, RR4);
            case 26:
                return new ColorProperty("yellow1", y_a_cost, y_a_rent, y_a1, y_a2, y_a3, y_a4, y_a5);
            case 27:
                return new ColorProperty("yellow2", y_a_cost, y_a_rent, y_a1, y_a2, y_a3, y_a4, y_a5);
            case 28:
                return new Utility('0', "Water Works", U_cost, U1, U2);
            case 29:
                return new ColorProperty("yellow3", y_b_cost, y_b_rent, y_b1, y_b2, y_b3, y_b4, y_b5);
            case 30:
                return new GoToJail("Go to Jail");
            case 31:
                return new ColorProperty("green1", g_a_cost, g_a_rent, g_a1, g_a2, g_a3, g_a4, g_a5);
            case 32:
                return new ColorProperty("green2", g_a_cost, g_a_rent, g_a1, g_a2, g_a3, g_a4, g_a5);
            case 33:
                return new CommunityChest(2);
            case 34:
                return new ColorProperty("green3", g_b_cost, g_b_rent, g_b1, g_b2, g_b3, g_b4, g_b5);
            case 35:
                return new RailRoad("Short Line", RR_cost, RR1, RR2, RR3, RR4);
            case 36:
                return new ChanceCard();
            case 37:
                return new ColorProperty("Park Place", b_a_cost, b_a_rent, b_a1, b_a2, b_a3, b_a4, b_a5);
            case 38:
                return new Tax("LUXURY TAX", LUXURY_TAX);
            case 39:
                return new ColorProperty("Board Walk", b_b_cost, b_b_rent, b_b1, b_b2, b_b3, b_b4, b_b5);
            default:
                return null;
        }
    }
}