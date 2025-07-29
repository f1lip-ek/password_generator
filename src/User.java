public class User {

    private int length;
    private boolean upperCase;
    private boolean lowerCase;
    private boolean numbers;
    private boolean special;
    private String password;

    public User() {
        this.length = 0;
        this.upperCase = true;
        this.lowerCase = true;
        this.numbers = true;
        this.special = true;
    }

    public int getLength() {
        return length;
    }

    public boolean isUpperCase() {
        return upperCase;
    }

    public boolean isLowerCase() {
        return lowerCase;
    }

    public boolean isNumbers() {
        return numbers;
    }

    public boolean isSpecial() {
        return special;
    }

    public String getPassword() {
        return password;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setUpperCase(boolean upperCase) {
        this.upperCase = upperCase;
    }

    public void setLowerCase(boolean lowerCase) {
        this.lowerCase = lowerCase;
    }

    public void setNumbers(boolean numbers) {
        this.numbers = numbers;
    }

    public void setSpecial(boolean special) {
        this.special = special;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isSelected(){
        if (upperCase || lowerCase || numbers || special) {
            return true;
        }
        return false;
    }
}
