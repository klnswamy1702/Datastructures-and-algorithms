// This code OVERWRITES the input vector!

class Solution {
public:
    int minCost(vector<vector<int>>& costs) {
        if (costs.size() == 0) return 0;

        vector<int> previousRow = costs[costs.size() - 1];

        for (int n = costs.size() - 2; n >= 0; n--) {
            // PROBLEMATIC CODE IS HERE
            // This line here is NOT making a copy of the original, it's simply
            // making a reference to it Therefore, any writes into currentRow
            // will also be written into "costs". This is not what we wanted!
            vector<int>& currentRow = costs[n];

            // Total cost of painting nth house red?
            currentRow[0] += min(previousRow[1], previousRow[2]);
            // Total cost of painting nth house green?
            currentRow[1] += min(previousRow[0], previousRow[2]);
            // Total cost of painting nth house blue?
            currentRow[2] += min(previousRow[0], previousRow[1]);
            previousRow = currentRow;
        }

        return min(min(previousRow[0], previousRow[1]), previousRow[2]);
    }
};