package src.main.java.br.edu.ifpb.skyfall.States;

public interface Status {

    public void proximoStatus(Status status);
    public void notificarMudancaDeEstado();
    public String toString();
}
