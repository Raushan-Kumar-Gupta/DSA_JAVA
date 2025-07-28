// User function Template for Java
package SearchingAndSorting;
import java.util.ArrayList;
import java.util.List;

class Solution {
    // Function to find common elements in three arrays.
    public List<Integer> commonElements(List<Integer> arr1, List<Integer> arr2,
                                        List<Integer> arr3) {
        // Code Here
        List<Integer> ans = new ArrayList<>();
        int n1=arr1.size();
        int n2=arr2.size();
        int n3=arr3.size();
        int i=0, j=0, k=0;
        while(i<n1 && j<n2 && k<n3){
            if(arr1.get(i).equals(arr2.get(j)) && arr2.get(j).equals(arr3.get(k))){
               if (ans.isEmpty() || !ans.get(ans.size() - 1).equals(arr1.get(i))) {
                    ans.add(arr1.get(i));
            }

                i++; j++; k++;
            }
            else if(arr1.get(i)<=arr2.get(j) && arr1.get(i)<=arr3.get(k)) i++;
            else if(arr2.get(j)<=arr3.get(k) && arr2.get(j)<=arr1.get(i)) j++;
            else k++;
        }
        return ans;
        
    }
}