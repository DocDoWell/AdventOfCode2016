package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PartTwo {

    private String file;

    public static int accumulator;

    public PartTwo(String file) {
        this.file = file;
    }

    public void solve(){
        Map<Integer,String> instructions = getInstructions();
        Map<Integer,String> instructionsThatHaveBeenChange = new HashMap<>();
        Set<Integer> instructionsToChange = getInstuctionsThatNeedChanging(instructions);

        for(Integer instruction: instructionsToChange){
            instructionsThatHaveBeenChange.put(instruction, instructions.get(instruction));

            //update instruction
            String newInstruction = instructions.get(instruction);
            if(newInstruction.contains("nop")){
                newInstruction = newInstruction.replace("nop", "jmp");
            }else{
                newInstruction = newInstruction.replace("jmp", "nop");
            }

             instructions.put(instruction, newInstruction);

            //if infinite still revert
            if(stillInfinite(instructions)){
                instructions.put(instruction, instructionsThatHaveBeenChange.get(instruction));
            }else{
                break;
            }
        }
    }

    public boolean stillInfinite(Map<Integer,String> instructions){
        Map<Integer,String> considered = new HashMap<>();
        int instructionNumber = 1;
        accumulator = 0;

        while(instructionNumber <= instructions.keySet().size()){
            String instruction = instructions.get(instructionNumber);
            if(considered.get(instructionNumber) != null){
                return true;
            }
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
        return false;
    }

    private Set<Integer> getInstuctionsThatNeedChanging(Map<Integer,String> instructions){
        Set<Integer> output = new HashSet<>();
        for (var entry : instructions.entrySet()) {
           if(entry.getValue().contains("nop") || entry.getValue().contains("jmp")){
               output.add(entry.getKey());
           }
        }
        return output;
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
