package Module2;

public class ArrayListPractice {
    public static void main(String[] args) {
//        LinkedList<String> list = new LinkedList<>();
//        list.add("Apple");
//        list.add("Banana");
//        list.add("Orange");
//        list.add("Banana");
//        ((LinkedList<String>)list).addFirst("orange");
//        System.out.println("Original list: " + list);
//
//        // Create a list of elements to remove
//        ArrayList<String> elementsToRemove = new ArrayList<>();
//        elementsToRemove.add("Banana");
//        elementsToRemove.add("Orange");
//        //elementsToRemove.addFirst("Orange");

        // Creating an instance of MyClass
        ArrayListPractice obj = new ArrayListPractice();

        // Accessing instance variables and calling a method
        System.out.println(obj.myVariable);
        obj.myMethod();

    }
    private int myVariable;
    private String myString;

    // No-argument constructor
    public ArrayListPractice() {

        // Initialize instance variables
        myVariable = 0;
        myString = "Hello, world!";
    }

    // Method to demonstrate accessing instance variables
    public void myMethod() {
        System.out.println(myString);
    }

}
