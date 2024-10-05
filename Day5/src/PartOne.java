package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PartOne {
    String file;

    public PartOne(String file) {
        this.file = file;
    }

    public int getHighestSetId(){
        int highestId = 0;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = bufferedReader.readLine();

            while (line != null) {
                int thisId = getSeatId(line.trim());
                if(thisId > highestId){
                    highestId = thisId;
                }
                line = bufferedReader.readLine();
            }

        }catch (IOException e) {
            e.printStackTrace();
        }

        return highestId;
    }

    private int getSeatId(String boardingPass){
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
