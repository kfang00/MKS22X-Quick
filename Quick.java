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

  public int partition (int[] data, int s, int e){
    Random ran = new Random();
    int ranI = (ran.nextInt() % (e - s)) + s;
    int pivot = data[ranI];
    int start = 1;
    int end = data.length - 1;
    int hold;
    int pIdx = 0;
    data[ranI] = data[0];
    data[0] = pivot;
    while (start != end) {
      if (data[start] > pivot) {
	hold = data[start];
        data[start] = data[end];
	data[end] = hold;
        end = end - 1;
      }
      else if (data[start] < pivot) {
	start += 1;
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


  }
}