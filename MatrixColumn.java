public class MatrixColumn {
    private ValueNode first;
    private MatrixColumn next;


    public ValueNode getFirst() {
        return first;
    }

    public MatrixColumn getNext() {
        return next;
    }

    public void setNext(MatrixColumn next) {
        this.next = next;
    }

    public void insert(ValueNode value) {
        ValueNode current = first;
        //if the first value is null then the array is empty
        if(current == null){
            first = value;
        }
        //otherwise if we're inserting to the front
        else if(value.getRow() == first.getRow()){
            value.setNextRow(first.getNextRow());
            first = value;
        }
        else if(first.getRow() > value.getRow()){
            value.setNextRow(first);
            first = value;
        }
        //otherwise preform normally
        else{
            while(current.getNextRow() != null && (current.getNextRow().getRow() < value.getRow())){
                current = current.getNextRow();
            }

            //if the next row has the same position as value then we need to replace rather than insert
            if(current.getNextRow() != null && current.getNextRow().getRow() == value.getRow()){
                if(value.getValue() != 0){
                    value.setNextRow(current.getNextRow().getNextRow());
                    current.setNextRow(value);
                }
                //if the value is now zero then just remove it from the list
                else{
                    current.setNextRow(current.getNextRow().getNextRow());
                }

            }
            //otherwise insert instead of replacing
            else{
                value.setNextRow(current.getNextRow());
                current.setNextRow(value);
            }
        }
    }

    public int get(int position) {
       ValueNode value = first;
        if(value == null){return 0;}
        while (!(value.getRow() == position)){
            value = value.getNextRow();
            if(value.getRow() > position || value == null){
                return 0;
            }
        }

        return value.getValue();
    }
}
