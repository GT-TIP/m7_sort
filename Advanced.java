/*
Given a set of time intervals in any order, merge all overlapping intervals into one and output the result which should have only mutually exclusive intervals. Let the intervals be represented as pairs of integers for simplicity. 
For example, let the given set of intervals be {{1,3}, {2,4}, {5,7}, {6,8} }. The intervals {1,3} and {2,4} overlap with each other, so they should be merged and become {1, 4}. Similarly {5, 7} and {6, 8} should be merged and become {5, 8}

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