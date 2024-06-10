import java.util.ArrayList;

public class Activity9 {
    public static void main(String[] args) {
        ArrayList <String> myList= new ArrayList<>();
        myList.add("Tom");
        myList.add("Harry");
        myList.add("Dick");
        myList.add("Rob");
        myList.add("Kate");

        System.out.println("Print all the Names:");
        for (String str : myList) {
            System.out.println(str);  
        }
        System.out.println("3rd Name of the List is: " + myList.get(2));
        System.out.println("Is Rob is on the list? "+ myList.contains("Rob"));
        System.out.println("Size of the array is :" + myList.size());

        myList.remove("Rob");
        System.out.println("Is Rob is on the list? "+ myList.contains("Rob"));  
        System.out.println("New Size of the array is :" + myList.size());
    }
    

}
