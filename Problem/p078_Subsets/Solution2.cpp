#include <iostream>
#include <vector>

using namespace std; 

class Solution {
public:
    vector< vector<int> > subsets(vector<int>& nums) {
    	vector< vector<int> > answer;
    	if(nums.empty()) return answer;
    	
		vector<int> comb;
    	enumerate(&answer, &comb, &nums, 0);
    	
    	this->show(&answer);
    	return answer;
    }

    void enumerate(vector< vector<int> >* answer, vector<int>* comb, vector<int>* nums, int n) {
    	answer->push_back(*comb);
    	if(n == nums->size()) return;
    	
    	for(int i = n; i < nums->size(); i++) {
    		comb->push_back(nums->at(i));
    		enumerate(answer, comb, nums, i+1);
    		comb->pop_back();
		}
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
	vector<int> nums{0,1,2};
	
	sol.subsets(nums);
}
