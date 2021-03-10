public class SparseMatrix {

	private final SparseMatrixIndex[] matrixIndex;
	private final int totalRow, totalCol;
	
	/**
	 * Constructor initializes the Sparse matrix
	 * @param matrix
	 */
	public SparseMatrix(int[][] matrix) {
		totalRow = matrix.length;
		totalCol = matrix[0].length;
		int count = 0,index = 0;
		for (int i = 0; i < totalRow; i++) {
			for (int j = 0; j < totalCol; j++) {
				if(matrix[i][j] !=0){
					count++;
				}
			}
		}
		
		matrixIndex = new SparseMatrixIndex[count];
		for (int i = 0; i < totalRow; i++) {
			for (int j = 0; j < totalCol; j++) {
				if(matrix[i][j] !=0){
					SparseMatrixIndex smi = new SparseMatrixIndex(i, j, matrix[i][j]);
					matrixIndex[index++] = smi;
				}
			}
		}
	}
	
	/**
	 * Method to compute transpose of sparse matrix
	 * @return transpose matrix
	 */
	public int[][] transposeMatrix(){
		int[][] transpose = new int[totalRow][totalCol]; 
		for (int i = 0; i < matrixIndex.length; i++) {
			transpose[matrixIndex[i].getColIndex()][matrixIndex[i].getRowIndex()]
					= matrixIndex[i].getValue();
		}
		return transpose;
	}
	
	/**
	 * Adds two SparseMatrix
	 *  	this + sparseMatrix 
	 * @param sparseMatrix
	 * @return AdditionMatrix
	 * @throws ArithmeticException
	 */
	public int[][] addMatrix(SparseMatrix sparseMatrix) throws ArithmeticException{
		if(this.totalRow != sparseMatrix.totalRow 
				|| this.totalCol != sparseMatrix.totalCol){
			throw new ArithmeticException("Dimension are different");
		}
		int[][] addMat = new int[this.totalRow][this.totalCol];
		for (int i = 0; i < this.matrixIndex.length; i++) {
			addMat[this.matrixIndex[i].getRowIndex()][this.matrixIndex[i].getColIndex()]
					= this.matrixIndex[i].getValue();
		}
		for (int i = 0; i < sparseMatrix.matrixIndex.length; i++) {
			addMat[sparseMatrix.matrixIndex[i].getRowIndex()][sparseMatrix.matrixIndex[i].getColIndex()]
					+= sparseMatrix.matrixIndex[i].getValue();
		}
		return addMat;
	}

	/**
	 * Multiply two SparseMatrix
	 * 		this * sparseMatrix 
	 * @param sparseMatrix
	 * @return MultiplicationMatrix
	 * @throws ArithmeticException
	 */
	public int[][] multiplyMatrix(SparseMatrix sparseMatrix) throws ArithmeticException{
		if(this.totalCol != sparseMatrix.totalRow){
			throw new ArithmeticException("Dimension mismatch: this.column != sparsematrix.row");
		}
		int[][] mulMat = new int[this.totalRow][sparseMatrix.totalCol];
		for (int i = 0; i < this.matrixIndex.length; i++) {
			for (int j = 0; j < sparseMatrix.matrixIndex.length; j++) {
				if(this.matrixIndex[i].getColIndex() == sparseMatrix.matrixIndex[j].getRowIndex())
				mulMat[sparseMatrix.matrixIndex[j].getRowIndex()][sparseMatrix.matrixIndex[j].getColIndex()]
						+=this.matrixIndex[i].getValue() * sparseMatrix.matrixIndex[j].getValue();
			}
		}
		return mulMat;
	}

	/**
	 * Check whether the sparse matrix is symmetric or not.
	 * @return true if symmetric else false
	 */
	public boolean isSymmetric(){
		for (int i = 0; i < matrixIndex.length; i++) {
			int j;
			for (j = 0; j < matrixIndex.length; j++) {
				if((matrixIndex[i].getRowIndex() == matrixIndex[j].getColIndex()) &&
						(matrixIndex[i].getColIndex() == matrixIndex[j].getRowIndex()) &&
						(matrixIndex[i].getValue() == matrixIndex[j].getValue())){
							break;
						}
			}
			if(j == matrixIndex.length){
				return false;
			}
		}
		return true;
	}
		
}