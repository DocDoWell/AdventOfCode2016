package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class PartTwo {

    private String file;

    public PartTwo(String file) {
        this.file = file;
    }

    public double solve(){
        double invalidNumber = new PartOne(file).solve();
        List<Double> encryption = getEncrytpion();

        int firstPointer = 0;
        double sum = 0;

        while(firstPointer < encryption.size()){
            if(isValid(firstPointer,sum,encryption,invalidNumber) != -1){
                return isValid(firstPointer,sum,encryption,invalidNumber);
            }
            firstPointer++;
            sum = 0;

        }
        return -1;
    }


    public double isValid(int firstPointer, double sum, List<Double>  encryption, double invalidNumber){
        Set<Double> nos = new HashSet<>();
        for(int i = firstPointer; i < encryption.size() ; i++){
            sum = sum + encryption.get(i);
            nos.add(encryption.get(i));
            if(sum == invalidNumber){
                return Collections.max(nos) + Collections.min(nos);
            }else if(sum > invalidNumber){
                return -1;
            }
        }
        return -1;
    }

    private List<Double> getEncrytpion(){
        List<Double> encryption = new ArrayList<>();
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
