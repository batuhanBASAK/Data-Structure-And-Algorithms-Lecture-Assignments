import java.util.Set;


/**
 * Implementation of a class that sorts given MyMap by using merge sort algorithm.
 */
public class MergeSortMyMap {
	/** The unsorted map */
	private MyMap unsortedMap;
	/** The sorted, result, map */
	private MyMap sortedMap;
	
	/**
	 * The constructor that takes intance of MyMap class to create sorted version of it.
	 * @param unsortedMap The intance of MyMap class whose map is unsorted.
	 */
	public MergeSortMyMap(MyMap unsortedMap) {
		this.unsortedMap = unsortedMap;
		this.sortedMap = new MyMap();
		
		// Create an auxiliary array to hold keys of unsorted map.
		int unsortedMapSize = unsortedMap.getMap().size();
		char[] arr = new char[unsortedMapSize];
		// Fill the auxiliary array.
		Set<Character> keySet = unsortedMap.getMap().keySet();
		int i = 0;
		System.out.println("keySet : " + keySet);
		for (char c : keySet) {
			arr[i++] = c;
		}

		// Sort the key array respect to its count value.
		mergeSort(arr);
		// The keys in arr are sorted. Fill the sorted map respect to 
		// the order of arr.
		for (i = 0; i < arr.length; i++) {
			sortedMap.put(arr[i], unsortedMap.get(arr[i]));
		}
	}
	
	
	// The merge sort algorithm implementation for MyMap class.
	// Gets the array of keys and compare them respect to 
	// the count value of entry class Info.
	private void mergeSort(char[] arr) {
		int size = arr.length;
		if (size <= 1) {
			return;
		}
		
		int mid = size / 2;
		char[] left = new char[mid];
		char[] right = new char[size-mid];
		for (int i = 0; i < mid; i++)
			left[i] = arr[i];
		for (int i = mid; i < size; i++)
			right[i-mid] = arr[i];
		
		mergeSort(left);
		mergeSort(right);
		merge(left, right, arr);
	}
	

	// The helper method for mergeSort method by merging arrays.
	private void merge(char[] left, char[] right, char[] arr) {
		int leftIndex = 0;
		int rightIndex = 0;
		int arrIndex = 0;
		
		
		while (leftIndex < left.length && rightIndex < right.length) {
			int countLeftOne = unsortedMap.get(left[leftIndex]).getCount();
			int countRightOne = unsortedMap.get(right[rightIndex]).getCount();
			if (countLeftOne <= countRightOne) {
				arr[arrIndex++] = left[leftIndex++];
			}
			else {
				arr[arrIndex++] = right[rightIndex++];
			}
		}
		
		while (leftIndex < left.length) {
			arr[arrIndex++] = left[leftIndex++];
		}
		
		while (rightIndex < right.length) {
			arr[arrIndex++] = right[rightIndex++];
		}
	}
	
	/**
	 * The getter method for sortedMap. The sortedMap is an instance of MyMap class.
	 * @return The sortedMap.
	 */
	public MyMap getSortedMap() {
		return sortedMap;
	}
	
}





