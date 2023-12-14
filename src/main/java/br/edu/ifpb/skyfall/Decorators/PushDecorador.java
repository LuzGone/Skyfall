package src.main.java.br.edu.ifpb.skyfall.Decorators;

public class PushDecorador extends DecoradorBase{
    public PushDecorador(Logger logger){
        super(logger);
    }

    @Override
    public void registrarLog(String mensagem){
        super.registrarLog(mensagem);
        this.notificarPush(mensagem);
    }

    public void notificarPush(String mensagem){
        System.out.println("NOTIFICAÇÃO PUSH: \n" + mensagem);
    }
}
