package src.main.java.br.edu.ifpb.skyfall.Decorators;

public class PushDecorador extends DecoradorBase{
    public PushDecorador(Notificador notificador){
        super(notificador);
    }

    @Override
    public void notificar(String mensagem){
        super.notificar(mensagem);
        this.notificarPush(mensagem);
    }

    public void notificarPush(String mensagem){
        System.out.println("NOTIFICAÇÃO PUSH: \n" + mensagem);
    }
}
