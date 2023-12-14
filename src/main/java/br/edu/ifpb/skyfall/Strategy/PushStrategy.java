package src.main.java.br.edu.ifpb.skyfall.Strategy;

public class PushStrategy implements NotificadorStrategy{
    @Override
    public void notificar(String mensagem) {
        System.out.println("NOTIFICAÇÃO PUSH: "+ mensagem);
    }

    @Override
    public String toString(){
        return "Push";
    }
}
