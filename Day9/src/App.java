package src;

public class App {
    public static void main(String[] args){
        PartOne partOne = new PartOne("src/input.txt");
        System.out.printf("PArt One: %f",partOne.solve());
        PartTwo partTwo = new PartTwo("src/input.txt");
        System.out.printf("Part Two: %f",partTwo.solve());
    }
}
