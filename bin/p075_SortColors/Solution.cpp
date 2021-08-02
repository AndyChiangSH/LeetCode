// Solution: 3-way partition
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    void sortColors(vector<int>& nums) {
        int lt = 0, gt = nums.size()-1, i = 0;
        
        while(i <= gt) {
        	if(nums[i] < 1) {	// 0
        		swap(&nums[lt++], &nums[i++]);
			}
			else if(nums[i] > 1) {	// 2
				swap(&nums[i], &nums[gt--]);
			}
			else {	// 1
				i++;
			}
		}
		
//		this->show(nums);
		return;
    }
    
    void swap(int* a, int* b) {
    	int temp = *a;
    	*a = *b;
    	*b = temp;
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
	vector<int> nums{2,1};
	
	sol.show(nums);
	
	sol.sortColors(nums);
	
	system("PAUSE");
	return 0;
} 
