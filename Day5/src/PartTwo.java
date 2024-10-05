package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class PartTwo {
    String file;

    public PartTwo(String file) {
        this.file = file;
    }

    public int getIndividualSeatId(){
        Set<Integer> seats = new HashSet<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = bufferedReader.readLine();

            while (line != null) {
                seats.add(getSeatId(line.trim()));
                line = bufferedReader.readLine();
            }

        }catch (IOException e) {
            e.printStackTrace();
        }

        int prevSeat = 0;
        for(int seat: seats){
           if(prevSeat == 0){
               prevSeat = seat;
           }else{
               if(seat - prevSeat > 1){
                   return prevSeat+1;
               }
               prevSeat = seat;
           }
        }
        return 0;
    }

    private int getSeatId(String boardingPass){
        //System.out.println("Called getSeatId for: " + boardingPass);
        int lowerSeat = 0;
        int upperSeat = 127;
        int acutalSeat;

        int lowerColumn = 0;
        int upperColumn = 7;
        int acutalColumn;

        String firstSevenCharacters = boardingPass.substring(0,7);
        String lastThreeCharacters = boardingPass.substring(boardingPass.length() - 3);

        for (int i = 0; i < firstSevenCharacters.length(); i++){
            char c = firstSevenCharacters.charAt(i);
            if(c=='B'){
                lowerSeat = ((upperSeat+lowerSeat)/2)+1;
            }
            if(c=='F'){
                upperSeat= (int)Math.floor((upperSeat+lowerSeat)/2);
            }
        }

        if(firstSevenCharacters.charAt(6) == 'F'){
            acutalSeat = lowerSeat;
        }else{
            acutalSeat = upperSeat;
        }

        for (int i = 0; i < lastThreeCharacters.length(); i++){
            char c = lastThreeCharacters.charAt(i);
            if(c=='R'){
                lowerColumn = ((upperColumn+lowerColumn)/2)+1;
             }
            if(c=='L'){
                upperColumn= (int)Math.floor((upperColumn+lowerColumn)/2);
            }
        }

        if(lastThreeCharacters.charAt(2) == 'R'){
            acutalColumn = upperColumn;
        }else{
            acutalColumn = lowerColumn;
        }
        return (acutalSeat*8)+acutalColumn;
    }
}
