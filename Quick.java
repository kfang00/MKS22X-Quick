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
      ranI = (e + s) / 2;
    }
    pivot = data[ranI];
    if ((data.length > 1) && (s != e)) {
      start = s + 1;
    }
    else {
      start = s;
    }
    int end = e;
    int hold;
    int pIdx = 0;
    data[ranI] = data[s];
    data[s] = pivot;
    while (start != end) {
      ranF = Math.abs(ran.nextInt() % 2);
      if (data[start] > pivot) {
	      hold = data[start];
        data[start] = data[end];
	      data[end] = hold;
        end = end - 1;
      }
      else if (data[start] < pivot) {
	      start += 1;
      }
      else {
        if (ranF == 0) {
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
    if (data[start] <= pivot) {
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

/*return the value that is the kth smallest value of the array.
 */
  public static int quickselect(int []data, int k){
    int pivot = partition(data, 0, data.length - 1);
    int s = 0;
    int e = data.length - 1;
    while (pivot != k ) {
      if (pivot < k ) {
	//if ((pivot + 1) < data.length) {
	  s = pivot + 1;
        //}
        pivot = partition(data, s, e);
      }
      else {
        //if ((pivot - 1) >= 0) {
	  e = pivot - 1;
        //}
        pivot = partition(data, s, e);
      }
    }
    return data[pivot];
  }

}
