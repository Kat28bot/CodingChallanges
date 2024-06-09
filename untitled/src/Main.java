import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
        public  ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int headVal = l1.val+l2.val;
            ListNode head = new ListNode(headVal%10);
            ListNode next1 = l1.next;ListNode next2 =l2.next;

            ListNode next = head;

            boolean plusOne=headVal>=10;
            while(next1!=null || next2!=null){
                if(next1==null){next1=new ListNode(0);}
                if(next2==null){next2=new ListNode(0);}
                int nextVal = next1.val +next2.val;

                if(plusOne){
                    next.next = new ListNode(nextVal%10+1);
                    plusOne=false;
                }else{
                    next.next = new ListNode(nextVal%10);
                    //plusOne=false;
                }
                if(nextVal>=10){
                    plusOne=true;
                }

                next=next.next;
                next1=next1.next;next2=next2.next;
            }
            return head;
        }
    public static boolean isValid(String s) {
        String openings= "({[";
        String closings= ")}]";
        StringBuilder toBeClosed= new StringBuilder();
        for(int i=0;i<s.length();i++){

            if(openings.contains(Character.toString(s.charAt(i)))){
                toBeClosed.append(s.charAt(i));
            }
            else{
                if(toBeClosed.isEmpty()){return false;}
                char charToBeClosed=toBeClosed.charAt(toBeClosed.length()-1);
                char currClose = closings.charAt(openings.indexOf(charToBeClosed));
                if(s.charAt(i)!=currClose){
                    return false;
                }
                else{
                    toBeClosed.deleteCharAt(toBeClosed.length()-1);
                }
            }

        }
        return toBeClosed.isEmpty();
    }
    public static int myAtoi(String s) {
        s=s.trim();
        int positive=1;
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        if(sb.isEmpty()){
            return 0;
        }
        char firstChar=sb.charAt(0);
        if(firstChar=='-'||firstChar=='+') {
            sb.deleteCharAt(0);
            if(firstChar=='-'){
                positive=-1;
            }
        }
        StringBuilder res = new StringBuilder();
        while(!sb.isEmpty()&&Character.isDigit(sb.charAt(0))){
            res.append(sb.charAt(0));
            sb.deleteCharAt(0);
        }

        if(res.isEmpty()||res.length()>10){
            return 0;
        }
        long result=Long.parseLong(res.toString());
        if(result>=Integer.MAX_VALUE){
            return 0;
        }
        return positive*Integer.parseInt(res.toString());
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null){
            return list2;
        } else if(list2==null){
            return list1;
        }
        ListNode head;
        ListNode next1=list1,next2=list2;
        if(list1.val<=list2.val){
             head =new ListNode(list1.val);
            next1=list1.next;
        }else{
            head=new ListNode(list2.val);
            next2=list2.next;
        }

        ListNode next=head;
        while(next1!=null||next2!=null){

            int n1=next1==null?Integer.MAX_VALUE:next1.val,
                    n2=next2==null?Integer.MAX_VALUE:next2.val;

            if(n1<=n2){
                next.next=new ListNode(n1);
                next1=next1.next;
            }else{
                next.next=new ListNode(n2);
                next2=next2.next;
            }
            next=next.next;
        }
        return head;
    }
    public static int[] removeDuplicates(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for (int value : nums) {
            set.add(value);
        }
        ArrayList<Integer> integerList = new ArrayList<>();
        while(!set.isEmpty()) {
            int min = set.stream().min(Integer::compareTo).orElse(0);
            integerList.add(min);
            set.remove(min);
        }
        int[] intArray = new int[integerList.size()];
        for (int i = 0; i < integerList.size(); i++) {
            intArray[i] = integerList.get(i);
        }
        return intArray;
    }
    public static int strStr(String haystack, String needle) {


        return haystack.indexOf(needle);
    }
    public static int searchInsert(int[] nums, int target) {
            if(target<nums[0]){return 0;}
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]<=target&&target<=nums[i+1]){
                if(nums[i]==target){return i;}
                return i+1;
            }
        }
        return nums.length;

    }
    public static int lengthOfLastWord(String s) {
        String[] words= s.split(" ");
        String word=words[words.length-1];
        return word.length();
    }
    public static int[] plusOne(int[] digits) {
        digits[digits.length-1]=digits[digits.length-1]+1;
        int curr=digits.length-1;
        while(digits[curr]>=10&&curr>0){

            digits[curr]=9;
            digits[curr-1]=digits[curr-1]+1;
            curr--;
        }
        if(digits[0]>=10){
            int[] newDigits=new int[digits.length + 1];
            newDigits[0]=1;newDigits[1]=digits[0]%10;
            System.arraycopy(digits, 1, newDigits, 2, digits.length - 1);
            digits=newDigits;
        }
        return digits;
    }
    public static int climbStairs(int n) {
        int ones=n-2;
        int twos=1;
        int res=1;
        while(ones>=1&&((2*twos+ones)==n)){
            int ways = binomialCoefficient(ones + twos, ones);

            res=res+ways;
            twos=twos+1;
            ones=ones-2;
        }

        if(n%2==0){res=res+1;}
        return (res);
    }
    static int binomialCoefficient(int n, int k) {
        if (k == 0 || k == n) {
            return 1;
        }
        return binomialCoefficient(n - 1, k - 1) + binomialCoefficient(n - 1, k);
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                for(int k=j+1;k<nums.length;k++){
                    List<Integer> row =new ArrayList<>();
                    if(nums[i]+nums[j]+nums[k]==0){
                        row.add(nums[i]);row.add(nums[j]);row.add(nums[k]);
                        Collections.sort(row);
                        result.add(row);
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }
    public static int threeSumClosest(int[] nums, int target) {
        int result=0;
        int diff=Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            int j=i+1;
            int  k = nums.length-1;
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if(Math.abs(target-sum)<=diff){
                    diff=Math.abs(target-(nums[i]+nums[j++]+nums[k--]));
                    result=nums[i]+nums[j++]+nums[k--];
                }
                else if (sum >0) {k--;}
                else if (sum<0) {j++;}
            }
        }
        return result;
    }
    public static List<String> letterCombinations(String digits) {
        if(digits.isEmpty()){return new ArrayList<>();}
        Map<Character,String> keyboard = new HashMap<>();
        keyboard.put('2',"abc"); keyboard.put('3',"def");keyboard.put('4',"ghi");keyboard.put('5',"jkl");keyboard.put('6',"mno");keyboard.put('7',"pqrs");keyboard.put('8',"tuv");keyboard.put('9',"wxyz");
       List<String> result= new ArrayList<>();
        for(int i=0;i<digits.length()-1;i++){
            StringBuilder word= new StringBuilder();
            String letters =keyboard.get(digits.charAt(i));
                for(int j=0;j<letters.length();j++){
                    for(int k=i;k<digits.length();k++){
                        word.append(keyboard.get((char)k).charAt(j));
                    }
                }
                result.add(word.toString());
        }
        return result;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode next = head.next;
        int i=0;
        while(next!=null){
            if(n>=i){next.val=next.next.val;}
            i++;
            //System.out.print(next.val);
            next=next.next;
        }
        String s; StringBuilder sb;
        return head;
    }
    public static int removeDuplicates2(int[] nums) {
      //  return Arrays.stream(nums).distinct().toArray().length;
       List<Integer> unums=new ArrayList<>();
        for(int el:nums){
            if(!unums.contains(el)) {
                unums.add(el);
            }
        }
        Collections.sort(unums);
        nums=new int[unums.size()];
        int i=0;
        for(int u:unums){
            nums[i]=u;
            i++;
        }
        return nums.length;
    }
    public static int[] solution(int[] nums, int sum){
        int[] solution= new int[2];
        ArrayList<Integer> numsList = new ArrayList<>();
        for(int n:nums){
            numsList.add(n);
        }
        for(int i=0;i<numsList.size();i++){
            List<Integer> sublist = numsList.subList(i, numsList.size());
            int secIndex=sublist.indexOf(sum-(numsList.get(i)));
            if(-1<secIndex){
                solution[0]=numsList.get(i);
                solution[1]=sublist.get(secIndex);
                return solution;
            }

        }
        return solution;
    }
    public static int[] solution2(int[] nums, int sum){
        ArrayList<Integer> numsList = new ArrayList<>();
        for(int n:nums){
            int additive=sum-(n);
            if(numsList.contains(additive)){
                return new int[] {n,additive};
            }
            numsList.add(n);
        }
        return new int[] {};
    }
    public static int[] solution3(int[] nums, int sum){
        HashMap<Integer,Integer> numsList = new HashMap();
        for(int n:nums){
            int additive=sum-(n);
            if(numsList.containsKey(additive)){
                return new int[] {n,additive};
            }
            numsList.put(n,n);
        }
        return new int[] {};
    }
    public static boolean isPalindrome(String s){
        String sub1;
        String sub2 = s.substring(s.length()/2,s.length());
        if(s.length()%2 == 0){
            sub1 = s.substring(0, (s.length() / 2) );
        }else{
            sub1 = s.substring(0, (s.length() / 2) +1);
        }
        sub2=new StringBuilder(sub2).reverse().toString();
        return sub1.equals(sub2);
    }
    public static String longestPalindrome(String s) {
            if(s.length()<=1){return s;}
            if(isPalindrome(s)){return s;}
            String longest=""+s.charAt(0);
            for(int i=0;i<s.length();i++){
               StringBuilder sb=new StringBuilder();
               sb.append(s.charAt(i));
                for(int j=i+1;j<s.length();j++){
                    sb.append(s.charAt(j));
                    if(isPalindrome(sb.toString())&&longest.length()<sb.toString().length()){
                       longest=sb.toString();
                    }
                }
            }
            return longest;
    }
    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbbd"));

