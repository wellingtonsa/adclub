package entities;

import java.util.Scanner;

public class User {
    private Integer id;
    private String name;
    private String CPF;
    private Integer taskId;

    public User(Integer id, String name, String CPF){
        this.id = id;
        this.name = name;
        this.CPF = CPF;
        this.taskId = -1;
    }

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

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String cPF) {
        CPF = cPF;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public boolean completeTask(Category category){
        String task = category.getTasks().keyOf(taskId + 1);

        if(task.length() > 0){

            System.out.println("--- Categoria "+category.getName()+ " ---");
            System.out.println(task);
            System.out.println("Realizar tarefa?");
            System.out.println("1 - SIM");
            System.out.println("2 - NAO");
    
            Scanner scanner = new Scanner(System.in);

            if(scanner.nextInt() == 1){
                setTaskId(taskId + 1);
                return true;
            }else {
                return false;
            }
    
          }else {
              return false;
          }
    }


    public boolean completedAllTasks(Category category){
        return taskId > 0 && taskId % (category.getId() * 3) == 0;
    }

    
}
