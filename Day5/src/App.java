package src;

public class App {
    public static void main(String[] args){
        PartOne partOne = new PartOne("src/input.txt");
        System.out.println("PartOne: "+ partOne.getHighestSetId());
        PartTwo partTwo = new PartTwo("src/input.txt");
        System.out.println("PartOne: "+ partTwo.getIndividualSeatId());
    }
}
