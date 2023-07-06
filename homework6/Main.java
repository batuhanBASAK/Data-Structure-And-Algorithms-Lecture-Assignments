public class Main {
    public static void main(String[] args) {
        MyMap myMap = new MyMap("Buzzing bees buzz.");
        System.out.println("\n\nThe original (unsorted) map:\n" + myMap);
        MergeSortMyMap mergeSortMyMap = new MergeSortMyMap(myMap);
        System.out.println("\n\nThe sorted map:\n" + mergeSortMyMap.getSortedMap());
    }
}