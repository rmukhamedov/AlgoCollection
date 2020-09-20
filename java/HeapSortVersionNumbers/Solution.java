public class Solution {
    static void sort(String arr[]) 
    { 
        int n = arr.length; 
  
        for (int i = n / 2 - 1; i >= 0; i--)
        {
            heapify(arr, n, i); 
        }
  
        for (int i=n-1; i>0; i--) 
        { 
            String temp = arr[0]; 
            arr[0] = arr[i]; 
            arr[i] = temp; 

            heapify(arr, i, 0); 
        } 
    }
    
    //return -1 if a < b || 0 if a == b || 1 a > b
    static int compareVersions(String a, String b)
    {
        if (a == null)
        {
            return b == null ? 0 : -1;
        }
        
        if (b == null)
        {
            return 1;
        }
        
        String[] aSplit = a.split("\\.");
        String[] bSplit = b.split("\\.");
        
        int aMajor = Integer.parseInt(aSplit[0]);
        int bMajor = Integer.parseInt(bSplit[0]);
        
        if (aMajor == bMajor)
        {
            if (aSplit.length < 2)
            {
                return -1;
            }
            else if (bSplit.length < 2)
            {
                return 1;
            }
            
            int aMinor = Integer.parseInt(aSplit[1]);
            int bMinor = Integer.parseInt(bSplit[1]);
            
            if (aMinor == bMinor)
            {
                if (aSplit.length < 3)
                {
                    return -1;
                }
                else if (bSplit.length < 3)
                {
                    return 1;
                }
                
                int aRev = Integer.parseInt(aSplit[2]);
                int bRev = Integer.parseInt(bSplit[2]);
                
                if (aRev == bRev)
                {
                    return 0;
                }
                else
                {
                    return aRev > bRev ? 1 : -1;
                }
            }
            else
            {
                return aMinor > bMinor ? 1 : -1;
            }
        }
        else
        {
            return aMajor > bMajor ? 1 : -1;
        }
    }
  
    static void heapify(String arr[], int n, int i) 
    { 
        int largest = i;
        int l = 2*i + 1; 
        int r = 2*i + 2; 
        
        if (l < n && compareVersions(arr[l], arr[largest]) == 1)
        {
            largest = l; 
        }
        
        if (r < n && compareVersions(arr[r], arr[largest]) == 1)
        {
            largest = r; 
        }
        
        if (largest != i) 
        { 
            String swap = arr[i]; 
            arr[i] = arr[largest]; 
            arr[largest] = swap; 
            
            heapify(arr, n, largest); 
        } 
    }
    
    static void printArray(String arr[]) 
    { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i]+" "); 
        System.out.println(); 
    } 
    
    public static String[] solution(String[] l)
    {
        return new String[4];
    }
  
    public static void main(String args[]) 
    { 
        String arr[] = {"1.11", "2.0.0", "1.2", "2", "0.1", "1.2.1", "1.1.1", "2.0"}; 
        int n = arr.length; 
 
        sort(arr); 
  
        System.out.println("Sorted array is"); 
        printArray(arr); 
    } 
}







