package src.main.java.br.edu.ifpb.skyfall.Decorators;

public class SMSDecorador extends DecoradorBase {
    public SMSDecorador(Notificador notificador) {
        super(notificador);
    }

    @Override
    public void notificar(String mensagem){
        super.notificar(mensagem);
        this.notificarSMS(mensagem);
    }

    public void notificarSMS(String mensagem){
        System.out.println("NOTIFICAÇÃO SMS: \n" + mensagem);
    }
}
