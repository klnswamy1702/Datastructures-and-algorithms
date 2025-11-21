class Solution {
public:
    int minCost(vector<vector<int>>& costs) {
        if (costs.size() == 0) return 0;

        vector<vector<int>> memo = {costs.size() + 1, vector<int>(3, 0)};

        for (int i = costs.size() - 1; i >= 0; --i) {
            memo[i][0] = costs[i][0] + min(memo[i + 1][1], memo[i + 1][2]);
            memo[i][1] = costs[i][1] + min(memo[i + 1][0], memo[i + 1][2]);
            memo[i][2] = costs[i][2] + min(memo[i + 1][0], memo[i + 1][1]);
        }

        return min(min(memo[0][0], memo[0][1]), memo[0][2]);
    }
};