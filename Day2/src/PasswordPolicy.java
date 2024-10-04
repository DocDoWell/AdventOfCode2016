package src;

public class PasswordPolicy{
    int lower;
    int maximum;
    char letter;
    String password;

    public PasswordPolicy(int lower, int maximum, char letter, String password) {
        this.lower = lower;
        this.maximum = maximum;
        this.letter = letter;
        this.password = password;
    }

    public boolean isPasswordValid(){
        int count = 0;
        for (int i = 0; i < password.length(); i++){
            if(password.charAt(i) == letter){
                count++;
            }
        }

        if(count >= lower && count <= maximum){
            return true;
        }

        return false;
    }

    public boolean isPasswordValidForPartTwo(){
        if((password.charAt(lower-1) == letter && password.charAt(maximum-1) != letter) ||
                (password.charAt(lower-1) != letter && password.charAt(maximum-1) == letter)
        ){
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return "PasswordPolicy{" +
                "lower=" + lower +
                ", maximum=" + maximum +
                ", letter=" + letter +
                ", password='" + password + '\'' +
                '}';
    }
}