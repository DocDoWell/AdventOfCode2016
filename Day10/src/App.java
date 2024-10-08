package src;

public class App {

    public static void main(String[] args){
        PartOne partOne = new PartOne("test/test.txt");
        System.out.println("Part One: "+partOne.solve());
        PartTwo partTwo = new PartTwo("src/input.txt");
        System.out.printf("Part Two: %f",partTwo.solve());
    }
}
