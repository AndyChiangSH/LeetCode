#include <iostream>
#include <vector>

using namespace std; 

class Solution {
public:
    vector<vector<int>> ans;
    
    void helperFun(int i,vector<int>& nums, vector<int>& curr){
	
		// store the current vector in ans on reaching the end of the input
        if(i == nums.size()){
            ans.push_back(curr);
            return;
        }
        // we can either accept the number (nums[i])
        curr.push_back(nums[i]);
        helperFun(i+1, nums, curr);
		
        curr.pop_back();  // remove the new elemet and reset to original condition
		
		// or we can move forward without it(nums[i])
        helperFun(i+1, nums, curr);   
    }
    
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<int> curr;
        helperFun(0, nums, curr);
        
        return ans;
    }
    
    void show(vector< vector<int> >* ans) {
		for(int i = 0; i < ans->size(); i++) {
			vector<int>* vec = &(ans->at(i));
			for(int j = 0; j < vec->size(); j++) {
				cout << vec->at(j) << " ";
			}
			cout << endl;
		}
	}
};

int main() {
	Solution sol;
	vector<int> nums{1,2,3};
	
	sol.subsets(nums);
}
