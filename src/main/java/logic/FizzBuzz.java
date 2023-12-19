package logic;

public class FizzBuzz {
    public String fizzBuzz(Integer x) {
        if (x ==null || x == 0 ){
            throw new IllegalArgumentException("not allowed argument "+x+".");
        }
        if (x % 5 ==0 && x % 3==0){
            return "FizzBuzz";
        }
        if (x % 5 ==0){
            return "Buzz";
        }
        if (x % 3==0){
            return "Fizz";
        }
        return String.valueOf(x);
    }
}
