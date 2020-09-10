class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        if (nums.size() == 0)
            return 0;
        
        if (nums.size() == 1)
            return 1;
        
        int value = *nums.begin();
        int place = 1;
        
        for (int i = 1; i < nums.size(); ++i){
            if (nums[i] != value){
                nums[place] = nums[i];
                value = nums[i];
                ++place;
            }
        }
        
        return place;
    }
};