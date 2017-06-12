package application.service.impl;

import application.dao.CellDao;
import application.impl.CellDaoImpl;
import application.model.Cell;
import application.service.CellService;

import java.util.List;

/**
 * Created by ЖЛЗК on 10.06.2017.
 */

public class CellServiceImpl implements CellService {

    private CellDao cellDao = new CellDaoImpl();
    @Override
    public void saveCell(Cell cell) {
    cellDao.saveCell(cell);
    }

    @Override
    public void updateCell(Cell cell) {
    cellDao.updateCell(cell);
    }

    @Override
    public void deleteCell(Integer id) {
    cellDao.deleteCell(id);
    }

    @Override
    public Cell findCell(Integer id) {
        return cellDao.findCell(id);
    }

    @Override
    public List<Cell> findAllCell() {
        return cellDao.findAllCell();
    }
}
