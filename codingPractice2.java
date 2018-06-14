import java.util.*;
//import java.util.String;



public class codingPractice2{

    private static final int INT = -1;

	public static void main(String[] args) {
        
        // 1. addFrac
        addFrac(1, 500, 2, 1500);

        // 2. revStr
        System.out.printf("Rverse String of %s is %s\n", "iceman", revStr("iceman"));

        // 3. powTen
        boolean pow10 = powTen(1000);
        if(pow10){
            System.out.printf("%d is power of 10\n", 1000);
        }
        // 4. Median
        int[] arr1 = {3, 6, 9 ,2};
        int[] arr2 = {10, 8, 1, 4};
        int med = median(arr1, arr2);
        System.out.printf("Median: %d\n", med);

        // 5. pairs
        int[] arr = {3,2,5,4,6,10,1,0,8};
        int k = 10;
        System.out.printf("Total number of pairs adding up to %d are %d\n", k, pairs(arr, k));

        // 6.Robot movment
        String direct = "urdllduruu";
        roboPosition(direct);

        // 7. Spiral print of the matrix
        int rLen = 3;
        int cLen = 6;
        int matrix[][] = { {1,  2,  3,  4,  5,  6},
        {7,  8,  9,  10, 11, 12},
        {13, 14, 15, 16, 17, 18}
        };
        printSpiral(matrix, rLen, cLen);

        // 8. Subarray with 0 sum
        int[] origArr = {4, 2, -3, 1, 6};
        sumZero(origArr);

        // 15. minSteps
        int[] target = {16, 16, 16};
        int len = target.length;
        int steps = minSteps(target, len);
        System.out.println("Minimum number of rsteps required to get the given \n" +
                            " target array is " + steps);
        // 16. 
        System.out.println(anglebetweenHrnSechands(9, 60)+" degree");
        System.out.println(anglebetweenHrnSechands(3, 30)+" degree");

        //18. Longest consecutive substring w/o repeating chars
        String str = "GEEKSFORGEEKS";
        System.out.println("The input string is "+str);
        int maxlen = maxContSubstr(str);
        System.out.println("The length of "
                + "the longest non repeating character is "+maxlen);

        //20. Distinct integers of length 3
        int[] dist = {1, 9, 3, 10, 4, 20, 2};
        subSeq3(dist);

        //21. Count pairs with given sum
        int[] nums = {1, 4, 45, -40, 6, 10, 8, INT, -3};
        int sum = 5;
        System.out.println("Total number of pairs with given  sum " + sum + " is(are) " + countPairs(nums, sum));

        //23. maxRepeatChar
        String chars = "aabbcccaaaabbb";
        consRepeatChar(chars);

        //25. permutations
        String str1 = "abc";
        int index = 0;
        int strLen = str1.length(); 
        findPermutation(str1, index, strLen-1);

        // 26. Smallest subarray with sum greater than target value
        int[] ints = {1, 2, 3, 4};
        int x = 6;
        int min_Sub = smallLen(ints, x);
        System.out.println("Smallest length of subarray: " + min_Sub); 
        
        // 30. Given two words, find if second word is the round rotation of first word.
        String s1 = "ABCDef";
        String s2 = "CDABda";

        boolean roundRot = isRoundRotation(s1, s2);
        System.out.println(roundRot);
        if(roundRot){
            System.out.printf("\n%s is round rotation of %s\n", s2, s1);
        }
        else{
            System.out.printf("\n%s is not round rotation of %s\n", s2, s1);
        }

        // 31. 
        double n = 4.47;
        System.out.println(floatToBinary(n));

        // 35. countzeros
        int a[] = {1, 1, 1, 1, 0, 0, 0};
        System.out.println("Total number of zeros are " + countZeros(a, a.length));
    } // main

    //1. There are two fractions example: F1 = 3/4 and F2 = 5/6. You need to compute their sum and return the result. 
    public static void addFrac(int num1, int den1, int num2, int den2){

        int gcdDen3 = gcd(den1, den2);

        int lcm = (den1*den2)/gcdDen3;

        int newNum = num1*(lcm/den1) + num2 * (lcm/den2);

        int lowest = gcd(lcm, newNum);
        lcm = lcm/lowest;
        newNum = newNum/lowest;

        System.out.printf("%d/%d + %d/%d = %d/%d\n", num1, den1, num2, den2, newNum, lcm); 

    } // addFrac

    public static int gcd(int a, int b){
        if(a==0){
            return b;
        }
        return gcd(b%a, a);
    } // gcd

    //2. Reverse a linked list.
    public static String revStr(String str){
        String rev = " ";
        for(int i = str.length()-1; i >= 0; i--){
            rev += str.charAt(i);
        }
        return rev;

    } // revStr

