/*
Q3) Merge sorted arrays with extra space of O(1).
Given two sorted array. Merge these two arrays such that the initial numbers (after complete sorting) are in the first array and the remaining numbers are in the second array. Extra space allowed in O(1).
Ex. Input: ar1[] = {1, 5, 9, 10, 15, 20};     ar2[] = {2, 3, 8, 13}; 
public static void merge(int[] arr1, int[] arr2)

*/
public class Advanced {

    public static void merge(int[] arr1, int[] arr2)
    {
        // Iterate through all elements of arr2 starrting from
        // the last element
        int m = arr1.length;
        int n = arr2.length;
        for (int i = n-1; i >= 0; i--)
        {
            /* Find the smallest element greater than arr2[i]. Move all
            elements one position ahead till the smallest greater
            element is not found */
            int j, last = arr1[m-1];
            for (j=m-2; j >= 0 && arr1[j] > arr2[i]; j--)
                arr1[j+1] = arr1[j];
    
            // If there was a greater element
            if (j != m-1)
            {
                arr1[j+1] = arr2[i];
                arr2[i] = last;
            }
            
        }
    }

    public static void main(String[] args) {
        int arr1[] = {1, 5, 9, 10, 15, 20};
        int arr2[] = {2, 3, 8, 13};
        merge(arr1, arr2);
        for (int each: arr1) {
            System.out.print(each + " ");
        }
        System.out.println();
        for (int each: arr2) {
            System.out.print(each + " ");
        }
    }

}
