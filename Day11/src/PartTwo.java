package src;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class PartTwo {

    private String file;
    private static final String[] DIRECTIONS = new String[] { "up", "down", "left", "right", "topLeft", "topRight", "bottomRight", "bottomLeft"};

    public PartTwo(String file) {
        this.file = file;
    }

    public int solve(){
        String[][] seatingPlan = getSeatingPlans();

        int numberOfOccupiedSeat = getNumberOfOccupiedSeats(seatingPlan);

        while(true){
            String[][] updatedSeatingPlan =  updateSeatingPlan(seatingPlan);
             int updatedNumberOfSeats = getNumberOfOccupiedSeats(updatedSeatingPlan);
            if(updatedNumberOfSeats == numberOfOccupiedSeat){
                return updatedNumberOfSeats;
            }
            numberOfOccupiedSeat = updatedNumberOfSeats;
            seatingPlan = updatedSeatingPlan;
        }
    }

    private int getNumberOfOccupiedSeats(String[][] seatingPlan){
        int output = 0;
        for (int i=0; i<seatingPlan.length;i++) {
            for (int j=0; j<seatingPlan[i].length;j++) {
                if(seatingPlan[i][j].equals("#")){
                    output++;
                }
            }
        }
        return output;
    }

    private String[][] updateSeatingPlan(String[][] seatingPlan){
        String[][] updatedPlan = new String[seatingPlan.length][seatingPlan[0].length];

        for(int i =0; i < seatingPlan.length; i++){
            for(int j =0; j < seatingPlan[i].length; j++){
                if(seatingPlan[i][j].equals("L")){
                    if(thereAreNoOccupiedSeatsAdjacentToEmpty(seatingPlan, i,j)){
                        updatedPlan[i][j] = "#";
                    }else{
                        updatedPlan[i][j] = "L";
                    }
                }
                if(seatingPlan[i][j].equals("#")){
                    if(thereAreFiveOccupiedSeatsAdjacentToEmpty(seatingPlan, i,j)){
                        updatedPlan[i][j] = "L";
                    }else{
                        updatedPlan[i][j] = "#";
                    }
                }
                if(seatingPlan[i][j].equals(".")){
                    updatedPlan[i][j] = ".";
                }
            }
        }
        return updatedPlan;
    }

    private boolean thereAreNoOccupiedSeatsAdjacentToEmpty(String[][] seatingPlan, int vertical, int horizontal){
        for(int i=0; i< DIRECTIONS.length;i++){
            if(findNearestVisibleOccupied(seatingPlan,DIRECTIONS[i],vertical,horizontal) == 1){
                return false;
            }
        }
        return true;
    }

    private boolean thereAreFiveOccupiedSeatsAdjacentToEmpty(String[][] seatingPlan, int vertical, int horizontal){
        int total = 0;
        for(int i=0; i< DIRECTIONS.length;i++){
            total = total + findNearestVisibleOccupied(seatingPlan,DIRECTIONS[i],vertical,horizontal);
            if(total >= 5){
                return true;
            }
        }
        return false;
    }

    private int findNearestVisibleOccupied(String[][] seatingPlan, String direction, int vertical, int horizontal){
        switch(direction) {
            case "up": {
                int verticalPointer = vertical - 1;
                while (verticalPointer >= 0) {
                    if (seatingPlan[verticalPointer][horizontal].equals("#")) {
                        return 1;
                    }
                    if (seatingPlan[verticalPointer][horizontal].equals("L")) {
                        return 0;
                    }
                    verticalPointer--;
                }
                return 0;
            }
            case "down": {
                int verticalPointer = vertical + 1;
                while (verticalPointer < seatingPlan.length) {
                    if (seatingPlan[verticalPointer][horizontal].equals("#")) {
                        return 1;
                    }
                    if (seatingPlan[verticalPointer][horizontal].equals("L")) {
                        return 0;
                    }
                    verticalPointer++;
                }
                return 0;
            }
            case "left": {
                int horizontalPointer = horizontal -1;
                while (horizontalPointer >= 0) {
                    if (seatingPlan[vertical][horizontalPointer].equals("#")) {
                        return 1;
                    }
                    if (seatingPlan[vertical][horizontalPointer].equals("L")) {
                        return 0;
                    }
                    horizontalPointer--;
                }
                return 0;
            }
            case "right": {
                int horizontalPointer = horizontal + 1;
                while (horizontalPointer < seatingPlan[0].length) {
                    if (seatingPlan[vertical][horizontalPointer].equals("#")) {
                        return 1;
                    }
                    if (seatingPlan[vertical][horizontalPointer].equals("L")) {
                        return 0;
                    }
                    horizontalPointer++;
                }
                return 0;
            }
            case "topLeft": {
                int verticalPointer = vertical - 1;
                int horizontalPointer = horizontal -1;
                while (verticalPointer >= 0 && horizontalPointer >= 0) {
                    if (seatingPlan[verticalPointer][horizontalPointer].equals("#")) {
                        return 1;
                    }
                    if (seatingPlan[verticalPointer][horizontalPointer].equals("L")) {
                        return 0;
                    }
                    verticalPointer--;
                    horizontalPointer--;
                }
                return 0;
            }
            case "topRight": {
                int verticalPointer = vertical - 1;
                int horizontalPointer = horizontal +1;
                while (verticalPointer >= 0 && horizontalPointer < seatingPlan[0].length) {
                    if (seatingPlan[verticalPointer][horizontalPointer].equals("#")) {
                        return 1;
                    }
                    if (seatingPlan[verticalPointer][horizontalPointer].equals("L")) {
                        return 0;
                    }
                    verticalPointer--;
                    horizontalPointer++;
                }
                return 0;
            }
            case "bottomRight": {
                int verticalPointer = vertical + 1;
                int horizontalPointer = horizontal +1;
                while (verticalPointer < seatingPlan.length && horizontalPointer < seatingPlan[0].length) {
                    if (seatingPlan[verticalPointer][horizontalPointer].equals("#")) {
                        return 1;
                    }
                    if (seatingPlan[verticalPointer][horizontalPointer].equals("L")) {
                        return 0;
                    }
                    verticalPointer++;
                    horizontalPointer++;
                }
                return 0;
            }
            case "bottomLeft": {
                int verticalPointer = vertical + 1;
                int horizontalPointer = horizontal -1;
                while (verticalPointer < seatingPlan.length && horizontalPointer >= 0) {
                    if (seatingPlan[verticalPointer][horizontalPointer].equals("#")) {
                        return 1;
                    }
                    if (seatingPlan[verticalPointer][horizontalPointer].equals("L")) {
                        return 0;
                    }
                    verticalPointer++;
                    horizontalPointer--;
                }
                return 0;
            }
            default:
                return 0;
        }
    }

    private  String [][] getSeatingPlans(){

        try {
            List<String> listOfStrings;

            // load the data from file
            listOfStrings = Files.readAllLines(Paths.get(file));

            String [][] array = new String[listOfStrings.size()][listOfStrings.get(0).length()];

            // convert arraylist to array
            int index = 0;
            for(String s : listOfStrings){
                array[index] = s.split("");
                index++;
            }

            return array;

        }catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