    //3. Find whether the given number is power of 10 or not
    public static boolean powTen(int num){
        if(num % 10 == 0){
            return true;
        }
        return false;
    } // powTen

    //4. Given two unsorted arrays, find the median (not the brute force approach).
    public static int median(int[] arr1, int[] arr2){
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int[] arr3 = merge(arr1, arr2);
        int len = arr3.length;
        int med = 0;
        if((len % 2) == 1){
            med = arr3[len/2];
        }
        else{
            
            int middle = len/2;
            med = arr3[middle - 1] + arr3[middle];
            med = med/2;
        }  
        
        return med;

    } // median

    public static int[] merge(int[] arr1, int[] arr2){
        int n = arr1.length;
        int m = arr2.length;
        int i = 0;
        int j = 0;
        int k = 0;
        int arr3[] = new int[n+m];
        while(i < n  && j < m){
            if(arr1[i] <= arr2[j]){
                arr3[k++] = arr1[i++];
            }
            else{
                arr3[k++] = arr2[j++];
            }
        }

        while(i < n){
            arr3[k++] = arr1[i++];
        }
        while(j < m){
            arr3[k++] = arr2[j++];
        }

        return arr3;
    } // merge

    //5. Find the total number of pairs in array = k. 
    public static int pairs(int[] arr, int k){
        int countPairs = 0;

        for(int i = 0; i < arr.length - 1; i++){
            for(int j = i + 1; j < arr.length; j++){
                if((arr[i] + arr[j]) == k){
                    countPairs++;
                }
            }
        }

        return countPairs;
    } // pairs

    //6. Given a robot which can only move in four directions, UP(U), DOWN(D), LEFT(L), RIGHT(R). 
    //   Given a string consisting of instructions to move. Output the co-ordinates of robot after the executing the instructions. 
    //   Initial position of robot is at origin(0, 0).
    public static void roboPosition(String str){
        char[] ch = str.toCharArray();
        int up = 0;
        int down = 0;
        int left = 0;
        int right = 0;

        for(int i = 0; i < ch.length; i++){
            if(ch[i] == 'u'){
                up++;
            }
            else if(ch[i] == 'd'){
                down++;
            }
            else if(ch[i] == 'l'){
                left++;
            }
            else if(ch[i] == 'r'){
                right++;
            }
        }
        int y = up - down;
        int x = right - left;

        System.out.printf("Directions %s: coordinates (%d, %d)\n", str, x, y);

        
    } // roboPosition

    //7. Spiral order traversal of the matrix
    public static void printSpiral(int[][] matrix, int rLen, int cLen){
        int rStart = 0;
        int cStart = 0;
        
        while(rStart < rLen && cStart < cLen){

            for(int i = cStart; i < cLen; i++){
                System.out.print(matrix[rStart][i] + " ");
            }
            rStart++;

            for(int i = rStart; i < rLen; i++){
                System.out.print(matrix[i][cLen-1] + " ");
            }
            cLen--;

            if(rStart < rLen){
                for(int i = cLen-1; i >= cStart; i--){
                    System.out.print(matrix[rLen-1][i] + " ");
                }
                rLen--;
            }

            if(cStart < cLen){
                for(int i = rLen - 1; i >= rStart; i--){
                    System.out.print(matrix[i][cStart] +" ");
                    cStart++;
                }
            }
        }
        System.out.println();
    } // printSpiral

    //8. Subarray with 0 sum
    public static void sumZero(int[] arr){
        int len = arr.length;
        int sum = arr[0];
        int start = 0; 

        for(int i = 1; i < len; i++){
            // 
            while(sum > 0 &&  start < i - 1){
                sum -= arr[start++];
            }
            if(sum == 0){
                int p = i - 1;
                System.out.printf("Sum found between %d and %d\n", start, p);
            }

            if(i < len){
                sum += arr[i];
            }
        }
    } // sumZero

