class Solution {
public:
    int strStr(string haystack, string needle) {
        if (needle == ""){
            return 0;
        }
        int hlen = haystack.length();
        int nlen = needle.length();
        for (int i = 0; i <= hlen - nlen; i++){
            bool match = true;
            for (int j = 0; j < nlen; j++){
                if (haystack[i + j] != needle[j]) {
                    match = false;
                    break;
                }
            }
            if (match) {
                return i;
            }
        }
        return -1;
        
    }
};