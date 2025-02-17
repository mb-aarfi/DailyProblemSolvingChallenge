class Solution {
    public String frequencySort(String s) {
        int freq[]=new int[123];
        char ch; 
        int asci; 

        for(int i=0;i<s.length();i++){
            ch=s.charAt(i);
            asci=(int)ch;
            freq[asci]=freq[asci]+1;
        }

        StringBuilder ans=new StringBuilder();
        int max;
        int count;
        for(int i=0;i<s.length();){
         max=Maximum(freq); 
         count=freq[max]; 
         freq[max]=-1; 

         while(count!=0){ 
         ans.append((char)max);
         i++;
         count--;
         }
        }
        return ans.toString();
    }
    public static int Maximum(int []arr){
        int maxi=-1;
        int index=-1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>=maxi){
                maxi=arr[i];
                index=i;
            }
        }

    return index;
    }
}
