package application.service;


import application.model.Worker;

import java.util.List;

/**
 * author Ghavrilin Oleg
 * 02.06.2017
 * Dao for Worker entity
 */
public interface WorkerService {

    public void saveWorker(Worker worker);
    public void updateWorker(Worker worker);
    public void deleteWorker(Integer id);
    public Worker findWorker(Integer id);
    public List<Worker> findAllWorker();
    public List<Worker> findAllKeepers();
}
