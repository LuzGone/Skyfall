package src.main.java.br.edu.ifpb.skyfall.Decorators;

public class EmailDecorador extends DecoradorBase{
    public EmailDecorador(Logger logger){
        super(logger);
    }

    @Override
    public void registrarLog(String mensagem){
        super.registrarLog(mensagem);
        this.notificarEmail(mensagem);
    }

    public void notificarEmail(String mensagem){
        System.out.println("NOTIFICAÇÃO EMAIL: \n" + mensagem);
    }
}
