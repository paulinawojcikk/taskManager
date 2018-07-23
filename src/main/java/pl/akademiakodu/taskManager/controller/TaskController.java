package pl.akademiakodu.taskManager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.akademiakodu.taskManager.dao.TaskDao;
import pl.akademiakodu.taskManager.model.Task;

@Controller
public class TaskController {

    @Autowired
    private TaskDao taskDao;

    //taskDao=new TaskDaoImpl();

    @GetMapping ("/add")
    public String add() {
        return "tasks/add";
    }

    @PostMapping ("/add")
    public String addTask(@ModelAttribute Task task) {
        taskDao.add(task);
        return "redirect:/all";
    }


    @GetMapping ("/all")
    public String all(ModelMap modelMap){
        modelMap.put("tasks", taskDao.findAll());
        modelMap.put("description","Lista zadań");
        return "tasks/all";
    }


    @GetMapping("/finished")
    public String finished(ModelMap modelMap) {
        modelMap.put("tasks", taskDao.findFinished());
        modelMap.put("description","Lista zadań ukończonych");
        return "tasks/all";
    }

    @GetMapping("/unfinished")
    public String unfinished(ModelMap modelMap) {
        modelMap.put("tasks", taskDao.findUnfinished());
        modelMap.put("description","Lista wszystkich zadań");
        return "tasks/all";
    }


    @PostMapping ("/update")
    public String update(@ModelAttribute Task task) {
        taskDao.update(task);
        return "redirect:/all";

    }
    @GetMapping("/tasks/{id}")
    public String getTask(@PathVariable Integer id, ModelMap modelMap){
        modelMap.put("task",taskDao.findById(id));
        return "tasks/show";
    }
}
