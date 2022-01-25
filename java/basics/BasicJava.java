import java.util.ArrayList;
public class BasicJava {
    public static void OneTo255(){
        for(int i=0; i<=255; i++)
            System.out.println(i);
    }
    //Print all odd numbers between 1 and 255
    public static void PrintOdds(){
        for(int i=0; i<=255; i++){
            if(i%2!=0)
                System.out.println(i);
        }
    }
    //Get the sum of array
    public int GetArraySum(int[] numbers){
        int sum=0;
        for(int i=0; i<numbers.length; i++){
            sum+= numbers[i];
        }
        return sum;
    }
    //print sum
    public static void PrintSum(){
        int sum=0;
        for(int i=0;i<=255;i++){
            sum+=i;
            System.out.println(String.format("New number: %d, Sum:%d", i, sum));
        }
    }
    //iterate thru an array
    public void LoopArray(int[] arr) {
        for(int val: arr)
            System.out.println(val);
    }
    //find max and min
    public static int FindMax(int[] arr){
        int arrayMax= Integer.MIN_VALUE;
        for (int val: arr){
            if(val>arrayMax)
                arrayMax= val;
        }
        return arrayMax;
    }
    public static int FindMin(int[] arr){
        int arrayMin = Integer.MAX_VALUE;
        for(int val:arr){
            if(val < arrayMin)
                arrayMin = val;
        }
        return arrayMin;
    }
    public static ArrayList<Integer> OddArray(){
        ArrayList<Integer> nums= new ArrayList<Integer>();
        for(int i= 0; i<=255; i++){
            if(i %2 !=0)
                nums.add(i);
        }
        return nums;
    }
}
