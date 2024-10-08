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

    public double solve() {
        List<Integer> joltage = getJoltage();
        Collections.sort(joltage);

        Map<Integer,Double> memoization = new HashMap<>();
        memoization.put(0,1.0);

        for(int i=0; i<joltage.size(); i++){
            int jolt = joltage.get(i);
            double paths = 0;
            if(memoization.get(jolt-1) != null){
                paths = paths + memoization.get(jolt-1);
            }

            if(memoization.get(jolt-2) != null){
                paths = paths + memoization.get(jolt-2);
            }

            if(memoization.get(jolt-3) != null){
                paths = paths + memoization.get(jolt-3);
            }

            memoization.put(jolt,paths);
        }

        return memoization.get(Collections.max(memoization.keySet()));
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
