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
public class DefaultRule implements RuleSetInterface {

    private boolean[][] grid;
    private boolean wrap = false;

    public DefaultRule() {

    }

    private int countCells(boolean[][] a, int i, int j) {
	int count = 0;

	int iminus = i - 1;
	int jminus = j - 1;
	int iplus = i + 1;
	int jplus = j + 1;

	if (!this.wrap) {
	    if (iminus >= 0) {
		if (jminus >= 0) {
		    if (a[iminus][jminus]) {
			count++;
		    }
		}

		if (a[iminus][j]) {
		    count++;
		}

		if (jplus < GridBase.GRID_WIDTH) {
		    if (a[iminus][jplus]) {
			count++;
		    }
		}
	    }

	    if (jminus >= 0) {
		if (a[i][jminus]) {
		    count++;
		}
	    }

	    if (jplus < GridBase.GRID_WIDTH) {
		if (a[i][jplus]) {
		    count++;
		}
	    }

	    if (iplus < GridBase.GRID_WIDTH) {
		if (jminus >= 0) {
		    if (a[iplus][jminus]) {
			count++;
		    }
		}

		if (a[iplus][j]) {
		    count++;
		}

		if (jplus < GridBase.GRID_WIDTH) {
		    if (a[iplus][jplus]) {
			count++;
		    }
		}
	    }
	} else {
	    if (iminus >= 0) {
		if (jminus >= 0) {
		    if (a[iminus][jminus]) {
			count++;
		    }
		} else if (jminus < 0) {
		    if (a[iminus][GridBase.GRID_WIDTH +jminus]) {
			count++;
		    }
		}

		if (a[iminus][j]) {
		    count++;
		}

		if (jplus < GridBase.GRID_WIDTH) {
		    if (a[iminus][jplus]) {
			count++;
		    }
		} else if (jplus > GridBase.GRID_WIDTH) {
		    if (a[iminus][jplus - GridBase.GRID_WIDTH]) {
			count++;
		    }
		}
	    } else if (iminus < 0) {
		if (a[GridBase.GRID_WIDTH + iminus][j]) {
		    count++;
		}
	    }

	    if (jminus >= 0) {
		if (a[i][jminus]) {
		    count++;
		}
	    } else if (jminus < 0) {
		if (a[i][GridBase.GRID_WIDTH + jminus]) {
		    count++;
		}
	    }

	    if (jplus < GridBase.GRID_WIDTH) {
		if (a[i][jplus]) {
		    count++;
		}
	    } else if (jplus > GridBase.GRID_WIDTH) {
		if (a[i][GridBase.GRID_WIDTH - jplus]) {
		    count++;
		}
	    }

	    if (iplus < GridBase.GRID_WIDTH) {
		if (jminus >= 0) {
		    if (a[iplus][jminus]) {
			count++;
		    }
		} else if (jminus < 0) {
		    if (a[iplus][GridBase.GRID_WIDTH + jminus]) {
			count++;
		    }
		}

		if (a[iplus][j]) {
		    count++;
		}

		if (jplus < GridBase.GRID_WIDTH) {
		    if (a[iplus][jplus]) {
			count++;
		    }
		} else if (jplus > GridBase.GRID_WIDTH) {
		    if (a[iplus][jplus - GridBase.GRID_WIDTH]) {
			count++;
		    }
		}
	    }

	}

	return count;
    }

    public boolean[][] getGrid() {
	return grid;
    }

    @Override
    public void ApplyRule(boolean[][] a) {
	this.grid = new boolean[GridBase.GRID_WIDTH][GridBase.GRID_WIDTH];
	for (int i = 0; i < GridBase.GRID_WIDTH; i++) {
	    for (int j = 0; j < GridBase.GRID_WIDTH; j++) {
		grid[i][j] = a[i][j];
	    }
	}
	for (int i = 0; i < GridBase.GRID_WIDTH; i++) {
	    for (int j = 0; j < GridBase.GRID_WIDTH; j++) {
		int count = countCells(a, i, j);
		if (count == 3) {
		    grid[i][j] = true;
		}
		if (a[i][j] && count < 2) {
		    grid[i][j] = false;
		}
		if (a[i][j] && count > 3) {
		    grid[i][j] = false;
		}
	    }
	}
    }

    @Override
    public void setWrap(boolean bl) {
	wrap = bl;
    }
}
