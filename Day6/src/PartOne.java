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

    public int getAnswers(){
        int total = 0;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = bufferedReader.readLine();
            List<String> groupAnswers = new ArrayList<>();
            while (line != null) {
                if(line.trim().isEmpty()){
                    Set<String> answers = new HashSet<>();
                    for(String answer: groupAnswers){
                        for(int i=0; i < answer.length(); i++){
                            answers.add(String.valueOf(answer.charAt(i)));
                        }
                    }
                    total = total + answers.size();
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
