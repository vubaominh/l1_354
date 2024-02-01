package lecture2_Quick_MergeSorts;

import java.util.Arrays;

public class MergeSort {
public static void main(String[] args) {
	int[] arr;
	arr = new int[] {6, 4, 3, 2, 13, 7, 1, 5, 23, 5443, 54412, 0, 9, 92, 13, 1303};
	
	
	System.out.print("Unsorted array: ");
	for(int u: arr) {System.out.print(u + " ");};
	
	// Sort:
	mergeSort(arr);
	
	System.out.print("\nMerge Sort:     ");
	for(int u: arr) {System.out.print(u + " ");};
}

//---------------------------------------------------------
private static void mergeSort(int[] arr) {
	int len = arr.length;
	int middle = len >>1;
	
	if(len > 1) {

	int[] rightA = new int[len - middle]; // De phong so le
	int[] leftA = new int[middle];

	System.arraycopy(arr, middle, rightA, 0, rightA.length);
	System.arraycopy(arr, 0, leftA, 0, leftA.length);

	// Het

	
	// (Primitive Method) - Parition sang cac left right array: 1/2 
	/*
	int j = 0;
	for(int i = 0 ; i < len; ++i) {
		if(i < middle) {leftA[i] = arr[i];}
		else {rightA[j] = arr[i];  ++j;}  // Mot nua > middle => Cho sang rightA
	}
	*/
	
	
	// Recursion for 1/2 arrays (logn):
	mergeSort(leftA); mergeSort(rightA);
	// Until len == 1;
	
	// 2nd phase:
	merge(leftA, rightA, arr);  // Build up pyramid-ly
	}
	
}

//---------------------------------------------------
// 2nd phase:
private static void merge(int[] leftA, int[] rightA, int[] OGa) {
	int len = OGa.length;
	int leftSize = len >>1;
	int rightSize = len - leftSize; // De phong so le
	
	// Check:
	int left = 0, right = 0;
	
	int i = 0;
	// Compare left to right. If smaller => add first to OG array:
	
	// Phan chia thanh 2 truong hop: Tuan theo boolean AND
	while( (left < leftSize) && (right < rightSize) ) {
		if(leftA[left] < rightA[right]) {
			OGa[i] = leftA[left]; ++i; ++left; }  // Thu tu dau vao cua OGa
		else {   // Mirroring
			OGa[i] = rightA[right]; ++i; ++right; 
		}
	}
	
	// One thing left: La nhu tren, but individually
	while(left < leftSize) {OGa[i] = leftA[left]; ++i; ++left;	}  // Gia su right co het 1-2 => Left chay 3 4 5
	while(right < rightSize) {OGa[i] = rightA[right]; ++i; ++right;}
	
}


}// end of class
