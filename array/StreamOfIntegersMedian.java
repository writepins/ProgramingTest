package array;

//will also find median of a stream of integers
//1. build min and max heap out of stream of integers
//2. add min and max heap / 2 will be the median

// time complexity heap sort - nlogn
// insertion - logn
//Heap is a kind of data structures based on complete tree principle. 
//a complete binary search tree of N levels has at least 2^N-1 nodes in it

public class StreamOfIntegersMedian {
	private static int MAX_SIZE = 10;
	private static int size = 0;
	
	public static void main(String [] args) {
		int [] heap  = new int[MAX_SIZE];
		
		
		for (int i = 1; i < 11; i++){
			insert(heap, size, i);
		}
	}
	
	public static void insert(int[] heap, int size, int val){
		if (size >= MAX_SIZE) {
			System.out.println("heap is full");
			return;
		}
		else {
			heap[size] = val;
			size++;
			shiftUp(heap, val);
		}
	}
	
	public static void shiftUp(int [] heap, int val){
		int parent = val / 2;
		if (val > 1) {
			if (heap[parent] < heap[val]){
				swap(heap, parent, val);
				shiftUp(heap, parent);
			}
		}
	}
	
	public static void swap(int [] heap, int parent, int val){
		int temp = heap[parent];
		heap[parent] = heap[val];
		heap[val] = temp;
	}
	
	public static void delete(int [] heap, int val){
		if (size < 1){
			return;
		}else {
			swap(heap, heap[0], heap[size]);
			size--;
			heapify(heap, 0, size);
		}
	}
	
	//left child = 2i+1, right child = 2i+2, parent i / 2
	// max heapify
	public static void heapify(int [] heap, int i, int length){
		int largest = i;
		int left, right;
		left = leftChild(i);
		right = rightChild(i);
		
		if (left <= length && heap[largest] < heap[i]){
			largest = left;
		}
		if(right <= length && heap[largest] > heap[right]){
			largest = right;
		}
		if (largest != i){
			swap(heap, i, largest);
			heapify(heap, largest, length);
		}
	}
	
	public static void MinHeapify(int [] heap, int i, int length){
		int minimum = i;
		int left, right;
		left = leftChild(i);
		right = rightChild(i);
		
		if (left <= length && heap[minimum] > heap[i]){
			minimum = left;
		}
		if(right <= length && heap[minimum] < heap[right]){
			minimum = right;
		}
		if (minimum != i){
			swap(heap, i, minimum);
			heapify(heap, minimum, length);
		}
	}
	
	public static int leftChild(int i){
		return (2 * i) + 1;
	}

	public static int rightChild(int i){
		return (2 * i) + 2;
	}
	
	/*1. Start from the middle element of the array, 
	  2. let's say i Heapify with given index.
	  3. Decrease index by one. Repeat step 2 till we reach first element.*/
	public static void buildHeap(int [] heap, int length){
		int i = length / 2 + 1;
		for (; i >= 0; i--){
			heapify(heap, i, length);//either min or max
		}
	}
	
	/* 
1. Build MAX heap from the given array.
2. Swap first and last element of the array. Last element is now at its proper position.
3. Decrease the effective size of heap to be heapify.
4. Heapify with first element of the array.
5. Repeat step 2 , 3 and 4 till we reach the second element of the array.*/
	
	public static void heapSort(int [] heap, int length){
		buildHeap(heap, length);
		swap(heap, 0, length);
		length--;
		heapify(heap, 0, length);
	}
}
