// "static void main" must be defined in a public class.
import java.util.HashSet;

public class Solution {
    public static int solution(int[] x, int[] y) {
        int[] target = x.length > y.length ? x : y;
        int[] comp = x.length > y.length ? y : x;
        HashSet<Integer> vals = new HashSet<Integer>();
        
        for (int i = 0; i < comp.length; ++i)
        {
            vals.add(comp[i]);
        }
        
        for (int i = 0; i < target.length; ++i)
        {
            if (!vals.contains(target[i]))
            {
                return target[i];
            }
        }
        
        return 0;
    }
    
    public static void main(String[] args)
    {
        int[] x = {};
        int[] y = {};
        
        int u = solution(y, x);
        
        System.out.println(u);
    }
}