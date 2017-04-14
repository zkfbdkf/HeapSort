public class HeapSort {
	public static void main(String[] args) {
		int[] arr = { 0, 8, 2, 6, 3, 27, 16, 19, 21, 15, 11, 23};

		MaxHeap arr1 = new MaxHeap(arr);

		System.out.println("Original tree");
		arr1.showArray();

		arr1.maxHeap();

		System.out.println("Sorted tree");
		arr1.showArray();
	}
}

class MaxHeap {
	private int arr[];
	public int step = 1;

	public MaxHeap(int[] arr) {
		this.arr = arr;
	}

	public void maxHeap() {
		maxHeapify((arr.length - 1) / 2);
	}

	public void maxHeapify(int parent) {
		int pvalue;
		for (int i = parent; i > 0; i--) {
			pvalue = arr[i];
			try {
				if (pvalue < max(arr[i * 2], arr[i * 2 + 1])) {// value compare
					swap(i, maxindex(i * 2, (i * 2 + 1)));// index value

					maxHeapify((arr.length - 1) / 2);//maxHeapify again
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				if (pvalue < arr[i * 2]) {// value compare
					swap(i, i * 2);// index value
				}
			}
		}
	}

	private int maxindex(int Left, int Right) {
		if (arr[Left] > arr[Right]) {
			return Left;
		} else
			return Right;
	}

	private void swap(int parent, int maxchild) {
		int temp = arr[parent];
		arr[parent] = arr[maxchild];
		arr[maxchild] = temp;

		System.out.println("step: "+ step);
		showArray();
		step++;
	}

	private int max(int Left, int Right) {
		if (Left > Right) {
			return Left;
		} else
			return Right;
	}

	public void showArray() {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(i + ": " + arr[i]);
		}
		System.out.println("");
	}
}
