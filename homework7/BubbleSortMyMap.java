/** The bubble sort algorithm implementation to sort MyMap data type. */
public class BubbleSortMyMap{
    private MyMap unsortedMap;
    private MyMap sortedMap;


    /**
     * The constructor method that takes unsorted MyMap instance and creates a sorted
     * MyMap instance.
     * @param unsortedMap
     */
    public BubbleSortMyMap(MyMap unsortedMap){
        this.unsortedMap = unsortedMap;
        sortedMap = new MyMap();

        int unsortedMapSize = this.unsortedMap.getMap().size();
        char[] aux = new char[unsortedMapSize];
        int i = 0;
        for (char key : this.unsortedMap.getMap().keySet()){
            aux[i++] = key;
        }

        sort(aux);
        for (i = 0; i < aux.length; i++){
            sortedMap.put(aux[i], this.unsortedMap.get(aux[i]));
        }
    }


    private void sort(char[] arr){
        for (int i = 0; i < arr.length - 1; i++){
            for (int j = 0; j < arr.length - i - 1; j++){
                if (unsortedMap.get(arr[j]).getCount() > unsortedMap.get(arr[j+1]).getCount()){
                    char temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
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