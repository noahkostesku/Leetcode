class Solution {
    public boolean checkValidString(String s) {
        int leftMin = 0, leftMax = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                //increase both on open 
                leftMin++;
                leftMax++;
            } else if (c == ')') {
                //decr on close
                leftMin--;
                leftMax--;
            } else {
                //minus left and plus right for range of possibilities
                //choice between open or close
                leftMin--;
                leftMax++;
            }
            //left max is negative means no possibilities
            if (leftMax < 0) {
                return false;
            }
            //left min of 0 there is still a possibiiltiy of zero (if max if > 0) so reset it to zero
            if (leftMin < 0) {
                leftMin = 0;
            }
        }
        return leftMin == 0;
    }
}


