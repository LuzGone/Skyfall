package src.main.java.br.edu.ifpb.skyfall.Decorators;

public class SMSDecorador extends DecoradorBase {
    public SMSDecorador(Logger logger) {
        super(logger);
    }

    @Override
    public void registrarLog(String mensagem){
        super.registrarLog(mensagem);
        this.notificarSMS(mensagem);
    }

    public void notificarSMS(String mensagem){
        System.out.println("NOTIFICAÇÃO SMS: \n" + mensagem);
    }
}
