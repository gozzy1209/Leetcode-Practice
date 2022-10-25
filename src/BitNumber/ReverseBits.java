package BitNumber;
//190Reverse Bits
public class ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int answer = 0; 
        for (int i=0;i<32;i++) {
            //循环的思路，n每次往右移，ans每次往左移，刚好就是相反的顺序
            answer = answer << 1; // Move all bits recorded until now to left and make room in the last bit.
            answer = answer | (n & 1);  // Extract the last bit from n (n&1) and add it to the last bit of the answer (answer | last bit)
            n = n >> 1; // Shift n by 1 bit to the right for the next iteration.
        }
        return answer;
    }
}