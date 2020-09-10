// Finite State Machine Class
public class FSM
{
  // Instance variables
  public  String alphabet;
  public  int    stateTrans[][];
  public  int    acceptState[];
  private int    cstate;

  // Constructor function

  public FSM(String A, int[][] ST, int[] AS)
  {
    int NSYMBOLS = A.length();
    int NSTATES  = AS.length;
    // Alphabet
    alphabet = "" + A;
    // State transition table
    stateTrans = new int[NSTATES][NSYMBOLS];
    for(int r = 0; r < NSTATES; r++)
      for(int c = 0; c < NSYMBOLS; c++)
        stateTrans[r][c] = ST[r][c];
    // Accept states
    acceptState = new int[NSTATES];
    for(int r = 0; r < NSTATES; r++)
      acceptState[r] = AS[r];
    // Start state
    cstate = 0;
  } 

  // Methods

  public int getState()
  {
    return cstate;
  }

  public void setState(int state)
  {
    cstate = state;
    return;
  }

  public int nextState(char symbol)
  {
    int nstate = -1;
    int col = alphabet.indexOf(symbol);
    if(col >= 0)
      nstate = stateTrans[cstate][col];
    return nstate;
  }

  public boolean accept(int state)
  {
    if(state < 0)
      return false;
    return (acceptState[state] != 0);
  }

  public boolean validString(String word)
  {
    cstate = 0;
    for(int k = 0; k < word.length(); k++){
      cstate = nextState(word.charAt(k));
      if(cstate < 0)
        return false;
    }
    return accept(cstate);
  }

} // end class
