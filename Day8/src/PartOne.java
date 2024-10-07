package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PartOne {

    private String file;

    public static int accumulator;

    public PartOne(String file) {
        this.file = file;
    }

    public void solve(){
        Map<Integer,String> instructions = getInstructions();
        Map<Integer,String> considered = new HashMap<>();
        int instructionNumber = 1;
        accumulator = 0;

        while(considered.get(instructionNumber) == null){
            String instruction = instructions.get(instructionNumber);
            considered.put(instructionNumber,instruction);
            if(instruction.split(" ")[0].equals("nop")){
                instructionNumber++;
            }else if(instruction.split(" ")[0].equals("acc")){
                if(instruction.split(" ")[1].charAt(0)=='+'){
                    accumulator = accumulator + Integer.parseInt(instruction.split(" ")[1].substring(1));
                }else{
                    accumulator = accumulator - Integer.parseInt(instruction.split(" ")[1].substring(1));
                }
                instructionNumber++;
            }else{
                int jump = Integer.parseInt(instruction.split(" ")[1].substring(1));
                if(instruction.split(" ")[1].charAt(0)=='+'){
                    instructionNumber = instructionNumber + jump;
                }else{
                    instructionNumber = instructionNumber - jump;
                }
            }
        }
    }

    private Map<Integer,String> getInstructions(){
        Map<Integer,String> instructions = new HashMap<>();
        int lineNumber = 1;

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = bufferedReader.readLine();

            while (line != null) {
                instructions.put(lineNumber,line.trim());
                lineNumber++;
                line = bufferedReader.readLine();
            }

        }catch (IOException e) {
            e.printStackTrace();
        }

        return instructions;
    }


}
