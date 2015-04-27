package com.piskovets.sudokusolver;

import android.support.annotation.NonNull;

import java.util.HashSet;
import java.util.Set;

public class Cell implements Comparable<Cell> {
	public static final int DEF = 0;
	int m_val;
	boolean m_preFilled = false;
	Set<Integer> m_constraints = new HashSet<>();
	int m_row, m_col;

	public Cell(int m_val) {
		this.m_val = m_val;
	}

	public boolean isValid() {

		return isValid;
	}

	boolean isValid;

	int row() {
		return m_row;
	}
	
	int col() {
		return m_col;
	}
	Set<Integer> constraints() {
		return m_constraints;
	}
	
	boolean solved() {
		return m_val != DEF;
	}
	
	int constraintSize() {
		return m_constraints.size();  
	}

	public void setIsValid(boolean isValid) {
		this.isValid = isValid;
	}

	private Cell(int val, int row, int col, boolean preFilled) {
		m_val = val;
		m_preFilled = preFilled;
		m_row = row;
		m_col = col;
	}


	public static Cell getCell(int c, int row, int col) {
		if(c==0)
			return new Cell(DEF, row, col, false);
		else
			return new Cell(c, row, col, true);
	}

	int val() {
		return m_val;
	}

	void setVal(int m_val) {
		this.m_val = m_val;
	}

	@Override public String toString() {
		return "" + m_val + "[" + m_row + "," + m_col + "]";
	}

	@Override
	public int compareTo(@NonNull Cell cell2) {
		if(this.constraintSize() == cell2.constraintSize()) 
			return 1;
		return (this.constraintSize() - cell2.constraintSize()) * 10000;
	}
	
	@Override public boolean equals(Object cellObj) {
		if(!(cellObj instanceof Cell)) return false;
		Cell cell = (Cell)cellObj;
		return cell.row() == m_row && cell.col() == m_col;
	}
}
