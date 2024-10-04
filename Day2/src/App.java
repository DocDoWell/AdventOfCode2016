package src;

public class App {

    public static void main(String[] args){
        PartOne partOne = new PartOne("src/input.txt");
        System.out.println("Part One Solution: " + partOne.getValidPasswords());

        PartTwo partTwo = new PartTwo("src/input.txt");
        System.out.println("Part Two Solution: " + partTwo.getValidPasswords());
    }
}
