package src.main.java.br.edu.ifpb.skyfall.Decorators;

import src.main.java.br.edu.ifpb.skyfall.States.Status;

public class EmailDecorador extends DecoradorBase{
    public EmailDecorador(Notificador notificador){
        super(notificador);
    }
    public void notificarMudancaDeStatus(Status status){
        super.notificarMudancaDeStatus();
        System.out.println("Enviando email...");
    }
}
