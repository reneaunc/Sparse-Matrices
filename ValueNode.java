public class ValueNode {
    private int row;
    private int column;
    private int value;
    private ValueNode nextRow;
    private ValueNode nextColumn;

    public ValueNode(int row, int column, int value) {
        this.row = row;
        this.column = column;
        this.value = value;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public ValueNode getNextRow() {
        return nextRow;
    }

    public void setNextRow(ValueNode nextRow) {
        this.nextRow = nextRow;
    }

    public ValueNode getNextColumn() {
        return nextColumn;
    }

    public void setNextColumn(ValueNode nextColumn) {
        this.nextColumn = nextColumn;
    }
}
