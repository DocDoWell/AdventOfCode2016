package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PartTwo {

    String file;

    public PartTwo(String file) {
        this.file = file;
    }

    public int getValidPassports(){
        int passports =0;

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = bufferedReader.readLine();

            List<String> passportDetails = new ArrayList<>();

            while (line != null) {
                if(line.trim().isEmpty()){
                    if(isPassportValid(passportDetails) && fieldsAreCorrect(passportDetails)){
                        passports++;
                    }
                    passportDetails.clear();
                }else{
                    passportDetails.add(line.trim());
                }
                line = bufferedReader.readLine();
            }

        }catch (IOException e) {
            e.printStackTrace();
        }

        return passports;
    }

    private boolean fieldsAreCorrect(List<String> passportDetails){
        for(String details: passportDetails){
            String[] splitDetails = details.split(" ");
            for(int i=0; i < splitDetails.length; i++){
                String code = splitDetails[i].split(":")[0].trim();
                String value = splitDetails[i].split(":")[1].trim();

                if(code.equals("byr")){
                    if(value.length() != 4){
                        return false;
                    }

                    try{
                        int val = Integer.parseInt(value);
                        if(val < 1920 || val > 2002){
                            return false;
                        }
                    }catch(NumberFormatException e){
                        return false;
                    }
                }

                if(code.equals("iyr")){
                    if(value.length() != 4){
                        return false;
                    }

                    try{
                        int val = Integer.parseInt(value);
                        if(val < 2010 || val > 2020){
                            return false;
                        }
                    }catch(NumberFormatException e){
                        return false;
                    }
                }

                if(code.equals("eyr")){
                    if(value.length() != 4){
                        return false;
                    }

                    try{
                        int val = Integer.parseInt(value);
                        if(val < 2020 || val > 2030){
                            return false;
                        }
                    }catch(NumberFormatException e){
                        return false;
                    }
                }

                if(code.equals("hgt")){
                    Pattern pattern = Pattern.compile("\\d{2,3}(cm|in)");
                    Matcher matcher = pattern.matcher(value);
                    if(!matcher.find()){
                        return false;
                    }

                    if(value.contains("cm")){
                        value = value.replaceAll("cm","");
                        if(Integer.parseInt(value) < 150 || Integer.parseInt(value) > 193){
                            return false;
                        }
                    }else if(value.contains("in")) {
                        value = value.replaceAll("in", "");
                        if (Integer.parseInt(value) < 59 || Integer.parseInt(value) > 76) {
                            return false;
                        }
                    }
                }

                if(code.equals("hcl")){
                    if(value.charAt(0) != '#'){
                        return false;
                    }
                    Pattern pattern = Pattern.compile("([0-9]|[a-f]){5}");
                    Matcher matcher = pattern.matcher(value.substring(1));
                    if(!matcher.find()){
                        return false;
                    }
                }

                if(code.equals("ecl")){
                    if(!value.equals("amb") && !value.equals("blu") && !value.equals("brn") && !value.equals("gry") &&
                            !value.equals("grn") && !value.equals("hzl") && !value.equals("oth")){
                        return false;
                    }
                }

                if(code.equals("pid")){
                    if(value.length() != 9){
                        return false;
                    }
                    Pattern pattern = Pattern.compile("[0-9]");
                    Matcher matcher = pattern.matcher(value);
                    if(!matcher.find()){
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private boolean isPassportValid(List<String> passportDetails){
        Set<String> numberDetails = new HashSet<>();

        for(String details: passportDetails){
            String[] splitDetails = details.split(" ");
            for(int i=0; i < splitDetails.length; i++){
                numberDetails.add(splitDetails[i].split(":")[0]);
            }
        }

        if(numberDetails.size() < 7){
            return false;
        }

        if(numberDetails.size() == 7){
            if(!numberDetails.contains("cid")) {
                return true;
            }else{
                return false;
            }
        }
        return true;
    }

}
