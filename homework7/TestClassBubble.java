public class TestClassBubble {
    public TestClassBubble(MyMap myMap){
        long startTime, endTime, elapsedTime;
        startTime = System.nanoTime();
        BubbleSortMyMap bubbleSortMyMap = new BubbleSortMyMap(myMap);
        endTime = System.nanoTime();
        System.out.println("\n\nThe sorted map using bubble sort:\n" + bubbleSortMyMap.getSortedMap());
        elapsedTime = endTime - startTime;
        System.out.println("The time past during bubble sort: " + elapsedTime + "ns");
    }
}
