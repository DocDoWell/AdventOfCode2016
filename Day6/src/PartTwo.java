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

    public int getAnswers(){
        int total = 0;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = bufferedReader.readLine();
            List<String> groupAnswers = new ArrayList<>();
            while (line != null) {
                if(line.trim().isEmpty()){
                    String answer = groupAnswers.get(0);
                    for(int i=1; i < groupAnswers.size(); i++){
                        String commonElements = "";
                        for(int j=0; j < groupAnswers.get(i).length(); j++){
                            if(answer.contains(String.valueOf(groupAnswers.get(i).charAt(j)))){
                                commonElements = commonElements + String.valueOf(groupAnswers.get(i).charAt(j));
                            }
                        }
                        answer = commonElements;
                    }
                    total = total + answer.length();
                    groupAnswers.clear();
                }else{
                    groupAnswers.add(line.trim());
                }
                line = bufferedReader.readLine();
            }

        }catch (IOException e) {
            e.printStackTrace();
        }
        return total;
    }
}
