public class Activity2 {
    public static void main(String[] args) {
        int[] nums = {10,15,20,10,20,20};

        int searchnum = 10;
        int sum =30;

        System.out.println("Result: " +result(nums , searchnum, sum));
        
    }
    public static boolean result(int[] numbers, int searchnum, int sum){
        int temp_sum = 0;
        for(int  number: numbers){
            if (number == searchnum){
                temp_sum += searchnum;
            }
            if (temp_sum > sum){
                break;
            }
        }
        return temp_sum == sum;
    }

}
