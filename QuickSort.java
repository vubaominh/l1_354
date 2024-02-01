package lecture2_Quick_MergeSorts;

// Quick Sort:
// i j chay | j < pivot: ++i, a[i] <-> a[j]
// Traverse j
// Cuoi cung a[i+1] <-> a[right] (Vo tinh == 'j' );
// Recursive QuickSort( left,i | (i+2),right   EXCLUDED)

public class QuickSort {
public static void main(String[] args) {
	int[] arr = {13,6, 4,3,23, 27, 1, 5, 23, 5443, 54412, 0, 9, 92, 13, 1303};
	
	System.out.print("Unsorted array: ");
	for(int u: arr) {System.out.print(u + " ");};
	// Sort: Phai len-1 o ngoai
	quickSort(arr, 0, arr.length-1);
	
	System.out.print("\nQuick     Sort: ");
	for(int u: arr) {System.out.print(u + " ");};
}



//--------------------------------------------------------
//Alternative
//Co the chuyen else sang static int partition()
//=> i = partititon()  &&  quickSort(a, left, i);
// i luc nay: ranh gioi leftmost <---

static void quickSort(int[] a, int left, int right) {
	int tmp = 0;
	
	// 2 Base Cases:
	if(left >= right) {return;}   // La da xong; <= 1 phan tu
	else if((left +1 == right) && (a[left] > a[right]) ) {   // Chi con 2 phan tu VA swappable
		// Swap:
		tmp = a[right];
		a[right] = a[left];
		a[left] = tmp;
	    }
	// Actually still in-situ
	
	// Cau truc: i j | i di chuyen iff '<=' ONLY
	
	// >= 3 phan tu: left <= right	
	else {
		// i: bien dem
		// j: main traversing
		int i = left -1;  // ~~Vi tri keo ve 0-1 position 
		int pivot = a[right];   // Ko doi

		for(int j = left; j < right;) {
			if(a[j] < pivot) {   // Neu < hoac toi pivot
				                 //=> ++i trc va swap a[i] <-> a[j]
				++i;   // Move i len 1, FIRST
				// Swap: a[i] <-> a[j]
				tmp = a[i];
				a[i] = a[j];
				a[j] = tmp;
				
				++j;  }
			else {++j;} // >= pivot  Case:  Nothing happens; j tiep tuc traverse
		}
		
		// Final Pivot Swap:    *** An may j == right; Tu dong doi ***
		// => Pivot at middle && |<= chot| chot | > chot|
		tmp = a[i+1];      // a[7] 47 vs a[12] 40
		a[i+1] = a[right];
		a[right] = tmp;
		
		
		// Recursive call:
		// Partition from to: 
		quickSort(a, left, i);      // Left to EXCLUDE mid/pivot
		quickSort(a, i+2, right);	// Right from Pivot+1 nhay coc to len-1
	}
	
  }



}// end of class
