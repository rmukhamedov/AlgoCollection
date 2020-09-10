class Solution {
public:
    int rowCount;
    int colCount;
    
    void dfs(vector<vector<char>>& grid, int row, int col)  {
        if (row < 0 || col < 0 || row >= rowCount || col >= colCount || grid[row][col] == '0'){
            return;
        }
        
        grid[row][col] = '0';
        dfs(grid, row - 1, col);
        dfs(grid, row + 1, col);
        dfs(grid, row, col - 1);
        dfs(grid, row, col + 1);
    }
    
    int numIslands(vector<vector<char>>& grid) {
        rowCount = grid.size();
        if (rowCount == 0){
            return 0;
        }
        
        int islandCount = 0;
        colCount = grid[0].size();
        
        for (int row = 0; row < rowCount; ++row)
        {
            for (int col = 0; col < colCount; ++col)
            {
                if (grid[row][col] == '1'){
                    ++islandCount;
                    dfs(grid, row, col);
                }
            }
        }
        
        return islandCount;
    }
};
