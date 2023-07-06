public class TestClassMerge {
    public TestClassMerge(MyMap myMap){
        long startTime, endTime, elapsedTime;
        startTime = System.nanoTime();
        MergeSortMyMap mergeSortMyMap = new MergeSortMyMap(myMap);
        endTime = System.nanoTime();
        System.out.println("\n\nThe sorted map using merge sort:\n" + mergeSortMyMap.getSortedMap());
        elapsedTime = endTime - startTime;
        System.out.println("The time past during merge sort: " + elapsedTime + "ns");
    }
}
