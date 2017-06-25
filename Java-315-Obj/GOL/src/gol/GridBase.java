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
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class GridBase {

    protected static final int GRID_WIDTH = 100;
    protected static final int CELL_WIDTH = 5;
    protected static RuleSetInterface RuleSet = new DefaultRule();

    private boolean[][] grid;

    private volatile long generationCount;
    private volatile long generationDelay;

    public GridBase() {
        this.grid = new boolean[GRID_WIDTH][GRID_WIDTH];
        this.generationDelay = 1000L;
        clearGrid();
    }

    public void setRule(int a) {
        if (a == 1) {
            RuleSet = new DefaultRule();
        }
        if (a == 2) {
            RuleSet = new AltRule1();
        }
	if (a == 3) {
            RuleSet = new DefaultRule();
	    RuleSet.setWrap(true);
        }
        if (a == 4) {
            RuleSet = new AltRule1();
	    RuleSet.setWrap(true);
        }
    }

    public void clearGrid() {
        this.generationCount = 0;
        for (int i = 0; i < GRID_WIDTH; i++) {
            for (int j = 0; j < GRID_WIDTH; j++) {
                resetCell(i, j);
            }
        }
    }

    public void drawCell(int x, int y) {
        int k = 1;
        for (int i = 0; i < GRID_WIDTH; i++) {
            int l = 1;
            for (int j = 0; j < GRID_WIDTH; j++) {
                if (x < k + 4 && x > k - 4 && y < l + 4 && y > l - 4) {
                    if (grid[i][j] == false) {
                        grid[i][j] = true;
                    }else{
                        grid[i][j] = false;
		    }
                
                }
                l += CELL_WIDTH + 1;
            }
            k += CELL_WIDTH + 1;
        }
    }

    public void setCell(int i, int j) {
        grid[i][j] = true;
    }

    public void resetCell(int i, int j) {
        grid[i][j] = false;
    }

    public synchronized void cycleGrid() {
        this.generationCount++;
        RuleSet.ApplyRule(grid);
        grid = RuleSet.getGrid();
    }

    public Dimension getPreferredSize() {
        int x = (GRID_WIDTH * (CELL_WIDTH + 1)) + 1;
        return new Dimension(x, x);
    }

    public int getGridWidth() {
        return GRID_WIDTH;
    }

    public long getGenerationCount() {
        return generationCount;
    }

    public long getGenerationDelay() {
        return generationDelay;
    }

    public synchronized void setGenerationDelay(long generationDelay) {
        this.generationDelay = generationDelay;
    }

    public void draw(Graphics g) {
        int x = 1;
        for (int i = 0; i < GRID_WIDTH; i++) {
            int y = 1;
            for (int j = 0; j < GRID_WIDTH; j++) {
                drawGridLines(g, x, i, y, j);
                drawCell(g, x, i, y, j);
                y += CELL_WIDTH + 1;
            }
            x += CELL_WIDTH + 1;
        }
    }

    private void drawGridLines(Graphics g,
            int x, int i, int y, int j) {
        g.setColor(Color.DARK_GRAY);
        if (i == 0) {
            g.drawLine(0, y - 1, 0, y + CELL_WIDTH - 1);
        }
        if (j == 0) {
            g.drawLine(x - 1, 0, x + CELL_WIDTH - 1, 0);
        }
        g.drawLine(x, y + CELL_WIDTH,
                x + CELL_WIDTH, y + CELL_WIDTH);
        g.drawLine(x + CELL_WIDTH, y,
                x + CELL_WIDTH, y + CELL_WIDTH);
    }

    private void drawCell(Graphics g,
            int x, int i, int y, int j) {
        if (grid[i][j]) {
            g.setColor(Color.BLACK);
            g.fillRect(x, y, CELL_WIDTH, CELL_WIDTH);
        }
    }

}
