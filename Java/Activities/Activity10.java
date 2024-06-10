import java.util.HashSet;
import java.util.Set;

public class Activity10 {
    public static void main(String[] args) {
        Set<String> hs = new HashSet<>();
        hs.add("One");
        hs.add("Two");
        hs.add("Three");
        hs.add("Four");
        hs.add("Five");
        hs.add("Six");

        System.out.println("Size of Hashset is :" + hs.size());

        System.out.println("Remove Two from HashSet: " +hs.remove("Two"));

        if(hs.remove("Eight")){
            System.out.println("Eight Removed from the HashSet");
        } else{
            System.out.println("Eight is not present in the HashSet");
        }

        System.out.println("Checking if Ten is Present : " +hs.contains("Ten"));

        System.out.println("Updated HashSet is: " +hs);
            
        }
        
    }
