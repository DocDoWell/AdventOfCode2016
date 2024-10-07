package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PartOne {
    private String file;

    public PartOne(String file) {
        this.file = file;
    }

    public double solve(){
        List<Double>  encryption = getEncrytpion();
        int firstPointer = 0;
        int secondPointer = 1;
        int numberPointer = 25;
        while(numberPointer < encryption.size()){
            if(!isValid(firstPointer, secondPointer,numberPointer,encryption)){
                return encryption.get(numberPointer);
            }
            firstPointer++;
            secondPointer++;
            numberPointer++;
        }
        return -1;
    }


    public boolean isValid(int firstPointer, int secondPointer, int numberPointer, List<Double>  encryption){

        for(int i = firstPointer; i < numberPointer-1; i++){
            for(int j= secondPointer; j < numberPointer; j++){
                if(encryption.get(i) + encryption.get(j) == encryption.get(numberPointer)){
                    return true;
                }
            }
        }
        return false;
    }

    private List<Double> getEncrytpion(){
        List<Double> encryption = new ArrayList<>();
        int lineNumber = 1;

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = bufferedReader.readLine();

            while (line != null) {
                encryption.add(Double.parseDouble(line.trim()));
                line = bufferedReader.readLine();
            }

        }catch (IOException e) {
            e.printStackTrace();
        }

        return encryption;
    }
}
