class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int value=nums[0];
        int subValue=nums[0];
        int maxValue=nums[0];
    
        for(int i=1;i<nums.size();i++)
        {
            value=nums[i];
        
            subValue = subValue + value;
        
            if(value > subValue)
                subValue = value;
            
            if(subValue > maxValue)
                maxValue = subValue;
        }
        
        return maxValue;
    }
};