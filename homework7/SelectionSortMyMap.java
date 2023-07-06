
/** The selection sort algorithm implementation to sort MyMap data type. */
public class SelectionSortMyMap {
    /** The unsorted map */
    private MyMap unsortedMap;
    /** The sorted map */
    private MyMap sortedMap;

    /**
     * The constructor method that takes unsorted MyMap instance and creates a sorted
     * MyMap instance.
     * @param unsortedMap
     */
    public SelectionSortMyMap(MyMap unsortedMap){
        this.unsortedMap = unsortedMap;
        int unsortedMapSize = unsortedMap.getMap().size();

        this.sortedMap = new MyMap();

        char[] aux = new char[unsortedMapSize];
        int i = 0;
        for (char key : this.unsortedMap.getMap().keySet()){
            aux[i++] = key;
        }

        sort(aux);

        for (char key : aux){
            this.sortedMap.put(key, this.unsortedMap.get(key));
        }
    }


    private void sort(char[] aux){
        for (int i = 0; i < aux.length-1; i++){
            int minIndex = i;
            int minCount = unsortedMap.get(aux[i]).getCount();
            for (int j = i+1; j < aux.length; j++){
                int countKeyJ = unsortedMap.get(aux[j]).getCount();
                if (countKeyJ < minCount){
                    minIndex = j;
                    minCount = countKeyJ;
                }
            }
            swap(aux, i, minIndex);
        }
    }
    

    // The helper method for sort that interchanges the contents of two position.
    private void swap(char[] aux, int i, int j){
        char tmp = aux[i];
        aux[i] = aux[j];
        aux[j] = tmp;
    }

    /**
     * The getter method for sorted map.
     * @return The sorted map.
     */
    public MyMap getSortedMap(){
        return sortedMap;
    }
}
