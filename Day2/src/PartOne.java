package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PartOne {
    String file;

    public PartOne(String file) {
        this.file = file;
    }

    public int getValidPasswords(){
        int output =0;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = bufferedReader.readLine();
            while (line != null) {
                String[] lineSplit = line.split(" ");
                PasswordPolicy passwordPolicy = new PasswordPolicy(
                        Integer.parseInt(lineSplit[0].split("-")[0]),
                        Integer.parseInt(lineSplit[0].split("-")[1]),
                        lineSplit[1].charAt(0),
                        lineSplit[2]);
                if(passwordPolicy.isPasswordValid()){
                    output++;
                }
                line = bufferedReader.readLine();
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        return output;
    }

}
