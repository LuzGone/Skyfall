package src.main.java.br.edu.ifpb.skyfall.Strategy;

public class SmsStrategy implements NotificadorStrategy{
    @Override
    public void notificar(String mensagem) {
        System.out.println("NOTIFICAÇÃO SMS: "+ mensagem);
    }

    @Override
    public String toString(){
        return "SMS";
    }
}
