package lecture2_Quick_MergeSorts;

import java.util.Arrays;

// Merge Sort:
// Divide and Conquer: Split halves, Sort halves, Merge sorted halves together
// #1: [left / size - left] => Recursive merge(1/2 arr)
// #2: merge(l, r, OGa):
// Phan chia 2 phan keo deu
// leftA[left] < rightA[right]) {OGa[i] = leftA[left]; }
// else:                         OGa[i] = rightA[right]
// I. (left < leftSize) && (right < rightSize) | II. << Rieng le
