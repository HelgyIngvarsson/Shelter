package application.dao;



import application.model.Cell;

import java.util.List;

/*
 * author Ghavrilin Oleg
 * 02.06.2017.
 * DAO for Cell object
 */
public interface CellDao{

    public void saveCell(Cell cell);
    public void updateCell(Cell cell);
    public void deleteCell(Integer id);
    public Cell findCell(Integer id);
    public List<Cell> findAllCell();

}
