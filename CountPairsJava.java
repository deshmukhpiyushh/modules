Class CountPairsJava{


public static void main(){
//call functions as and when needed 
} 
public static int countPairs(int[] arr, int sum)
    {
 
        int count = 0;

        for (int i = 0; i < arr.length; i++)
            for (int j = i + 1; j < arr.length; j++)
                if ((arr[i] + arr[j]) == sum)
                    count++;
 
        return count;
    }
    
    
    static int countPairs(int sum, int arr[] )
    {
    	int n;
    	n= arr.length;
        HashMap<Integer, Integer> freqCount = new HashMap<>();
   
        for (int i=0; i<n; i++){
             if(!freqCount.containsKey(arr[i]))
                freqCount.put(arr[i],0);
                 
            freqCount.put(arr[i], freqCount.get(arr[i])+1);
        }
        int sumCounter = 0;
   
        for (int i=0; i<n; i++)
        {
            sumCounter = sumCounter +  freqCount.get(sum-arr[i]);
               if (sum-arr[i] == arr[i])
                sumCounter--;
        }
   
        sumCounter = sumCounter/2;
        return sumCounter;
    }


}
