package src.main.java.br.edu.ifpb.skyfall;

import src.main.java.br.edu.ifpb.skyfall.Decorators.EmailDecorador;
import src.main.java.br.edu.ifpb.skyfall.Decorators.Notificador;
import src.main.java.br.edu.ifpb.skyfall.Decorators.NotificadorBase;
import src.main.java.br.edu.ifpb.skyfall.Decorators.PushDecorador;
import src.main.java.br.edu.ifpb.skyfall.Decorators.SMSDecorador;

public class Cliente implements Assinante{
    private String nome;
    private String cpf;
    private Notificador notificador;
    private Boolean email;
    private Boolean push;
    private Boolean sms;

    public Cliente(String nome, String cpf,Boolean email, Boolean push, Boolean sms){
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.sms = sms;
        this.push = push;
        this.notificador = new NotificadorBase();
        this.definirNotificador();
    }

    public void definirNotificador(){
        if(this.email){
            this.notificador = new EmailDecorador(this.notificador);
        }
        if(this.push){
            this.notificador = new PushDecorador(this.notificador);
        }
        if(this.sms){
            this.notificador = new SMSDecorador(this.notificador);
        }
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
        saida = saida + "\nTipos de Notificação: ";
        saida = saida + "\n-> Email: " + this.email;
        saida = saida + "\n-> Push: " + this.push;
        saida = saida + "\n-> SMS: " + this.sms;
        return saida;
    }

    
}
