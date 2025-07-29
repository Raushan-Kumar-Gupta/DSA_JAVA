package Backtracking;
import java.util.*;
class Solution {
    // Function to find all possible paths
    public ArrayList<String> ratInMaze(int[][] maze) {
        // code here
        int n = maze.length; 
        ArrayList<String> list = new ArrayList<>();
        String ans = "";
        searchInMaze(maze, 0, 0, n-1, ans, list);
        return list;
    }
    public void searchInMaze(int[][] maze, int currRow, int currCol, int dest, String ans, ArrayList<String> list){
        if(!isValid(maze, currRow, currCol)) return ;
        if(currRow==dest && currCol==dest){
            list.add(ans);
            return;
        } 
        if(maze[currRow][currCol]==0 || maze[currRow][currCol]==-1) return;
        int temp = maze[currRow][currCol];
        maze[currRow][currCol]=-1;
        searchInMaze(maze, currRow+1, currCol, dest, ans+"D", list);
        searchInMaze(maze, currRow, currCol-1, dest, ans+"L",list);
        searchInMaze(maze, currRow, currCol+1, dest, ans+"R", list);
        searchInMaze(maze, currRow-1, currCol, dest, ans+"U", list);
        maze[currRow][currCol]=temp;
    }
    public boolean isValid(int[][] maze, int row, int col){
        if(row<0 || row>=maze.length || col<0 || col>=maze[0].length) return false;
        return true;
    }
}