/*

Q1) Dutch National Flag Problem
Given an array with 0’s ,1’s ,2’s . Arrange them such that all 0’s , all 1’s and all 2’s are grouped
together in a sorted manner.
Ex. Input: 0 1 0 1 2 0 1 2 0 1 1
     Output: 0 0 0 0 1 1 1 1 1 2 2

*/

public class Beginner {

    /*
    First approach is sort the given array .
    Time Complexity O(n log n)(Using Quick or Merge Sort).

    Try to do it in linear time.

    For linear time, we Simply partition array into 4 groups using 3 variable Low, Mid, High.

    A[1..Low-1] will have 0's.
    A[Low..Mid-1] will have 1's.
    A[Mid..High] Unknown.
    A[High+1..N] will have 2's. 
    */

    public static void solution(int[] a){
        int n = a.length;
        int l, m, h, temp;
        l=0;
        m=0;
        h = n-1;
        temp = 0;

        while(m <= h)
        {
            if(a[m] == 0)
            {
                temp = a[l];
                a[l] = a[m];
                a[m] = temp;
                l++;
                m++;
            }
            else if(a[m] == 1)
            {
                m++;
            }
            else
            {
                temp = a[m];
                a[m] = a[h];
                a[h] = temp;
                h--;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1,1,1,0,1,2,2,0,1,0,2};
        solution(a);
        for (int each: a) {
            System.out.print(each + " ");
        }
    }

}