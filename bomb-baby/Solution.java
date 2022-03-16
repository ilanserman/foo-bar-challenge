import java.math.BigInteger;

public class Solution {
    public static String solution(String x, String y) {
        // Your code here
        BigInteger xx = new BigInteger(x);
        BigInteger yy = new BigInteger(y);
        BigInteger large = xx.max(yy);
        BigInteger small = xx.min(yy);
        BigInteger transitions = BigInteger.valueOf(0);
        BigInteger temp;

        while(small.signum() > 0) {
            BigInteger[] divideAndRemainder = large.divideAndRemainder(small);
            transitions = transitions.add(divideAndRemainder[0]);
            temp = small;
            small = divideAndRemainder[1];
            large = temp;
        }
        if(large.compareTo(BigInteger.ONE) != 0) {
            return "impossible";
        }
        transitions = transitions.subtract(BigInteger.ONE);
        return transitions.toString();
    }
}