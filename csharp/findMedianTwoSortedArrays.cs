public class Solution {
    public double FindMedianSortedArrays(int[] nums1, int[] nums2) {
        double midPoint = (double)(nums1.Length + nums2.Length) / 2;
        double midFloor = Math.Floor(midPoint);
        bool avg = midPoint == midFloor;
        double result = 0.0; 
        int midIndex= Convert.ToInt32(midFloor);
        if (avg && midIndex > 0){
            --midIndex;
        }
        int a = 0;
        int b = 0;
        int p = 0;
        
        
        while (a + b <= midIndex)
        {
            if (a >= nums1.Length)
            {
                if (b < nums2.Length){
                    p = nums2[b];
                    ++b;
                }
            }
            else if (b >= nums2.Length)
            {
                p = nums1[a];
                ++a;
            }
            else if (nums1[a] <= nums2[b])
            {
                p = nums1[a];
                ++a;
            }
            else
            {
                p = nums2[b];
                ++b;
            }
        }
        
        result = Convert.ToDouble(p);
        
        if (avg)
        {
            if (a >= nums1.Length)
            {
                if (b <= nums2.Length){
                    result = (Convert.ToDouble(nums2[b]) + result) / 2;
                }
            }
            else if (b >= nums2.Length)
            {
                result = (Convert.ToDouble(nums1[a]) + result) / 2;
            }
            else if (nums1[a] <= nums2[b])
            {
                result = (Convert.ToDouble(nums1[a]) + result) / 2;
            }
            else
            {
                result = (Convert.ToDouble(nums2[b]) + result) / 2;
            }
        }
        
        return result;
    }
}