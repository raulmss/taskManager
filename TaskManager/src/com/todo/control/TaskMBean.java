package com.todo.control;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


import com.todo.dao.TaskDao;
import com.todo.model.Task;

@ManagedBean
@RequestScoped
public class TaskMBean {

	private static final long serialVersionUID = 1L;
    private Task task;
    private TaskDao td;
    private List<Task> TaskList;
    
    @PostConstruct
    public void init(){
        this.task = new Task();
        this.td = new TaskDao();
        this.TaskList = td.list();
    }

    public String delete(Task task){
    	td.delete(task);
        return "task";
    }
    public void edit(Task task){
        this.task = task;
    }
    
    public String save() {
    	td.saveOrUpdate(task);
        this.task = new Task();
        return "task";
    }
    
    //Geters and seters
    public Task getTask() {
        return task;
    }
    public void setTask(Task task) {
        this.task = task;
    }
    public TaskDao getAd() {
        return td;
    }
    public void setAd(TaskDao td) {
        this.td = td;
    }
    public List<Task> getTaskList() {
        this.TaskList = td.list();
        return TaskList;
    }
    public void setTaskList(List<Task> taskList) {
        TaskList = taskList;
    }
    
    public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    public void setAsCompleted(Task task) {
    	task.setCompletedTask(true);
    	td.saveOrUpdate(task);
    }
}
