public class TestClassQuick {
    public TestClassQuick(MyMap myMap){
        long startTime, endTime, elapsedTime;
        startTime = System.nanoTime();
        QuickSortMyMap quickSortMyMap = new QuickSortMyMap(myMap);
        endTime = System.nanoTime();
        System.out.println("\n\nThe sorted map using quick sort:\n" + quickSortMyMap.getSortedMap());
        elapsedTime = endTime - startTime;
        System.out.println("The time past during quick sort: " + elapsedTime + "ns");
    }
}
