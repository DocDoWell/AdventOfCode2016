package src;

import java.util.HashSet;
import java.util.Set;

public class BagPartTwo {
    private String colour;
    private int amount;
    private Set<BagPartTwo> contains = new HashSet<>();

    public BagPartTwo(String colour, int amount) {
        this.colour = colour;
        this.amount = amount;
    }

    public Set<BagPartTwo> getContains() {
        return contains;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Bag{" +
                "colour='" + colour + '\'' +
                "amount='" + amount + '\'' +
                ", contains=" + contains +
                '}';
    }
}
