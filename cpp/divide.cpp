class Solution {
public:
    int divide(int dividend, int divisor) {
        bool neg = false;
        
        if (dividend < 0){
            neg = true;
            dividend = std::abs(dividend);
        }
        
        if (dividend > 2147483647){
            return 2147483647;
        }
        
        
        if (divisor < 0){
            neg = neg ? false : true;
            divisor = std::abs(divisor);
        }
        
        if (divisor == 1){
            return neg ? 0 - dividend : dividend;
        }
        
        
        int r = 0;
        
        while (dividend >= divisor && dividend != 0){
            dividend -= divisor;
            ++r;
        }
        
        return neg ? 0 - r : r;
    }
};