public class MatrixRow {
    private ValueNode first;
    private MatrixRow next;

    public ValueNode getFirst() {
        return first;
    }

    public MatrixRow getNext() {
        return next;
    }

    public void setNext(MatrixRow next) {
        this.next = next;
    }

    public void insert(ValueNode value) {
        ValueNode current = first;
        //if the first value is null then the array is empty
        if(current == null){
            first = value;
        }
        //otherwise if we're inserting to the front
        else if(value.getColumn() == first.getColumn()){
            value.setNextColumn(first.getNextColumn());
            first = value; 
        }
        else if(first.getColumn() > value.getColumn()){
            value.setNextColumn(first);
            first = value;
        }
        //otherwise preform normally
        else{
            while(current.getNextColumn() != null && (current.getColumn() < value.getColumn()) ){
                current = current.getNextColumn(); 
            }
            //if the next colum has the same position as value then we need to replace rather than insert
            if(current.getNextColumn() != null && current.getNextColumn().getColumn() == value.getColumn()){
                
                
                if(value.getValue() != 0){
                    value.setNextColumn(current.getNextColumn().getNextColumn());
                    current.setNextColumn(value);
                }
                //if the value is now zero then just remove it from the list
                else{
                    current.setNextColumn(current.getNextColumn().getNextColumn());
                }
                
            }
            //otherwise insert instead of replacing
            else{
                value.setNextColumn(current.getNextColumn());
                current.setNextColumn(value);
            }
            
    }
}

    public int get(int position){
        ValueNode value = first;
        if(value == null){return 0;}
        while (!(value.getColumn() == position)){
            value = value.getNextColumn();
            if(value == null){
                return 0;
            }
            else if(value.getColumn() > position){
                
            }
        }

        return value.getValue();
    }

}
