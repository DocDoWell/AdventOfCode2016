package src;

import java.util.List;

public class App {

    public static void main(String[] args){
        PartOne partOne = new PartOne("src/input.txt");
        System.out.println("Part One Solution: "+partOne.multiplyEntries());

        PartTwo partTwo = new PartTwo("src/input.txt");
        System.out.println("Part Two Solution: "+partTwo.multiplyEntries());
    }
}
