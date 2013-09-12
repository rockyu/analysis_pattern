package study.pattern.dsl.altcompmodel.decisiontable;

public interface ITable {
    
    String cell(int row, int col);
    
    int getRowCount();
    
    int getColumnCount();

}
