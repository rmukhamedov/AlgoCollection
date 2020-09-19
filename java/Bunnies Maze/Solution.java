// "static void main" must be defined in a public class.
import java.util.LinkedList; 

public class Main {
    public static class Node {
        public int x;
        public int y;
        
        public Node(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }
    
    public static int getGridSearch(int[][] grid)
    {
        int[][] gridSearch = new int[grid.length][];
        for (int x = 0; x < grid.length; ++x)
        {
            gridSearch[x] = new int[grid[x].length];
        }
        int xBound = grid.length - 1;
        
        LinkedList<Node> list = new LinkedList<Node>();
        
        gridSearch[0][0] = 1;
        list.add(new Node(0,0));
        
        while (list.size() > 0)
        {
            Node node = list.pollLast();
            
            int x = node.x;
            int y = node.y;
            int yBound = grid[x].length - 1;
            
            if (x < xBound && y < grid[x + 1].length)
            {
                int south = x + 1;
                if (grid[south][y] == 1)
                {
                    gridSearch[south][y] = -1;
                }
                else if (isLessMoves(gridSearch[x][y], gridSearch[south][y]))
                {
                    gridSearch[south][y] = gridSearch[x][y] + 1;
                    
                    list.add(new Node(south, y));
                }
            }
            
            if (y < yBound)
            {
                int east = y + 1;
                if (grid[x][east] == 1)
                {
                    gridSearch[x][east] = -1;
                }
                else if (isLessMoves(gridSearch[x][y], gridSearch[x][east]))
                {
                    gridSearch[x][east] = gridSearch[x][y] + 1;
                    
                    list.add(new Node(x, east));
                }
            }
            
            if (x > 0 && y < grid[x - 1].length)
            {
                int north = x - 1;
                if (grid[north][y] == 1)
                {
                    gridSearch[north][y] = -1;
                }
                else if (isLessMoves(gridSearch[x][y], gridSearch[north][y]))
                {
                    gridSearch[north][y] = gridSearch[x][y] + 1;
                    
                    list.addFirst(new Node(north, y));
                }
            }
            
            if (y > 0)
            {
                int west = y - 1;
                if (grid[x][west] == 1)
                {
                    gridSearch[x][west] = -1;
                }
                else if (isLessMoves(gridSearch[x][y], gridSearch[x][west]))
                {
                    gridSearch[x][west] = gridSearch[x][y] + 1;
                    
                    list.addFirst(new Node(x, west));
                }
            }
        }
        
        return gridSearch[xBound][gridSearch[xBound].length - 1];
    }
    
    public static boolean isLessMoves(int start, int destination)
    {
        return (destination == 0 || start < destination);
    }
    
    public static int numberOfFreeNeighborsOrGoal(int[][] grid, int x, int y)
    {
        if (x == grid.length - 1 && y == grid[x].length - 1)
        {
            return 2;
        }
        
        int result = 0;
        
        if (x > 0 && y < grid[x - 1].length && grid[x - 1][y] != 1)
        {
            ++result;
        }
        if (y > 0 && grid[x][y - 1] != 1)
        {
            ++result;
        }
        if (x < grid.length - 1 && y < grid[x + 1].length && grid[x + 1][y] != 1)
        {
            ++result;
        }
        if (y < grid[x].length - 1 && grid[x][y + 1] != 1)
        {
            ++result;
        }
        
        return result;
    }
    
    public static int solution(int[][] map)
    {
        int minmove = map[map.length-1].length + map.length - 1;
        int result = getGridSearch(map);
        for (int x = 0; x < map.length; ++x)
        {
            for (int y = 0; y < map[x].length; ++y)
            {
                if (map[x][y] == 1 && numberOfFreeNeighborsOrGoal(map, x, y) > 1)
                {
                    map[x][y] = 0;
                    int numMoves = getGridSearch(map);
                    if (numMoves < result || result <= 0)
                    {
                        result = numMoves > 0 ? numMoves : result;
                        if (result == minmove)
                        {
                            return result;
                        }
                    }
                    map[x][y] = 1;
                }
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[][] array = {{0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0},{1,1,1,1,1,1,1,1,1,1,1},{0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0}};
        printArray(array);
        System.out.println(solution(array));
    }
    
    public static void printArray(int[][] array)
    {
        for (int x = 0; x < array.length; ++x){
            System.out.print("|");
            for (int y = 0; y < array[x].length; ++y){
                System.out.print(" " + array[x][y] + " ");
            }
            System.out.println("|");
        }
    }
}  