    //9. Car has to be given on rent. Different people come and ask for it for interval [s, e] and offer some price p. 
    //   To whom shall the car be given in order to earn maximum.
    public static int maxPrice(int start, int end, int price){
        Map<Integer, Integer> carValue = new HashMap<>();
        int interval = end - start; 
        int max = 0; 
        
        return max;
    }
    //10. Problem for BFS.
    //11. Loop in a linked list
    //12. 5th element from last of linked list
    //13. Tree given with 2 nodes having same child. Find that sort of thing in tree.
    //14. Find the common ancestor of 2 nodes in binary tree.
    //15. Given an array, need to go from 0-n, with almost no. of steps as a[i]. Find minimum steps we need for given array.
    public static int minSteps(int[] arr, int n){
        int numSteps = 0;
        while(true){
            int zeroes = 0;

            int i;
            for(i = 0; i < n; i++){

                if(arr[i]%2 == 1){                   
                    break; 
                }

                if(arr[i] == 0){
                    zeroes++;
                }
            }
            if(zeroes == n){
                return numSteps;
            }

            if(i == n){
                for(int j = 0; j < n; j++){
                    arr[j] = arr[j]/2;
                }
                numSteps++;
            }

            for(int j = i; j < n; j++){
                if(arr[j]%2 == 1){
                    arr[j]--;
                    numSteps++;
                }
            }
        }
    } // minSteps
   
    //16. Angle between hour hand and minute hand at a given time.
    //    Hour hand: 12 hr (720 minutes) to finish 360 degree: 360/720 = 0.5 per minute
    //    Second hand: 60 minutes to finish 360 degree: 360/60 = 6 per minute

    public static int anglebetweenHrnSechands(double hr, double min){
        int angle = 0;

        if(hr < 0 || min < 0 || hr > 12.00 || min > 60.00){
            System.out.printf("Invalid %f hr and %f minute\n", hr, min);
            return INT;
        }
        if(hr == 12.00){
            hr = 0;
        }
        if(min == 60){
            min = 0;
        }

        int hr_angle = (int)(0.5 * (hr*60 + min));
        int min_angle = (int)(6*min);

        angle = Math.abs(hr_angle - min_angle);

        angle = Math.min(360-angle, angle);

        return angle;
    } // anglebetweenHrnSecHands

    //17. Create data structure with pop(), push(), top(), min() in O(1)
    //18. Largest contiguous substring with no repeating elements. 
    public static int maxContSubstr(String str){
        int max_len = 1;
        int curr_len = 1;
        int len = str.length();
        int len2 = len;
		int[] visited = new int[256];
        int prev_index; 

        for(int i = 0; i < len2; i++){
            visited[i] = INT;
        }

        visited[str.charAt(0)] = 0;

        for(int i = 1; i < len2; i++){
            prev_index = visited[str.charAt(i)];

            // curr char doesnt exsist in sequence so far
            if(prev_index == INT || i - curr_len > prev_index ){
                curr_len++;
            }
            else{
                if(curr_len > max_len){
                    max_len = curr_len;
                }
                curr_len = i - prev_index;
            }

            //update the index of curr index
            visited[str.charAt(i)]  = i;

            System.out.printf("str.charAt(%d)  visited[%c]\n", i, str.charAt(i));
        }

        if(curr_len > max_len){
            max_len = curr_len;
        }

        return max_len;
    } // maxCountSubStr

    //19. Given an string and a burst length, output the string that count of the same adjacent characters 
    //     in string are less than burst length. 
    //20. Given an array of distinct integers, output the number of sub-sequences of length 3, 
    //    either in increasing or decreasing order.
    public static void subSeq3(int[] distInts){
        HashSet<Integer> s = new HashSet<>();
        int ans = 0;

        for(int i = 0; i < distInts.length; i++){
            s.add(distInts[i]);
        }

        for(int i = 0; i < distInts.length; i++){
            if(!s.contains(distInts[i] - 1)){
                int j = distInts[i];
                while(s.contains(j) && ans != 3){
                    j++;
                }
                if(ans < j - distInts[i]){
                    ans = j - distInts[i];
                }
            }
            System.out.println(s);
        }
    } // subSeq3

