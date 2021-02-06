public class SparseMatrix {
    private int totalRows;
    private int totalColumns;
    private MatrixRow firstRow;
    private MatrixColumn firstColumn;

    public SparseMatrix(int rows, int columns) {
        this.totalRows = rows;
        this.totalColumns = columns;

        CreateRows(rows);
        
        CreateColumns(columns);
        
    }

    public void insert(int row, int column, int value) {
        //create the new node object
        if(row > totalRows || column > totalColumns || row < 1 || column < 1){
            throw new IndexOutOfBoundsException();
        }
        
        ValueNode node = new ValueNode(row, column, value);

        //get the matrix row and column objects
        MatrixRow rowObject = getRow(row);
        MatrixColumn columnObject = getColumn(column);

        //insert the new value into the row and column objects
        rowObject.insert(node);
        columnObject.insert(node);

    }

    public MatrixRow getRow(int position) {
        if(position > totalRows || position < 1){
            throw new IndexOutOfBoundsException();
        }
        
        //get the first row
        MatrixRow currentRow = firstRow;

        //loop through all of the rows until we're at the correct index
        for(int i = 1; i < position; i ++){
            currentRow = currentRow.getNext();
        }
        
        return currentRow;
    }

    public MatrixColumn getColumn(int position) {
        if(position > totalColumns || position < 1){
            throw new IndexOutOfBoundsException();
        }
       
        //get the first column
       MatrixColumn currentColumn = firstColumn;

       //loop through all of the rows until we're at the correct index
       for(int i = 1; i < position; i ++){
           currentColumn = currentColumn.getNext();
       }
       
       return currentColumn;
    }

    public int getValue(int row, int column) {
        if(row > totalRows || column > totalColumns || row < 1 || column < 1){
            throw new IndexOutOfBoundsException();
        }

        //get the row at the index row and the correct item in that row at index column
        return getRow(row).get(column);
    }

    public void print() {
        for(int row = 1; row <= totalRows; row ++){
            System.out.print("[");
            for(int column = 1; column <= totalColumns; column++){
                System.out.print(String.format("%d ", getValue(row, column)  ));
            }
            System.out.print("]\n");
        }
        System.out.print("\n");
    }

    public SparseMatrix transpose() {
        SparseMatrix newMatrix = new SparseMatrix(totalColumns, totalRows);

        for(int i = 1; i <= totalRows; i ++){
            for(int j = 1; j <= totalColumns; j ++){
                newMatrix.insert(j, i, getValue(i, j));
            }
        }

        return newMatrix;
    }

    public SparseMatrix product(SparseMatrix other) {
        
        SparseMatrix product = new SparseMatrix(this.totalRows, other.totalColumns);

        for (int i = 1; i <= this.totalRows; i++) {		//computes each row in the product
            for(int j = 1; j <= other.totalColumns; j++) {	//computes each column in the product
                int sum = 0;
                for(int k = 1; k <= this.totalColumns; k++) {	//computes each value in the product
                    sum += this.getValue(i, k) * other.getValue(k, j);
                }
                product.insert(i, j, sum);
            }
        }
        
        
        return product;
    }

    private void CreateColumns(int columns){
        //create the reference to the first column object
        MatrixColumn currentColumn = new MatrixColumn();
        firstColumn = currentColumn;

        //create all of the new column objects and assign them in sequence with references.
        for(int j = 1; j <= columns; j ++){
            MatrixColumn nextColumn = new MatrixColumn();
            currentColumn.setNext(nextColumn);
            
            currentColumn = nextColumn;
        }
    }

    private void CreateRows(int rows){
        //create the reference to the first row object
        MatrixRow currentRow = new MatrixRow();
        firstRow = currentRow;

        //create all of the new row objects and sets them in sequence with references
        for(int i = 2; i <= rows; i++){
            
            MatrixRow nextRow = new MatrixRow();
            currentRow.setNext(nextRow);
            
            currentRow = nextRow;
        }

    }
}
