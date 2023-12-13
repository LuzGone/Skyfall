public class PushDecorador extends DecoradorBase{
    public PushDecorador(Notificador notificador){
        super(notificador);
    }
    public void notificarMudancaDeStatus(Status status){
        super.notificarMudancaDeStatus();
        System.out.println("Enviando notificação push...");
    }
}