    //21. Given an array of integers and a sum, output the number of pairs whose addition is equal to the given sum. 
    public static int countPairs(int[] nums, int sum){
        int count = 0;
        HashSet<Integer> s = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            int temp = sum - nums[i];

            if(temp >=0 && s.contains(temp)){
                count++;
                System.out.printf("\nPair with %d is (%d, %d)\n", sum, nums[i], temp);
            }
            s.add(nums[i]);
        }
        return count;
    } // countPairs

    //22. Given a sequence of M and N with M representing increasing and N representing decreasing, 
    //    output the smallest number that follows this patten. 
    //23. Given a string, the task is to find maximum consecutive repeating character in string
    public static void consRepeatChar(String str){
        
        int countCh = 0;
        int currCount = 0;
        char maxRep = str.charAt(0);

        for(int i = 0; i < str.length() - 1; i++){
            if(str.charAt(i) == str.charAt(i+1)){
                currCount++;

            }
            else{
                if(currCount > countCh){
                    countCh = currCount;
                    maxRep = str.charAt(i);
                }
                currCount=1;
            }
        }
        System.out.println("Maximum repeating char in " + str + " is " + maxRep);


    } // consRepeatChar

    //24. Print the reverse order of the string.
    //25. Given permutations with only adjacent swaps allowed. 
    public static void findPermutation(String str, int index, int strLen){
       if(index == strLen){
           System.out.println(str);
       }
       else{
           for(int i = index; i <= strLen; i++){
                str = swap(str, index, i);
                findPermutation(str, index+1, strLen);
                str = swap(str, index, i);
            }
       }
    
    } // findPermutations

    public static String swap(String str, int n1, int n2){
        char temp;
        char[] chArr = str.toCharArray();
        temp = chArr[n1];
        chArr[n1] = chArr[n2];
        chArr[n2] = temp;
        return String.valueOf(chArr); 
        
    }
    //26. Given an array of non-negative numbers & a target value, 
    //    return the length of smallest subarray whose sum is greater than the target value. 
    public static int smallLen(int[] arr, int k){
        int start = 0;
        int end = 0; 
        int n = arr.length;
        int curr_sum = 0; 
        int min_len = n + 1;

        while(end < n){
            while(curr_sum <= k && end < n){
                curr_sum += arr[end++];
                System.out.println(curr_sum);
            }
            
            while(curr_sum > k && start < n){
                if(end-start < min_len){
                    min_len = end-start;
                }
                curr_sum -= arr[start++];
            }
        }
       
        
       
        return min_len;
    } // smallLen

    //27. Find the largest number from the array of number.
    //28. Given an array, find the number of contiguous subarrays such that the product of the elements of the 
    //    subarray is less than or equal to a given positive integer k. 
    public static int countSubProd(int[] prodArr, int prod){
        int start = 0;
        int end = 0; 
        int n = prodArr.length;
        int res = 0;
        long p = 0;

        for(start = 0, end = 0; end < n; end++ ){
            p *= prodArr[end];

            while(start<end && p >= prod){
                p /= prodArr[start++];
            }

            if (p < prod){
                int len = end - start + 1;
                res += len;
            }
        }
        return res;
    } // countSubProd
 
    // 30. Given two words, find if second word is the round rotation of first word.
    static boolean isRoundRotation(String str1, String str2){
        String temp = str1 + str1;
        boolean rr = false;
        int i = -1;
        
		if((str1.length() == str2.length()) && (temp.indexOf(str2) != i)){
            rr = true;
        }
        return rr;

    } // isRoundRotation
    
    // 31. Code for converting floating point decimal number to binary numbers.
    public static String floatToBinary(double num){
        String binary = "";

        int integral = (int)num;
        double dec = num - integral;

        while(integral > 0){
            int rem = integral % 2;
            System.out.println(integral + " " + rem);
            binary = rem + binary;
            System.out.println(binary);
            integral = integral/2; 
        }

        binary = binary + ".";

        String decNum = Double.toString(num);
        int len = decNum.length()-1;

        while(len > 0 ){
            dec = dec * 2.00;
            int fract = (int)dec;
            System.out.println(dec + " " + fract);

            if(fract == 1){
                dec = dec - fract;
                binary = binary + "1";
            }
            else{
                binary = binary + "0";
            }
            len--;
        }


        return binary;
    } // floatToBinary

    // 32. Grey Code

    // 33. Given a string of digits,find the next smallest number using the same digits.If its not possible to get such a number print -1;
  
    // 34. Given a string, find the first element which is non -repetitive i.e that element must not be present anywhere else in the string.

    // 35. Given an array of 1s followed by 0s,find the number of 0s
    public static int firstZero(int []arr, int low, int high){
        //Binary search
        
        if(high >= low){
            int mid = low + (high - low)/2;
            if(((mid == 0) || (arr[mid-1] == 1)) && (arr[mid] == 0)){
                return mid;
            }
            if(arr[mid] == 1){
                return firstZero(arr, mid + 1, high);
            }
            else{
                return firstZero(arr, low, mid - 1);
            }
        }

        return -1;
    } // firstZero

    public static int countZeros(int []arr, int n){
        int first = firstZero(arr, 0, n-1);

        if(first == -1){
            return 0;
        }
        return (n - first);
    } // countZero

    // 36.  Given an array of positive and negative numbers, find the pair of elements whose sum is closest to 0.

    // 37. Given a Binary Tree , print all the root to leaf paths.
    
    // 38. Given a binary tree convert it to a double linked list.

    // 39. A singly liked list. Can have a loop. Detect it and find the size of list.

    // 40.  A singly link list and a number ‘K’, swap the Kth node from the start with the Kth node from the last. Check all the edge cases.

    

} // codingPractice2