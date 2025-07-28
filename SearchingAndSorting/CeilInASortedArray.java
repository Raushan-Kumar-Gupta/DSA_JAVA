
package SearchingAndSorting;
class Solution {
    public int findCeil(int[] arr, int x) {
        // code here
        int n = arr.length;
        int ans = -1;
        int low =0, high=n-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(x<=arr[mid]){
                ans = mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
}
