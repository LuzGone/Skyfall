package src.main.java.br.edu.ifpb.skyfall.Decorators;

public class EmailDecorador extends DecoradorBase{
    public EmailDecorador(Notificador notificador){
        super(notificador);
    }

    @Override
    public void notificar(String mensagem){
        super.notificar(mensagem);
        this.notificarEmail(mensagem);
    }

    public void notificarEmail(String mensagem){
        System.out.println("NOTIFICAÇÃO EMAIL: \n" + mensagem);
    }
}
