public class TestClassInsertion {
    public TestClassInsertion(MyMap myMap){    
        long startTime, endTime, elapsedTime;
        startTime = System.nanoTime();    
        InsertionSortMyMap insertionSortMyMap = new InsertionSortMyMap(myMap);
        endTime = System.nanoTime();
        System.out.println("\n\nThe sorted map using insertion sort:\n" + insertionSortMyMap.getSortedMap());
        elapsedTime = endTime - startTime;
        System.out.println("The time past during insertion sort: " + elapsedTime + "ns");

    }
}
