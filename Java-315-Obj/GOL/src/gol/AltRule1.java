/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gol;

/**
 *
 * @author dtmirizzi
 */
public class AltRule1 implements RuleSetInterface {
    private boolean[][] grid;
    private boolean wrap=false;
    
    public AltRule1(){
	
    }
    
    private int countCells(int i, int j) {
        int count = 0;
         
        int iminus = i - 1;
        int jminus = j - 1;
        int iplus = i + 1;
        int jplus = j + 1;
         
        if (iminus >= 0) {
            if (jminus >= 0) {
                if (grid[iminus][jminus])   count++;
            }
             
            if (grid[iminus][j])            count++;
             
            if (jplus < GridBase.GRID_WIDTH) {
                if (grid[iminus][jplus])    count++;
            }
        }
         
        if (jminus >= 0) {
            if (grid[i][jminus])            count++;
        }
         
        if (jplus < GridBase.GRID_WIDTH) {
            if (grid[i][jplus])             count++;
        }
         
        if (iplus < GridBase.GRID_WIDTH) {
            if (jminus >= 0) {
                if (grid[iplus][jminus])    count++;
            }
             
            if (grid[iplus][j])             count++;
             
            if (jplus < GridBase.GRID_WIDTH) {
                if (grid[iplus][jplus])     count++;
            }
        }
         
        return count;
    }
    
    public boolean[][] getGrid(){
	return grid;
    }

    @Override
    public void ApplyRule(boolean[][] a) {
	this.grid=a;
	for (int i = 0; i < GridBase.GRID_WIDTH; i++) {
            for (int j = 0; j < GridBase.GRID_WIDTH; j++) {
                int count = countCells(i, j);
                if (count == 1||count==2) grid[i][j] = true;
                if (grid[i][j] && count < 1) grid[i][j] = false;
                if (grid[i][j] && count > 3) grid[i][j] = false;
            }
        }
    }

    @Override
    public void setWrap(boolean bl) {
	wrap= bl;
    }
}