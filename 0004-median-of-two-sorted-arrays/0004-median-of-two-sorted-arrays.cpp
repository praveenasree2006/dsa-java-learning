#include <vector>
#include <algorithm> 

class Solution {
public:
    double findMedianSortedArrays(std::vector<int>& nums1, std::vector<int>& nums2) {
        
        std::vector<int> mergedArray;
        mergedArray.reserve(nums1.size() + nums2.size()); 
        mergedArray.insert(mergedArray.end(), nums1.begin(), nums1.end());
        mergedArray.insert(mergedArray.end(), nums2.begin(), nums2.end());

    
        std::sort(mergedArray.begin(), mergedArray.end());

        int n = mergedArray.size();
        if (n % 2 == 1) {
            
            return static_cast<double>(mergedArray[n / 2]);
        } else {
            
            return static_cast<double>(mergedArray[n / 2 - 1] + mergedArray[n / 2]) / 2.0;
        }
    }
};