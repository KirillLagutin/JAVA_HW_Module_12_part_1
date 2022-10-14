import java.io.Serializable;

public class Pizza implements Serializable {
    String name;
    boolean olives, capers, extraCheese;

    public Pizza(String name) {
        this.name = name;
    }

    public Pizza(String name, boolean olives, boolean capers, boolean extraCheese) {
        this.name = name;
        this.olives = olives;
        this.capers = capers;
        this.extraCheese = extraCheese;
    }
}
