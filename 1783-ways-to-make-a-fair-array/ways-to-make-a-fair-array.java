class Solution {
    public int waysToMakeFair(int[] arr) {
        int n = arr.length;
        int res = 0;
        
        // calculate initial right side sums
        int rightOddSum = 0, rightEvenSum = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                rightEvenSum += arr[i];
            } 
            else {
                rightOddSum += arr[i];
            }
        }
        
        // initialize left side sums
        int leftOddSum = 0, leftEvenSum = 0;
        
        // check for each index
        for (int i = 0; i < n; i++) {
            
            // remove current element from right side
            if (i % 2 == 0) {
                rightEvenSum -= arr[i];
            } 
            else {
                rightOddSum -= arr[i];
            }
            
            // after removing element at index i, indices shift
            // So right side odd becomes even and even becomes odd
            if (leftOddSum + rightEvenSum == 
                        leftEvenSum + rightOddSum) {
                res++;
            }
            
            // add current element to left side
            if (i % 2 == 0) {
                leftEvenSum += arr[i];
            } else {
                leftOddSum += arr[i];
            }
        }
        
        return res;
        
    }
}