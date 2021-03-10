public class SparseMatrixIndex {
	private final int rowIndex;
	private final int colIndex;
	private final int value;
	
	/**
	 * @param rowIndex
	 * @param colIndex
	 * @param value
	 */
	public SparseMatrixIndex(int rowIndex, int colIndex, int value) {
		this.rowIndex = rowIndex;
		this.colIndex = colIndex;
		this.value = value;
	}

	/**
	 * @return the rowIndex
	 */
	public int getRowIndex() {
		return rowIndex;
	}

	/**
	 * @return the colIndex
	 */
	public int getColIndex() {
		return colIndex;
	}

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	
}