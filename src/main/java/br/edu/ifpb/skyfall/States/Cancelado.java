package src.main.java.br.edu.ifpb.skyfall.States;
import src.main.java.br.edu.ifpb.skyfall.Cliente;
import src.main.java.br.edu.ifpb.skyfall.Voo;

public class Cancelado {
    private Voo voo;
    public Cancelado(Voo voo){
        this.voo = voo;
    }
    public void proximoStatus(Status status){
        this.voo.setStatus(status);
    }
    public void notificarMudancaDeEstado(){
        for (Cliente passageiro : voo.getPassageiros()) {
            passageiro.receberNotificacao();
        }
    }
}
