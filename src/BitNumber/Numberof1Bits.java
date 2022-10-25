package BitNumber;

public class Numberof1Bits {
    public int hammingWeight(int n) {
        int ones = 0;
        //in the while condition and we cannot use n>0
        //in java int type has a cyclic representation, that means Integer.MAX_VALUE+1==Integer.MIN_VALUE).
        //because the input 2147483648 would correspond to -2147483648 in java and the code would not enter the while if the condition is n>0 for n=2147483648
    	while(n!=0) {
            //AND with 1
    		ones = ones + (n & 1);
            //We need to use bit shifting unsigned operation >>> (while >> depends on sign extension)
    		n = n>>>1;
    	}
    	return ones;
    } 
}
