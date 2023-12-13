package src.main.java.br.edu.ifpb.skyfall.Decorators;
public class DecoradorBase implements Notificador {
    protected Notificador notificador;
    public DecoradorBase(Notificador notificador){
        this.notificador = notificador;
    }
    public void notificarMudancaDeStatus(){
        notificador.notificarMudancaDeStatus();
    }
}
