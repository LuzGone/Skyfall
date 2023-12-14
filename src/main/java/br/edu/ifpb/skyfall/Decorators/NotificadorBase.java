package src.main.java.br.edu.ifpb.skyfall.Decorators;

public class NotificadorBase implements Notificador{

    public NotificadorBase(){
    }

    @Override
    public void notificar(String mensagem){
        System.out.println("Notificação: " + mensagem);
    }
}
