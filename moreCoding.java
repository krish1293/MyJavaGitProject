import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;



public  class moreCoding{
    
    public static void main(String[] args) {

        // 2. given an array and int m, find average of m groups in o(n)
        int[] arr = {2, 5, 7, 1, 9, 3, 9};
        int m = 4;
        float avg = avgofMgrps(arr, m);
        System.out.println("Average of " + m + " groups in " + Arrays.toString(arr) + " is " + avg);

        // 3. Given an array and target, find all pairs whose sum is equal to target
        findAllPairs(new int[] {2, 4, 4, 6, 5, -10, 8, 5, 10,20}, 10);

        // 7. first unique character in a string
        System.out.println("First Unique char in 'aapple' is " + firstUniqueChar("aapple"));

        // 10. Reverse the order of words in a sentence.
        String s = "GeeksForGeeks is best site to practice coding.";
        System.out.println("Reverse of " + s + " is " + revWordsInSnt(s));
    } // main

    // 1. Reverse linked list

    // 2. Given an array and int m, find average of m groups in o(n)
    public static float avgofMgrps(int []arr, int m){
        int len = arr.length;
        float avgSum = 0;
        int i = 0;
        float sumOfM = 0;
        
        for(;i < m; i++){
            sumOfM = sumOfM + arr[i];
        }
        avgSum = sumOfM/m;

        for(;i < len; i++){
            sumOfM = sumOfM - arr[i-m] + arr[i];
            avgSum = avgSum + (sumOfM/m);
        }

        return (avgSum / (len - m + 1));

    } //avgofMgrps

    // 3. Given an array and target, find all pairs whose sum is equal to target.
    public static void findAllPairs(int []arr, int target){
         
        Arrays.sort(arr);
        int start = 0;
        int end = arr.length - 1;

        while(start < end){
            if(arr[start] + arr[end] == target){
                System.out.println(arr[start] + " + " + arr[end] + " = " + target);
                start++;
                end--;
            }
            else if(arr[start] + arr[end] < target){
                start++;
            }
            else if(arr[start] + arr[end] > target){
                end--;
            }    
          
        }

    } //findAllPairs

    // 4. Brackets Matching

    // 5. Pair of range, merge them

    // 6. Add two linked lists

    // 7. First unique character in a string
    public static char firstUniqueChar(String str){
        Map<Character, Integer> hs = new HashMap<Character, Integer>();
        char []arr = str.toCharArray();
        char uniqueCh = ' ';
        int value = 0;

        for(int i = 0; i < arr.length; i++){
            if(!hs.containsKey(arr[i])){
                hs.put(arr[i], 1);
            }
            else{
                value = hs.get(arr[i]);
                value++;
                hs.put(arr[i], value);
            }
        }
        System.out.println(hs);

        for(int i = 0; i < arr.length; i++){
            if(hs.get(arr[i]) == 1){
                return arr[i];
            }
        }

        return 0;
    } //firstUniqueChar

    // 8. Write a functions that finds and returns the node with the second highest value in a Binary Search Tree. 
    // Assume BST is valid, but not necessarily complete or balanced.

    // 9. Largest sum of path in 2D array.

    // 10. Reverse the order of words in a sentence.
    public static String revWordsInSnt(String sentence){
        
        if(sentence == null || sentence.length() == 0){
            return " ";
        }
        String delims = "[\\W]";
        String[] words = sentence.split(delims);
        StringBuffer rev = new StringBuffer();
        
        for(int i = words.length - 1; i >= 0; i--){
            if(!words.equals(" ")){
                rev.append(words[i]).append(" ");
            }
        }
        return rev.substring(0, rev.length() - 1);

    } // revWordsInSnt

    // 11. Validate BST

    // 12. 

} // moreCoding