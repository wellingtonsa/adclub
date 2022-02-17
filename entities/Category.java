package entities;

import algorithms.DisjoinSet;
import algorithms.Heap;

public class Category {
    private Integer id;
    private String name;
    private DisjoinSet users;
    private Heap<String> tasks;
    
    public Category(Integer id, String name, Heap<String> tasks){

        this.id = id;
        this.name = name;
        this.tasks = tasks;
        this.users = new DisjoinSet(100);
        
    }

    public Category(){};


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Heap<String> getTasks() {
        return tasks;
    }

    public void setTasks(Heap<String> tasks) {
        this.tasks = tasks;
    }

    public DisjoinSet getUsers() {
        return users;
    }

    public void setUsers(DisjoinSet users) {
        this.users = users;
    }

    

    
    
}
