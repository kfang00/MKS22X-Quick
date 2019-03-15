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
    if (s != 0) {
      start = 1;
    }
    else {
      start = 0;
    }
    int end = data.length - 1;
    int hold;
    int pIdx = 0;
    data[ranI] = data[0];
    data[0] = pivot;
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
      data[0] = data[start];
      data[start] = pivot;
      pIdx = start;
    }
    else if ((start != 1)) {
      data[0] = data[start - 1];
      data[start - 1] = pivot;
      pIdx = start - 1;
    }
    return pIdx;
  }

/*return the value that is the kth smallest value of the array.
 */
  public static int quickselect(int []data, int k){
    int pivot = partition(data, 0, data.length - 1);
    int preP = data.length;
    while (pivot != (k - 1)) {
      if (pivot < (k - 1)) {
        pivot = partition(data, pivot + 1, preP - 1);
      }
      else {
        preP = pivot;
        pivot = partition(data, preP + 1, pivot - 1);
      }
    }
    return data[pivot];
  }
}