//            int[] nums = {-1,2,1,-4};
//            System.out.println(letterCombinations("2345"));
//          //  System.out.println(Integer.MAX_VALUE);
//        ListNode l13 = new ListNtNode(2,l13);ode(4);
////        ListNode l12= new Lis
//        ListNode l1= new ListNode(1,l12);
//        int[] xd={1,2,3,2,2,9};
//        int[] xd2={4,2,1,4};
//        int[] sol=solution3(xd2,8);
//  for(int s:sol){
//      System.out.println(s);
//  }
//removeDuplicates2(xd);
//
//        ListNode l23 = new ListNode(4);
//        ListNode l22 = new ListNode(3,l23);
//        ListNode l2 = new ListNode(1,l22);
//        Main m = new Main();
//        ListNode next = m.mergeTwoLists(l1,l2);
//        while(next!=null){
//            System.out.print(next.val);
//            next=next.next;
//        }
//        String s= "91283472332";
      //  System.out.println( "Hello World");
//        int[] nums = {1,1,2};
//        int[] res=removeDuplicates(nums);
//        for(int x:res){
//            System.out.println(x);
//        }
//       int[] nums = {9,9,9,9};
//       int[] res=plusOne(nums);
//       for(int r:res) {
//           System.out.println(r);
//       }
    }
}