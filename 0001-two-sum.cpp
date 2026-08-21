// 0001-two-sum.cpp
#include <vector>
#include <unordered_map>

class Solution {
public:
    std::vector<int> twoSum(std::vector<int>& nums, int target) {
        std::unordered_map<int, int> mp;
        for (int i = 0; i < nums.size(); i++) {
            if (mp.count(target - nums[i])) {
                return {mp[target - nums[i]], i};
            }
            mp[nums[i]] = i;
        }
        return {};
    }
};
