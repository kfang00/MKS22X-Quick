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
    int pivot, start, hold;
    int end = e;
    if ((data.length > 1) && (s != e)) {
      start = s + 1; //where you start b/c pivot is at the s index
    }
    else {
      start = s;
    }
    if (e == s) {
      pivot = s;
    }
    else {
      pivot = findMedian(s, e, (e + s) / 2);
    }
    hold = data[pivot];
    data[pivot] = data[s]; //moving pivot to front
    pivot = hold;
    data[s] = pivot;
    while (start != end) {
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
        if (Math.abs(ran.nextInt() % 2) == 0) { //50% chance of swap
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
      return start;
    }
    else if ((start != s)) {
      data[s] = data[start - 1];
      data[start - 1] = pivot;
      return start - 1;
    }
    return start;
  }
 
  public static int[] partitionO(int[] data, int s, int e){
    Random ran = new Random();
    int[] sp = new int[2];
    int pivot, start, hold;
    int end = e;
    int ll = 0;
    int gl = 0;
    if ((data.length > 1) && (s != e)) {
      start = s + 1; //where you start b/c pivot is at the s index
    }
    else {
      start = s;
    }
    if (e == s) {
      pivot = s;
    }
    else {
      pivot = findMedian(s, e, (e + s) / 2);
    }
    hold = data[pivot];
    data[pivot] = data[s]; //moving pivot to front
    pivot = hold;
    data[s] = pivot;
    while (start != end) {
      if (data[start] > pivot) {
	      hold = data[start]; //swap
        data[start] = data[end];
	      data[end] = hold;
        end = end - 1; //move the end
      }
      else if (data[start] < pivot) {
        if (ll != 0) {
	      hold = data[start]; //swap
              data[start] = data[ll];
	      data[ll] = hold;
              if (ll <= gl) {
		ll++;
	      }
	      gl = start;
        }
	      start += 1; //do not swap but move the start
      }
      else {
          if (ll == 0) {
	    ll = start;
            gl = start;
          }
          else {
 	    gl = start;
          }
          start += 1;
        
      }
    }
    if (ll != 0) {
    if (data[start] < pivot) { //moving the pivot back
      data[s] = data[start];
      data[start] = pivot;
      gl++;
    }
    else if ((ll != s) && (data[start] > pivot)) {
      data[s] = data[ll - 1];
      data[ll - 1] = pivot;
      ll--;
    }
    else if ((ll != s) && (data[start] == pivot)) {
      gl++;
      data[s] = data[ll - 1];
      data[ll - 1] = pivot;
      ll--;
    }
    sp[0] = ll;
    sp[1] = gl;
    }
    else {
      if (data[start] <= pivot) { //moving the pivot back
      data[s] = data[start];
      data[start] = pivot;
      sp[0] = start;
      sp[1] = start;
      }
      else if ((start != s)) {
      data[s] = data[start - 1];
      data[start - 1] = pivot;
      sp[0] = start - 1;
      sp[1] = start - 1;
      }
    }
    return sp;
  }

  private static int findMedian(int l, int h, int m) { //finding median value of the lo,hi, and middle elements.
    int[] hold = {l, h, m};
    int greatest = l;
    int smallest = l;
    int sI = 0;
    int gI = 0;
    for (int a = 0; a < 3; a++) {
      if (hold[a] <= smallest) {
	smallest = hold[a];
        sI = a;
      }
      if (hold[a] >= greatest) {
	greatest = hold[a];
        gI = a;
      }
    }
    if ((gI + sI) == 3) {
      return hold[0];
    }
    else if ((gI + sI) == 2) {
      return hold[1];
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
	s = pivot + 1; //keeping track of previous pivots
        pivot = partition(data, s, e);
      }
      else {
	e = pivot - 1; //keeping track of previous pivots
        pivot = partition(data, s, e);
      }
    }
    return data[pivot];
  }

  private static void insertionSort(int[] ary, int start, int end) {
	int hold = 0;
	int idx = start;
	int hold1 = 0;
	for (int a = start + 1; a < end + 1; a++) {
	    hold = ary[a];
	    idx = a - 1;
	    while ((idx >= start) && (hold < ary[idx])) {
		    hold1 = ary[idx];
		    ary[idx + 1] = hold1; 
		    idx = idx - 1;
	    }
	    ary[idx + 1] = hold;	
	    //System.out.println(printArray(ary));
	}
    }

/*Modify the array to be in increasing order. 
 */   
  public static void quicksort(int[] data) {
    quicksortH(data, 0, data.length - 1);
  }

  private static void quicksortH(int[] data, int s, int e) {
    int[] pivot;
    if (s >= e) {
      return;
    }
    if ((e - s) <= 50) {
      insertionSort(data, s, e);
    }
    else {
    pivot = partitionO(data, s, e);
    quicksortH(data, pivot[1] + 1, e);
    quicksortH(data, s, pivot[0] - 1);
    }
    
  }
}
