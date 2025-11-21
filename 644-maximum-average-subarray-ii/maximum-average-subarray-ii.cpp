class Solution {
public:
        double findMaxAverage(vector<int>& nums, int k) {
        double left = INT_MAX, right = INT_MIN, mid;
        for(int num:nums){
            right = max(right, double(num));
            left = min(left, double(num));
        }
        while(left + 0.00001 < right){
            mid = left + (right - left)/2;
            if(islarger(nums, mid, k))right = mid;
            else left = mid;
        }
        return left;
    }
    
    //Return true when mid is larger than or equal to the maximum average value;
    //Return false when mid is smaller than the maximum average value.
    bool islarger(vector<int>& nums, double mid, int k){
        // sum: the sum from nums[0] to nums[i];
        // prev_sum:  the sum from nums[0] to nums[i-k];
        // min_sum: the minimal sum from nums[0] to nums[j] ( 0=< j  <= i-k );
        double sum = 0, prev_sum = 0, min_sum = 0;
        for(int i = 0; i < nums.size(); i++){
            sum += nums[i] - mid;
            if(i >= k){
                prev_sum += nums[i-k] - mid;                        
                min_sum = min(prev_sum, min_sum); 
            }
            if(i >= k-1 && sum > min_sum)return false;
        }
        return true;                                               
    }
};