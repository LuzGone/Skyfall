package src.main.java.br.edu.ifpb.skyfall.Strategy;

public class EmailStrategy implements NotificadorStrategy{
    @Override
    public void notificar(String mensagem) {
        System.out.println("NOTIFICAÇÃO EMAIL: "+ mensagem);
    }

    @Override
    public String toString(){
        return "Email";
    }
}
