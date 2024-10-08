package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PartOne {

    private String file;

    public PartOne(String file) {
        this.file = file;
    }

    public int solve(){
        List<Integer> joltage = getJoltage();
        Collections.sort(joltage);
        List<Integer> oneDiff = new ArrayList<>();
        List<Integer> threeDiff = new ArrayList<>();

        int effective = 0;

        for(int adapter : joltage){
           if(adapter-effective == 1){
               oneDiff.add(adapter);
               effective = adapter;
           }else if(adapter-effective == 3){
               threeDiff.add(adapter);
               effective = adapter;
           }
        }

        return oneDiff.size()*(threeDiff.size()+1);
    }

    private List<Integer> getJoltage(){
        List<Integer> encryption = new ArrayList<>();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = bufferedReader.readLine();

            while (line != null) {
                encryption.add(Integer.parseInt(line.trim()));
                line = bufferedReader.readLine();
            }

        }catch (IOException e) {
            e.printStackTrace();
        }

        return encryption;
    }
}
