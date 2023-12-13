package src.main.java.br.edu.ifpb.skyfall.Decorators;
import src.main.java.br.edu.ifpb.skyfall.States.Status;

public class SMSDecorador extends DecoradorBase {
    public SMSDecorador(Notificador notificador) {
        super(notificador);
    }
    public void notificarMudancaDeStatus(Status status) {
        super.notificarMudancaDeStatus();
        System.out.println("Enviando SMS...");
    }
}
