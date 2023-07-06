/** Modified quick sort algorithm for MyMap class. */
public class QuickSortMyMap {
    /** The unsorted version of map */
    private MyMap unsortedMap;
    /** The sorted map */
    private MyMap sortedMap;

    /**
     * The constructor method that takes unsorted MyMap instance and creates a sorted
     * MyMap instance.
     * @param unsortedMap
     */
    public QuickSortMyMap(MyMap unsortedMap){
        this.unsortedMap = unsortedMap;
        sortedMap = new MyMap();
        int unsortedMapSize = this.unsortedMap.getMap().size();
        char[] aux = new char[unsortedMapSize];
        int i = 0;
        for (char key : this.unsortedMap.getMap().keySet()){
            aux[i++] = key;
        }
        sort(aux, 0, aux.length-1);
        for (i = 0; i < aux.length; i++){
            sortedMap.put(aux[i], this.unsortedMap.get(aux[i]));
        }
    }


    // Implements quick sort which modified for MyMap class.
    private void sort(char[] arr, int low, int high){
        if (low < high) {
            // Choose the pivot element.
            char pivot = arr[high];

            // Partition the array around the pivot.
            int i = low - 1;
            for (int j = low; j < high; j++) {
                if (unsortedMap.get(arr[j]).getCount() <= unsortedMap.get(pivot).getCount()) {
                    i++;
                    char temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }

            // Swap the pivot element with the element at index i + 1.
            char temp = arr[i+1];
            arr[i+1] = arr[high];
            arr[high] = temp;

            // Recursively sort the left and right subarrays.
            sort(arr, low, i);
            sort(arr, i + 2, high);
        }
    }


    /**
     * The getter method for sorted map.
     * @return The sorted map.
     */
    public MyMap getSortedMap(){
        return sortedMap;
    }
}
