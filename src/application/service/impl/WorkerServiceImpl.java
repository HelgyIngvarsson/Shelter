package application.service.impl;

import application.dao.WorkerDao;
import application.impl.WorkerDaoImpl;
import application.model.Worker;
import application.service.WorkerService;

import java.util.List;

/**
 * Created by ЖЛЗК on 10.06.2017.
 */
public class WorkerServiceImpl implements WorkerService {


    private WorkerDao workerDao = new WorkerDaoImpl();

    @Override
    public void saveWorker(Worker worker) {
        workerDao.saveWorker(worker);
    }

    @Override
    public void updateWorker(Worker worker) {
        workerDao.updateWorker(worker);
    }

    @Override
    public void deleteWorker(Integer id) {
        workerDao.deleteWorker(id);
    }

    @Override
    public Worker findWorker(Integer id) {
        return workerDao.findWorker(id);
    }

    @Override
    public List<Worker> findAllWorker() {
        return workerDao.findAllWorker();
    }

    @Override
    public List<Worker> findAllKeepers() {
        return workerDao.findAllKeepers();
    }
}
