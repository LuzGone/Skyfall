package src.main.java.br.edu.ifpb.skyfall.Strategy;

public class Notificador {
    private NotificadorStrategy notificadorStrategy;

    public void setNotificadorStrategy(NotificadorStrategy novoStrategy){
        this.notificadorStrategy = novoStrategy;
    }

    public void notificar(String mensagem){
        this.notificadorStrategy.notificar(mensagem);
    }

    @Override
    public String toString(){
        return this.notificadorStrategy.toString();
    }
}
