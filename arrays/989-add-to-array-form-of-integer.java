import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        
        StringBuilder sb = new StringBuilder();
        
        // Convert array to string
        for (int i : num) {
            sb.append(i);
        }
        
        // Use BigInteger to handle large numbers
        BigInteger bigNum = new BigInteger(sb.toString());
        BigInteger bigK = BigInteger.valueOf(k);
        BigInteger newNum = bigNum.add(bigK);
        
        // Convert result to string
        String newStr = newNum.toString();
        
        // Convert string to List<Integer>
        List<Integer> result = new ArrayList<>();
        for (char c : newStr.toCharArray()) {
            result.add(Character.getNumericValue(c));
        }
        
        return result;
    }
}
