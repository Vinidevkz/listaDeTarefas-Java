/*
* Feito por Vinicius Eduardo Correia dos Santos, 2025
*
* java 24.0.2
*
* Este programa simula uma lista de tarefas, onde o usuário pode criar, ler, atualizar ou deletar
* tarefas em uma lista.
*/


import java.util.Scanner;
import java.util.ArrayList;


class Tarefas {
    String descTarefa;
    boolean concluida;

    //cria uma tarefa
    public Tarefas(String descTarefa){
        this.descTarefa = descTarefa;
        this.concluida = false;
    }

    /*Sobreescrevendo o método toString do objeto, que por padrão retorna o
    *endereço da memória onde o mesmo está guardado. Agora ele irá retornar
    * o conteúdo que está dentro do objeto e nao seu endereço.
    */
    @Override
    public String toString(){
        return "Tarefa: " + descTarefa;
    }
}

class GerenciadorDeTarefas {
    private static ArrayList<Tarefas> listaTarefa = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String args[]){
        int n;

        System.out.println();
        System.out.println("/*---Bem-Vindo(a) ao Gerenciador de Tarefas---*/");
        System.out.println();
        while(true){
            System.out.println();
            System.out.println("Digite os seguintes números para as executar as ações:");
            System.out.println("-> 1: Adicionar uma tarefa");
            System.out.println("-> 2: Ver todas as tarefas");
            System.out.println("-> 3: Alterar uma tarefa");
            System.out.println("-> 4: Remover uma tarefa");
            System.out.println("-> 5: Mudar status de uma tarefa (Concluída/Não concluída)");
            System.out.println("-> 0: Sair do programa");

            n = scanner.nextInt();
            scanner.nextLine();

            switch(n){
                case 1:
                    criarTarefa();
                    break;
                case 2:
                    listarTarefas();
                    break;
                case 3:
                    alterarTarefas();
                    break;
                case 4:
                    deleterTarefas();
                    break;
                case 5:
                    concluirTarefas();
                    break;
                case 0:
                    System.out.println("Saindo do programa...");
                    return;
            }
        }

    }

    private static void criarTarefa(){
        System.out.println("Digite a dexcrição da tarefa:");
        String descTarefa = scanner.nextLine();
        listaTarefa.add(new Tarefas(descTarefa));
        System.out.println("-> Tarefa criada com sucesso.");
    }

    private static void listarTarefas(){
        if (listaTarefa.isEmpty()){
            System.out.println("-> Não há tarefas na lista.");
        }else{
            for(int i = 0; i < listaTarefa.size(); i++){
                System.out.println(i + ": " + listaTarefa.get(i) + " | Status: " + (listaTarefa.get(i).concluida ? "Concluída" : "Não concluída"));
            }
        }
    }

    private static void alterarTarefas(){
        System.out.println("Digite o índice da tarefa que deseja alterar: ");
        int indice = scanner.nextInt(); //no buffer -> [2][\n]
        scanner.nextLine(); //limpando o buffer, tirando o espaço(\n) e deixando eu digitar na proxima linha

        System.out.println("Digite a nova descrição: ");
        String newDesc = scanner.nextLine();
        Tarefas tarefa = listaTarefa.get(indice);
        tarefa.descTarefa = newDesc;
        System.out.println("-> Tarefa alterada com sucesso.");
    }

    private static void deleterTarefas(){
        System.out.println("Digite o índice da tarefa que quer deletar: ");
        int indice = scanner.nextInt();
        scanner.nextLine();

        listaTarefa.remove(indice);
        System.out.println("-> Tarefa removida com sucesso.");
    }

    private static void concluirTarefas(){
        System.out.println("Digite o índice da tarefa que deseja alterar o status: ");
        int indice = scanner.nextInt();
        scanner.nextLine();

        Tarefas tarefa = listaTarefa.get(indice);
        tarefa.concluida = tarefa.concluida ? false : true;
        System.out.println("Status alterado com sucesso.");
    }
}