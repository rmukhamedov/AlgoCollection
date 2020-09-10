class Solution {
public:
    int removeElement(vector<int>& nums, int val) {
        int result = 0;
        
        while (nums[result] != val){
            ++result;
        }
        
        for (int i = result + 1; i < nums.size(); ++i)
        {
            if (!(nums[i] == val)){
                nums[result] = nums[i];
                result++;
            }
        }
        
        return result;
    }
};