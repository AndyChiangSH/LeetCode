#include <iostream>
#include <vector>

using namespace std; 

class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        int n = nums.size(), p = 1 << n;	// p = 2^j
        vector<vector<int>> subs(p);	// vector and capacity is p
        for (int i = 0; i < p; i++) {
            for (int j = 0; j < n; j++) {
            	// bit calculate: (i/2^j) is odd -> True, even -> False
                if ((i >> j) & 1) {
                    subs[i].push_back(nums[j]);
                }
            }
        }
        
        return subs;
    }
	
	void show(vector<int>* vec) {
		for(int i = 0; i < vec->size(); i++) {
			cout << vec->at(i) << " ";
		}
		cout << endl;
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
