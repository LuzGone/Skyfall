public class SMSDecorador extends DecoradorBase {
    public SMSDecorador(Notificador notificador) {
        super(notificador);
    }
    public void notificarMudancaDeStatus(Status status) {
        super.notificarMudancaDeStatus();
        System.out.println("Enviando SMS...");
    }
}
