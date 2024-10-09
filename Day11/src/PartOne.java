package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PartOne {
    private String file;

    public PartOne(String file) {
        this.file = file;
    }

    public int solve(){
        Map<Integer,String> seatingPlan = getSeatingPlans();
        int numberOfOccupiedSeat = getNumberOfOccupiedSeats(seatingPlan);

        while(true){
            Map<Integer,String> updatedSeatingPlan =  updateSeatingPlan(seatingPlan);
            int updatedNumberOfSeats = getNumberOfOccupiedSeats(updatedSeatingPlan);
            if(updatedNumberOfSeats == numberOfOccupiedSeat){
                return updatedNumberOfSeats;
            }
            numberOfOccupiedSeat = updatedNumberOfSeats;
            seatingPlan = updatedSeatingPlan;
        }
    }


    private int getNumberOfOccupiedAdjacentSeats(int seatLocation, int row, String plan, Map<Integer,String> seatingPlan){
        int output = 0;

        if (seatLocation > 0) {

            if (row > 1 && seatingPlan.get(row-1).charAt(seatLocation-1) == '#') {
                output++;
            }

            if (plan.charAt(seatLocation-1) == '#') {
                output++;
            }

            if (row < seatingPlan.keySet().size() && seatingPlan.get(row+1).charAt(seatLocation-1) == '#') {
                output++;
            }

        }

        if (seatLocation < plan.length()-1) {
            if (row > 1 && seatingPlan.get(row-1).charAt(seatLocation+1) == '#') {
                output++;
            }

            if (plan.charAt(seatLocation + 1) == '#') {
                output++;
            }

            if (row < seatingPlan.keySet().size() && seatingPlan.get(row + 1).charAt(seatLocation + 1) == '#') {
                output++;
            }
        }

        if(row > 1){
            if (seatingPlan.get(row-1).charAt(seatLocation) == '#') {
                output++;
            }
        }

        if(row < seatingPlan.keySet().size()){
            if (seatingPlan.get(row+1).charAt(seatLocation) == '#') {
                output++;
            }
        }

        return output;
    }

    private Map<Integer,String> updateSeatingPlan(Map<Integer,String> seatingPlan){
        Map<Integer,String> updatedPlan = new HashMap<>();
        Map<Integer,String> output = new HashMap<>();
        int totalNumberOfOccupiedSeats = 0;

        for (var entry : seatingPlan.entrySet()) {
            int row = entry.getKey();
            String plan = entry.getValue();

            int seatLocation = 0;
            String newSeatPlan = "";

            while(seatLocation < plan.length()){
                if(plan.charAt(seatLocation) == 'L' || plan.charAt(seatLocation) == '#'){
                    int numberOfOccupiedSeats =  getNumberOfOccupiedAdjacentSeats(seatLocation, row, plan, seatingPlan);
                    totalNumberOfOccupiedSeats = totalNumberOfOccupiedSeats + numberOfOccupiedSeats;

                    if(plan.charAt(seatLocation) == 'L' && numberOfOccupiedSeats == 0){
                        newSeatPlan = newSeatPlan + '#';
                    }else if(plan.charAt(seatLocation) == '#' && numberOfOccupiedSeats >= 4){
                        newSeatPlan = newSeatPlan + 'L';
                    }else{
                        newSeatPlan = newSeatPlan + plan.charAt(seatLocation);
                    }
                }else{
                    newSeatPlan = newSeatPlan + plan.charAt(seatLocation);
                }
                seatLocation++;
            }

            updatedPlan.put(row, newSeatPlan);
        }
        return updatedPlan;
    }

    private Map<Integer,String> getSeatingPlans(){
        Map<Integer,String> seatingPlans = new HashMap<>();
        int lineNumber = 1;

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = bufferedReader.readLine();

            while (line != null) {
                seatingPlans.put(lineNumber, line.trim());
                line = bufferedReader.readLine();
                lineNumber++;
            }

        }catch (IOException e) {
            e.printStackTrace();
        }

        return seatingPlans;
    }

    private int getNumberOfOccupiedSeats(Map<Integer,String> seatingPlan){
        int output = 0;
        for (var entry : seatingPlan.entrySet()) {
            String plan = entry.getValue();
            for(int i=0; i< plan.length();i++){
                if(plan.charAt(i) == '#'){
                    output++;
                }
            }
        }
        return output;
    }


}
