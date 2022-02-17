package main;

import algorithms.DisjoinSet;
import algorithms.Heap;
import entities.Category;
import entities.User;

public class Main {
    public static void main(String[] args) {


        //Adicionando as categorias e tarefas relacionadas a cada uma
        Heap<String> noneTasks = new Heap<String>(4);
        noneTasks.insert(0, "Finalize o seu cadastro");

        Category none = new Category(0, "Nenhuma", noneTasks);

        Heap<String> silverTasks = new Heap<String>(4);
        silverTasks.insert(1, "Convide pelo menos 1 amigo");
        silverTasks.insert(2, "Compre pelo menos 10 reais com o seu novo Cartão de Crédito");
        silverTasks.insert(3, "Avalie-nos na Google Play Store e/ou na Apple Store");
        Category silver = new Category(1, "Prata", silverTasks);

        Heap<String> bronzeTasks = new Heap<String>(7);
        bronzeTasks.insert(4, "Convide pelo menos 2 amigos");
        bronzeTasks.insert(5, "Compre pelo menos 100 reais com o seu Cartão de Crédito Adclub");
        bronzeTasks.insert(6, "Pague sua fatura com até 5 dias de atecedência");
        Category bronze = new Category(2, "Bronze", bronzeTasks);

        Heap<String> goldTasks = new Heap<String>(10);
        goldTasks.insert(7, "Convide pelo menos 10 amigos");
        goldTasks.insert(8, "Faça um imprestimo com de pelo menos 10mil reais com a Adclub");
        goldTasks.insert(9, "Compre pelo menos 5mil reais com o programa de Cashback da Adclub");
        Category gold = new Category(3, "Ouro", goldTasks);

        Heap<String> diamondTasks = new Heap<String>(0);
        Category diamond = new Category(4, "Diamante", diamondTasks);


        DisjoinSet categories = new DisjoinSet(100);

        

        //Criando o usuario, inicialmente sem categoria
        User user = new User(5, "Wellington", "12345678910");


        //Adicionando o usuario na categoria padroa (Nenhuma categoria)
        categories.union(user.getId(), none);
        

        //Usuario completa a tarefa obrigatoria
        Category category = categories.findPointer(user.getId());
        boolean requiredTaskCompleted = user.completeTask(category);

        //Depois de completo, o usuario passa para a categoria Prata
        if(requiredTaskCompleted){
            categories.union(user.getId(), silver);

            category = categories.findPointer(user.getId());

            //Respondendo perguntas da categoria Prata
            while(!user.completedAllTasks(category)){
                user.completeTask(category);
            }

        
            //Passando para a categoria Bronze
            categories.union(user.getId(), bronze);

            category = categories.findPointer(user.getId());

            //Respondendo perguntas da categoria Bronze
            while(!user.completedAllTasks(category)){
                user.completeTask(category);
            }


             //Passando para a categoria Ouro
            categories.union(user.getId(), gold);

            category = categories.findPointer(user.getId());

            //Respondendo perguntas da categoria Ouro
            while(!user.completedAllTasks(category)){
                user.completeTask(category);
            }

             //Passando para a categoria Diamante
            categories.union(user.getId(), diamond);

            category = categories.findPointer(user.getId());

            System.out.println("--- Categoria "+category.getName()+ " ---");
        
        }


    }
}
