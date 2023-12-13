public class Programado implements Status  {
    private Voo voo;
    public Programado(Voo voo){
        this.voo = voo;
    }
    public void proximoStatus(Status status){}
    public void notificarMudancaDeEstado(){}
}
