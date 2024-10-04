package src;

public class App {
    public static void main(String[] args){
        PartOne partOne = new PartOne("src/input.txt");
        System.out.println("Part One Solution: "+partOne.getNumberOfTrees());
        PartTwo partTwo = new PartTwo("src/input.txt");
        System.out.printf("Part Two Solution: %f", partTwo.getNumberOfTrees());

    }
}
