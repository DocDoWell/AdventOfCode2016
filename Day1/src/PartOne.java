package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PartOne {
    String file;

    public PartOne(String file) {
        this.file = file;
    }

    public int multiplyEntries(){
        List<Integer> ints = new ArrayList<>();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = bufferedReader.readLine();
            while (line != null) {
                ints.add(Integer.parseInt(line.trim()));
                line = bufferedReader.readLine();
            }
        }catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < ints.size()-1; i++){
            for (int j = i+1; j < ints.size(); j++){
                if(ints.get(i)+ints.get(j) == 2020){
                    return ints.get(i)*ints.get(j);
                }
            }
        }

        return 0;
    }
}
