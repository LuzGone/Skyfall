package src.main.java.br.edu.ifpb.skyfall;

import src.main.java.br.edu.ifpb.skyfall.Strategy.Notificador;
import src.main.java.br.edu.ifpb.skyfall.Strategy.NotificadorStrategy;

public class Passageiro implements Assinante{
    private String nome;
    private String cpf;
    private Notificador notificador = new Notificador();

    public Passageiro(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
    }

    public void definirNotificador(NotificadorStrategy notificadorStrategy){
        this.notificador.setNotificadorStrategy(notificadorStrategy);
    }

    public String getNome(){
        return this.nome;
    }

    public String getCpf(){
        return this.cpf;
    }

    public void receberNotificacao(String notificacao){
        System.out.println("-------------");
        System.out.println("Cliente: "+ this.nome);
        this.notificador.notificar(notificacao);
    }

    @Override
    public String toString(){
        String saida = "Nome do Cliente: " + this.nome;
        saida = saida + "\nCpf: " + this.cpf;
        saida = saida + "\nTipo de Notificação: " +  this.notificador;
        return saida;
    }

    
}
