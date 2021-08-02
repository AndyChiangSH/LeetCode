#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    void setZeroes(vector<vector<int>>& matrix) {
    	if(matrix.empty() || matrix[0].empty()) return;
    	
    	int m = matrix.size(), n = matrix[0].size();
    	bool is_clear_column = false;
    	for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(matrix[i][j] == 0) {
					if(j == 0) {
						is_clear_column = true;	// mark wheather first column be clear
					}
					else {
						matrix[i][0] = 0;	// mark at the top element
						matrix[0][j] = 0;	// mark at the left element
					}
				}
			}
		}
		for(int i = 1; i < n; i++) {
			if(matrix[0][i] == 0) {
				for(int j = 1; j < m; j++) {
					matrix[j][i] = 0;	// clear marked column
				}
			}
		}
		for(int i = 0; i < m; i++) {
			if(matrix[i][0] == 0) {
				for(int j = 1; j < n; j++) {
					matrix[i][j] = 0;	// clear marked row
				}
			}
		}
		if(is_clear_column) {
			for(int i = 0; i < m; i++) {
				matrix[i][0] = 0;	// clear first column
			}
		}
//		show(matrix);
		
		return;
    }
    
    void show(vector<vector<int>>& matrix) {
    	if(matrix.empty() || matrix[0].empty()) return;
    	
    	int m = matrix.size(), n = matrix[0].size();
    	for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				cout << matrix[i][j] << " ";
			}
			cout << endl;
		}
	}
};

int main(void) {
	
	Solution sol;
	int r = 8, c = 10;	// r = row number, c = column number
	int array[r][c] = {{3,5,5,6,9,1,4,5,0,5},{2,7,9,5,9,5,4,9,6,8},{6,0,7,8,1,0,1,6,8,1},{7,2,6,5,8,5,6,5,0,6},{2,3,3,1,0,4,6,5,3,5},{5,9,7,3,8,8,5,1,4,3},{2,4,7,9,9,8,4,7,3,7},{3,5,2,8,8,2,2,4,9,8}};
	vector<int> row;
	row.assign(c,0);	//配置一個 row 的大小
	vector<vector<int>> matrix;
	matrix.assign(r,row);	//配置2維
	
	for(int i = 0; i < r; i++) {
		for(int j = 0; j < c; j++) {
			matrix[i][j] = array[i][j];		// copy value from array to matrix(vector)
		}
	}
	
	for(int i = 0; i < r; i++) {
		for(int j = 0; j < c; j++) {
			cout << matrix[i][j] << " ";	// show matrix
		}
		cout << endl;
	}
	cout << "-----------------" << endl;
	
	sol.setZeroes(matrix);
	
	system("PAUSE");
	return 0;
}
