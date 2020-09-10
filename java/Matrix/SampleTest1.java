// SampleTest1 - sample program to test BMat class

public class SampleTest1
{
  public static void main(String[] args)
  {
    int[][] C = new int[][]
                {{0, 0, 0},
                 {1, 1, 0},
                 {1, 1, 0}};

    int[][] D = new int[][]
                {{1, 1, 0},
                 {0, 1, 0},
                 {0, 1, 1}};

    // Instance and display initial objects
    BMat MC = new BMat(C);
    BMat MD = new BMat(D);
    System.out.println("\n Matrix C");
    MC.show();
    System.out.println("\n Matrix D");
    MD.show();

    // Declare work objects
    BMat W1, W2, W3;

    // Indegree of node 1 of D
    // Node numbers are 0, 1, 2
    int indegreeD1 = MD.indegree(1);
    System.out.println("\n Indegree of node 1 of D = " + indegreeD1);

    // Complement of C
    W1 = MC.complement();
    System.out.println("\n Complement of C");
    W1.show();

    // Join (OR) of C and D
    W2 = MC.join(MD);
    System.out.println("\n Join of C and D");
    W2.show();

    // Reflexive Closure of C
    W3 = MC.rclosure();
    System.out.println("\n Reflexive Closure of C");
    W3.show();
  }

} // end class
