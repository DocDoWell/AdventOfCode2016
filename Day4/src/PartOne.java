package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PartOne {

    String file;

    public PartOne(String file) {
        this.file = file;
    }

    public int getValidPassports(){
        int passports =0;

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = bufferedReader.readLine();

            List<String> passportDetails = new ArrayList<>();

            while (line != null) {
                if(line.trim().isEmpty()){
                    if(isPassportValid(passportDetails)){
                        passports++;
                    }
                    passportDetails.clear();
                }else{
                    passportDetails.add(line.trim());
                }
                line = bufferedReader.readLine();
            }

        }catch (IOException e) {
            e.printStackTrace();
        }

        return passports;
    }

    private boolean isPassportValid(List<String> passportDetails){
        Set<String> numberDetails = new HashSet<>();

        for(String details: passportDetails){
            String[] splitDetails = details.split(" ");
            for(int i=0; i < splitDetails.length; i++){
                numberDetails.add(splitDetails[i].split(":")[0]);
            }
        }

        if(numberDetails.size() < 7){
            return false;
        }

        if(numberDetails.size() == 7){
            if(!numberDetails.contains("cid")) {
                return true;
            }else{
                return false;
            }
        }
        return true;
    }

}
