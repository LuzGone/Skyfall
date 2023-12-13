public class Finalizado implements Status {
    private Voo voo;
    public Finalizado(Voo voo){
        this.voo = voo;
    }
    public void proximoStatus(Status status){}
    public void notificarMudancaDeEstado(){}
}
