package lecture1_LinearSorts;

// Shell Sort:
// Optimized Insertion Sort V3
// gap = (len) /2 /2 /2 ...
// Ssanh a[i] vs a[i +k] => Swap tiem can
// Reduce number of swaps

public class ShellSort {
public static void main(String[] args) {

	int[] arr = {6, 4, 3, 2, 13, 7, 1, 5, 23, 5443, 54412, 0, 9, 92, 13, 1303};
	
	System.out.print("Unsorted array: ");
	for(int u: arr) {System.out.print(u + " ");};
	
	// Sort:
	shellSort(arr);
	
	System.out.print("\nShell Sort:     ");
	for(int u: arr) {System.out.print(u + " ");};
	
}

//-----------------------------------------------------------
private static void shellSort(int[] a) {
    int i, j, currentElement, size, gap;
	size = a.length;
    gap = size >>1;
    
    while (gap > 0) {
    	
        for(i = gap; i < size; ++i) {
        	j = i; 
        	currentElement = a[i];
            
            while ((j>=gap) && (currentElement < a[j-gap])) {
                a[j] = a[j-gap];
                j -= gap; 		}
            a[j] = currentElement;    
            }
        gap /= 2;  // gap == 1 => Insertion sort
    }
    
}

} // end of class
