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

    public int getNumberOfTrees(){
        int trees =0;
        int right = 0;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = bufferedReader.readLine();
            int length = line.trim().length();
            List<String> paths = new ArrayList<>();

            while (line != null) {
                paths.add(line.trim());
                line = bufferedReader.readLine();
            }

            for (int i = 0; i < paths.size(); i++){
                int index = right%length;
                if(paths.get(i).charAt(index) == '#'){
                    trees++;
                }
                right = right+3;
            }


        }catch (IOException e) {
            e.printStackTrace();
        }
        return trees;
    }
}
