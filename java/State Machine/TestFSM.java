// Test Finite State Machine Class
public class TestFSM
{
  public static void main(String[] args)
  {
    // Language: strings that contain both a and b,
    // and the first a is before the first b.
    String A   = "abc";
    int[][] ST = {{1,3,0},
                  {1,2,1},
                  {2,2,2},
                  {3,3,3}};
    int[] AS   = {0,0,1,0};

    String inString;
    boolean accept1 = false;
    FSM FSM1 = new FSM(A, ST, AS);
    if(args.length >= 1)
    {
      // Input string is command line parameter
      inString = args[0];
      accept1 = FSM1.validString(inString);
      System.out.println("\n String:  " + inString 
        + "    Accept?  " + accept1);
    }
  } // end main

} // end class
