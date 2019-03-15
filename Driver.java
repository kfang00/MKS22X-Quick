import java.util.Arrays;
import java.util.Random;
import java.lang.Math;

public class Driver {
    public static boolean test(int[] data, int k, int start, int end) {
        for (int i = start; i < end; i++) {
            if (i < k) {
                if (data[i] > data[k]) {
                    return false;
                }
            } else if (i > k) {
                if (data[i] < data[k]) {
                    return false;
                }
            }
        }
        return true;
    }
public static void fillRandom(int[] data){
	    Random r = new Random();
	    int index = 0;
	    for(int i = 0; i < data.length; i++){
	      data[i] =  i; //r.nextInt(data.length); fills with random numbers
	    }
	    for (int i = 0; i < data.length; i++){
	      int copy = data[i];
	      int rand = r.nextInt(data.length);
	      data[i] = data[rand];
	      data[rand] = copy;
	    }
	 }
	public static void printArray(int[] data){
		String out = "[";
		for(int i : data){
			out+=i;
			if (i != data[data.length-1]){
				out+=", ";
			}
		}
		System.out.println(out+"]");
	}
	public static void main(String[] args){
		Random r = new Random(); int sucesses = 0;
		int tests = 401; System.out.println("testing array sizes 1-400 having numbers from 0-n, asking for a random smallest int. (arrays do not contain duplicates)");
		for (int i = 1; i < tests; i++){
			int[] data = new int[i];
			int select = i <= 1 ? 0 : r.nextInt(i);
			fillRandom(data);
			//printArray(data);                                            |
			int result = Quick.quickselect(data, select); //sucess message V
			if (result == select) {++sucesses;}//System.out.println("your array of size "+i+" sucessfully found the "+select+"th smallest one"); ++sucesses;}
			else {
				if (data.length < 40) {System.out.print("final Array: "); printArray(data);System.out.println();}
				System.out.println("Uh Oh, your array of size "+i+" DID NOT find the "+select+"th smallest one. It returned " + result +" instead of " + select);
			}
		}
		System.out.println("******************************************");
		System.out.println("***testing with duplicates in the array***");
		tests++; int[] data = new int[10000];
		for (int i = 0; i < 100; i++){data[i] = r.nextInt(2);} Quick.quickselect(data,500); Quick.quickselect(data,99);
		if (Quick.quickselect(data,0) == 0){++sucesses;} //chance of this driver failing here ;)
		else {System.out.println("uh oh a large array of ones and zeros did not work");}
		System.out.println("******************************************");

		System.out.println("You have had " + sucesses + " sucesses and " + (tests-sucesses-1) + " failures.");
		System.out.println( (sucesses == tests-1 ? "CONGRATULATIONS!!!" : "Uh Oh")+" Thats " + (sucesses / (tests-1.0)) * 100 + "% sucess rate.");
		if (sucesses <= tests-100) {System.out.println("Yikes!!! Maybe he won't test some of those cases right?");}
		else if (sucesses < tests-1) {System.out.println("Maybe if you compile and run again it will work.");} 
  	
int[] data1 = {10, 80, 30, 90, 40, 50, 70};
        //System.out.println(Arrays.toString(data1));
        int index1a = Quick.partition(data1, 0, 6);
        System.out.println("1a: " + test(data1, index1a,0,6));
        //System.out.println(Arrays.toString(data1) + " "+index1a+"\n");
        //System.out.println(Arrays.toString(data1));
        int index1b = Quick.partition(data1, 2, 5);
        System.out.println("1b: " + test(data1, index1b,2,5));
        //System.out.println(Arrays.toString(data1) + " "+index1b+"\n");

        int[] data2 = {6, 3, 7, -1, 7, 4, 10, -21};
        //System.out.println(Arrays.toString(data2));
        int index2a = Quick.partition(data2, 2, 7);
        System.out.println("2a: " + test(data2, index2a,2,7));
        //System.out.println(Arrays.toString(data2) + " " + index2a+"\n");
        //System.out.println(Arrays.toString(data2));
        int index2b = Quick.partition(data2, 1, 4);
        System.out.println("2b: " + test(data2, index2b,1,4));
        //System.out.println(Arrays.toString(data2) + "\n");

        int[] data3 = {78};
        //System.out.println(Arrays.toString(data3));
        int index3 = Quick.partition(data3, 0, 0);
        System.out.println("3: " + test(data3, index3,0,0));
        //System.out.println(Arrays.toString(data3) + "\n");

        int[] data4 = {3, 1};
        int index4 = Quick.partition(data4, 0, 1);
        //System.out.println(Arrays.toString(data4));
        System.out.println("4: " + test(data4, index4,0,1));
        //System.out.println(Arrays.toString(data4) + "\n");

        for (int i = 0; i < 100; i++) {
            try {
                Random gen = new Random();
                int[] test = new int[i * 1000 + 1];
                for (int j = 0; j < test.length; j++) {
                    test[j] = gen.nextInt();
                }
                int start = Math.abs(gen.nextInt()) % test.length;
                int end = start + Math.abs(gen.nextInt()) % (test.length - start);
                //System.out.println(start + ", " + end);
                //System.out.println(Arrays.toString(test));
                int index = Quick.partition(test, start, end);
                if (!test(test, index,start,end)) {
                    System.out.print("FAILURE ON LENGTH " + (i * 1000 + 1));
                    System.exit(1);
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.print("FAILURE ON LENGTH " + (i * 1000 + 1));
                System.exit(1);
            }
        }
        System.out.println("R: SUCCESS"); //R for random
   }
}