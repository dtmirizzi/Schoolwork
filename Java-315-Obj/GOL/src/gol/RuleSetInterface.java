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

public interface RuleSetInterface {

	public abstract void ApplyRule(boolean[][] a);
	public boolean[][] getGrid();
	public void setWrap(boolean bl);

}