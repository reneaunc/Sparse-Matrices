public class Homework2 {
    public void run() {
        MatrixReader reader = new MatrixReader();
        SparseMatrix matrixA = reader.read("matrixA.txt");
        matrixA.print();
        SparseMatrix matrixB = reader.read("matrixB.txt");
        matrixB.print();

        matrixA.transpose().print();
        matrixB.transpose().print();
        
        matrixA.product(matrixB).print();
    }
}
