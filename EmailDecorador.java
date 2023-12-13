public class EmailDecorador extends DecoradorBase{
    public EmailDecorador(Notificador notificador){
        super(notificador);
    }
    public void notificarMudancaDeStatus(Status status){
        super.notificarMudancaDeStatus();
        System.out.println("Enviando email...");
    }
}
