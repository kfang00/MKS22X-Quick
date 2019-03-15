import java.util.*;
import java.io.*;

public class Quick {

/*Modify the array such that:
 *1. Only the indices from start to end inclusive are considered in range
 *2. A random index from start to end inclusive is chosen, the corresponding
 *   element is designated the pivot element.
 *3. all elements in range that are smaller than the pivot element are placed before the pivot element.
 *4. all elements in range that are larger than the pivot element are placed after the pivot element.
 *@return the index of the final position of the pivot element.
 */

  public static int partition (int[] data, int s, int e){
    Random ran = new Random();
    int ranI, pivot, start, ranF;
    if (e == s) {
      ranI = s;
    }
    else {
      ranI = findMedian(s, e, (e + s) / 2);
    }
    pivot = data[ranI];
    if ((data.length > 1) && (s != e)) {
      start = s + 1; //where you start b/c pivot is at the s index
    }
    else {
      start = s;
    }
    int end = e;
    int hold;
    int pIdx = 0;
    data[ranI] = data[s]; //moving pivot to front
    data[s] = pivot;
    while (start != end) {
      ranF = Math.abs(ran.nextInt() % 2);
      if (data[start] > pivot) {
	      hold = data[start]; //swap
        data[start] = data[end];
	      data[end] = hold;
        end = end - 1; //move the end
      }
      else if (data[start] < pivot) {
	      start += 1; //do not swap but move the start
      }
      else {
        if (ranF == 0) { //50% chance of swap
          hold = data[start];
          data[start] = data[end];
  	      data[end] = hold;
          end = end - 1;
        }
        else {
          start += 1;
        }
      }
    }
    if (data[start] <= pivot) { //moving the pivot back
      data[s] = data[start];
      data[start] = pivot;
      pIdx = start;
    }
    else if ((start != s)) {
      data[s] = data[start - 1];
      data[start - 1] = pivot;
      pIdx = start - 1;
    }
    return pIdx;
  }
 
  private static int findMedian(int l, int h, int m) { //finding median value of the lo,hi, and middle elements.
    int[] hold = {l, h, m};
    int greatest = l;
    int smallest = l;
    for (int a = 0; a < 3; a++) {
      if (hold[a] <= smallest) {
	smallest = hold[a];
      }
      if (hold[a] >= greatest) {
	greatest = hold[a];
      }
    }
    for (int a = 0; a < 3; a++) {
      if ((hold[a] != smallest) && (hold[a] != greatest)) {
	return hold[a];
      }
    }
    return m;
  }


/*return the value that is the kth smallest value of the array.
 */
  public static int quickselect(int []data, int k){
    int pivot = partition(data, 0, data.length - 1);
    int s = 0;
    int e = data.length - 1;
    while (pivot != k ) {
      if (pivot < k ) {
	//if ((pivot + 1) < data.length) {
	  s = pivot + 1; //keeping track of previous pivots
        //}
        pivot = partition(data, s, e);
      }
      else {
        //if ((pivot - 1) >= 0) {
	  e = pivot - 1; //keeping track of previous pivots
        //}
        pivot = partition(data, s, e);
      }
    }
    return data[pivot];
  }

/*Modify the array to be in increasing order. 
 */   
  public static void quicksort(int[] data) {
    quicksortH(data, 0, data.length - 1);
  }

  private static void quicksortH(int[] data, int s, int e) {
    int pivot;
    if (s >= e) {
      return;
    }
    pivot = partition(data, s, e)
    quicksortH(data, pivot + 1, e);
    quicksortH(data, s, pivot - 1);
  }
}
