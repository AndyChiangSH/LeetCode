#include <iostream>
#include <string>

using namespace std; 

class Solution {
public:
    bool isMatch(string s, string p) {
        
        int s_len = s.length(), p_len = p.length();
        bool dp[s_len+1][p_len+1];
        
        dp[0][0] = true;
        for(int i = 0; i < p_len; i++) {
        	if(p[i] == '*') {
        		dp[0][i+1] = dp[0][i];
			}
			else {
				dp[0][i+1] = false;
			}
		}
		for(int i = 0; i < s_len; i++) {
			dp[i+1][0] = false;
		}
		for(int i = 0; i < s_len; i++) {
			for(int j = 0; j < p_len; j++) {
				if(p[j] == '?' || p[j] == s[i]) {
					dp[i+1][j+1] = dp[i][j];
				}
				else if(p[j] == '*') {
					dp[i+1][j+1] = (dp[i][j+1] || dp[i+1][j]);
				}
				else {
					dp[i+1][j+1] = false;
				}
			}
		}
		
		return dp[s_len][p_len];
    }
};

int main(void) {
	
	Solution sol;
	string s = "aaaa";
	string p = "*a?";
	
	cout << sol.isMatch(s, p) << endl;

	system("PAUSE");
	return 0;
}
