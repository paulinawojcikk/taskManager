package pl.akademiakodu.taskManager.dao;

import pl.akademiakodu.taskManager.model.Task;

import java.util.List;

public interface TaskDao {

    List<Task> findAll();
    void add(Task task);
    Task findById (int id);
    void deleteById (int id);
    List<Task> findFinished();
    List<Task> findUnfinished();
    void update (Task task);


}
