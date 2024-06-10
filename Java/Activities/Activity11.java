import java.util.HashMap;
import java.util.Map;

public class Activity11 {
    public static void main(String[] args) {
        Map<Integer, String> colors = new HashMap<>();
        
        colors.put(1, "Red");
        colors.put(2, "Green");
        colors.put(3, "Yellow");
        colors.put(4, "Violet");
        colors.put(5, "Orange");

        System.out.println("Initial Colors of the HashMap is: " +colors);

        colors.remove(3);

        System.out.println("New Colors of the HashMap is: " +colors);

        System.out.println("Color Green is present in the List: " +colors.containsValue("Green"));

        System.out.println("Size of the HashMap is: " +colors.size());

        }
    }
