package src.main.java.br.edu.ifpb.skyfall;

import src.main.java.br.edu.ifpb.skyfall.Decorators.EmailDecorador;
import src.main.java.br.edu.ifpb.skyfall.Decorators.Notificador;
import src.main.java.br.edu.ifpb.skyfall.Decorators.PushDecorador;
import src.main.java.br.edu.ifpb.skyfall.Decorators.SMSDecorador;

public class Cliente implements Assinante{
    private String nome;
    private String cpf;
    private Notificador notificador;

    public Cliente(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
    }

    public void definirNotificador(Boolean email, Boolean push, Boolean sms){
        if(email){
            this.notificador = new EmailDecorador(this.notificador);
        }
        if(push){
            this.notificador = new PushDecorador(this.notificador);
        }
        if(sms){
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
        System.out.println("Cliente: "+ this.nome);
        this.notificador.notificar(notificacao);
    }
}
