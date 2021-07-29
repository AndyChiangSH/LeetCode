// Solution2: count and fill
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    void sortColors(vector<int>& nums) {
    	int zero = 0, one = 0;
    	
        for(int x : nums) {
			if(x == 0) zero++;	// count number of 0
			else if(x == 1) one++;	// count number of 1
		}
		fill(nums.begin(), nums.begin()+zero, 0);	// fill 0
		fill(nums.begin()+zero, nums.begin()+zero+one, 1);	// fill 1
		fill(nums.begin()+zero+one, nums.end(), 2);		// fill 2
		
//		this->show(nums);
		return;
    }
	
	void show(vector<int> nums) {
		for(int x : nums) {
			cout << x << " ";
		}
		cout << endl;
	}
};

int main() {
	
	Solution sol;
	vector<int> nums{1,0,2,2,0,1,1};
	
	sol.show(nums);
	
	sol.sortColors(nums);
	
	system("PAUSE");
	return 0;
} 
