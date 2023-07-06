
public class Main {
    public static void main(String[] args) {

        System.out.println("-----------------------------------");
        MyMap myMap = new MyMap("Buzzing bees buzz.");
        System.out.println("\n\nThe original (unsorted) map:\n" + myMap);
        TestClassMerge testClassMerge1 = new TestClassMerge(myMap);
        TestClassSelection testClassSelection1 = new TestClassSelection(myMap);
        TestClassInsertion testClassInsertion = new TestClassInsertion(myMap);
        TestClassBubble testClassBubble = new TestClassBubble(myMap);
        TestClassQuick testClassQuick = new TestClassQuick(myMap);
        System.out.println("-----------------------------------");


        // Best case
        System.out.println("-----------------------------------");
        MyMap myMap2 = new MyMap("a bb ccc dddd ddddd");
        System.out.println("\n\nThe original (unsorted) map:\n" + myMap2);
        TestClassMerge testClassMerge2 = new TestClassMerge(myMap2);
        TestClassSelection testClassSelection2 = new TestClassSelection(myMap2);
        TestClassInsertion testClassInsertion2 = new TestClassInsertion(myMap2);
        TestClassBubble testClassBubble2 = new TestClassBubble(myMap2);
        TestClassQuick testClassQuick2 = new TestClassQuick(myMap2);
        System.out.println("-----------------------------------");


        // Worst case
        System.out.println("-----------------------------------");
        MyMap myMap3 = new MyMap("dddd ccc bb a");
        System.out.println("\n\nThe original (unsorted) map:\n" + myMap3);
        TestClassMerge testClassMerge3 = new TestClassMerge(myMap3);
        TestClassSelection testClassSelection3 = new TestClassSelection(myMap3);
        TestClassInsertion testClassInsertion3 = new TestClassInsertion(myMap3);
        TestClassBubble testClassBubble3 = new TestClassBubble(myMap3);
        TestClassQuick testClassQuick3 = new TestClassQuick(myMap3);
        System.out.println("-----------------------------------");

    }
}
