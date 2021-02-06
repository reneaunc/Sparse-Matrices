import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class MatrixReader {

    public SparseMatrix read(String file){
        File fileObject = new File(file);

        try{
            Scanner scanner = new Scanner(fileObject);

            int rows = Integer.parseInt(scanner.nextLine());
            int columns = Integer.parseInt(scanner.nextLine());

            SparseMatrix newMatrix = new SparseMatrix(rows, columns);

            for(int row = 1; row <= rows; row ++){
                String[] entries = scanner.nextLine().strip().split(" ");
                for (String entry : entries) {
                    String[] splitEntry = entry.split(",");
                    int column = Integer.parseInt(splitEntry[0]);
                    int value = Integer.parseInt(splitEntry[1]);

                    newMatrix.insert(row, column, value);
                }
            }
            scanner.close();
            return newMatrix;
        }
        catch(FileNotFoundException e){
            throw new RuntimeException(e.toString());
        }
    }
}
