public class TestClassSelection {
    public TestClassSelection(MyMap myMap){
        long startTime, endTime, elapsedTime;
        startTime = System.nanoTime();
        SelectionSortMyMap selectionSortMyMap = new SelectionSortMyMap(myMap);
        endTime = System.nanoTime();
        System.out.println("\n\nThe sorted map using selection sort:\n" + selectionSortMyMap.getSortedMap());
        elapsedTime = endTime - startTime;
        System.out.println("The time past during selection sort: " + elapsedTime + "ns");
    }
}
