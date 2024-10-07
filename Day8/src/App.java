package src;

public class App {

    public static void main(String[] args){
        PartOne partOne = new PartOne("src/input.txt");
        partOne.solve();
        System.out.println("Part One:" + partOne.accumulator);
        PartTwo partTwo = new PartTwo("src/input.txt");
        partTwo.solve();
        System.out.println("Part Two:" + partTwo.accumulator);
    }
}
