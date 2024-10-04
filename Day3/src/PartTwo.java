package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PartTwo {
    String file;

    public PartTwo(String file) {
        this.file = file;
    }

    public double getNumberOfTrees(){
        return getTrees(1,1)*getTrees(3,1)*getTrees(5,1)*getTrees(7,1)*getTrees(1,2);
    }

    private double getTrees(int right, int down){
        double trees =0.0;
        int startRight = 0;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = bufferedReader.readLine();
            int length = line.trim().length();
            List<String> paths = new ArrayList<>();

            while (line != null) {
                paths.add(line.trim());
                line = bufferedReader.readLine();
            }

            int startDown= 0;

            while(startDown < paths.size()){
                int index = startRight%length;
                if(paths.get(startDown).charAt(index) == '#'){
                    trees++;
                }
                startDown = startDown + down;
                startRight = startRight + right;
            }

        }catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("trees are " + trees +" for right " + right +" and down " + down);
        return trees;
    }
}
