/** The insertion sort algorithm implementation to sort MyMap data type. */
public class InsertionSortMyMap {
    private MyMap unsortedMap;
    private MyMap sortedMap;


    /**
     * The constructor method that takes unsorted MyMap instance and creates a sorted
     * MyMap instance.
     * @param unsortedMap
     */
    public InsertionSortMyMap(MyMap unsortedMap){
        this.unsortedMap = unsortedMap;
        int unsortedMapSize = this.unsortedMap.getMap().size();
        this.sortedMap = new MyMap();

        char[] aux = new char[unsortedMapSize];
        int i = 0;
        for (char key : this.unsortedMap.getMap().keySet()){
            aux[i++] = key;
        }
        sort(aux);
        for (char c : aux){
            sortedMap.put(c, this.unsortedMap.get(c));
        }
    }


    private void sort(char[] aux){
        for (int i = 1; i < aux.length; i++){
            insert(aux, i);
        }
    }


    private void insert(char[] aux, int nextPos){
        char nextVal = aux[nextPos];
        while (nextPos > 0 && unsortedMap.get(nextVal).getCount() < 
                              unsortedMap.get(aux[nextPos-1]).getCount()){
            aux[nextPos] = aux[nextPos-1];
            nextPos--;
        }
        aux[nextPos] = nextVal;
    }


    /**
     * The getter method for sorted map
     * @return  The sorted map.
     */
    public MyMap getSortedMap(){
        return sortedMap;
    }
}
