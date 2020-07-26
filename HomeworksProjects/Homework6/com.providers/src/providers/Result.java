package providers;

import java.util.Arrays;

public class Result {

    private char[] chars;
    private int data;

    public Result(char[] chars, int data) {
        setChars(chars);
        setData(data);
    }

    public char[] getChars() {
        char[] copyChars = new char[this.chars.length];
        for(int i = 0; i < copyChars.length; i++){
            copyChars[i] = this.chars[i];
        }
        return copyChars;
    }

    public void setChars(char[] chars) {
        if(chars == null){
            this.chars = new char[0];
        } else{
            this.chars = new char[chars.length];
            for(int i = 0; i < chars.length; i++){
                this.chars[i] = chars[i];
            }
        }
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        if(data < 0){
            this.data = 0;
        } else {
            this.data = data;
        }
    }

    @Override
    public String toString() {
        return String.format("Chars: %s%nResult: %d", Arrays.toString(this.chars), this.data);
    }
}
