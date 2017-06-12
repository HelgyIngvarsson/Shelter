package application.service;

import application.model.Cell;

import java.util.List;

/**
 * Created by ЖЛЗК on 10.06.2017.
 */
public interface CellService {
    public void saveCell(Cell cell);
    public void updateCell(Cell cell);
    public void deleteCell(Integer id);
    public Cell findCell(Integer id);
    public List<Cell> findAllCell();
}
