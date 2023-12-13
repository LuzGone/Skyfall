package src.main.java.br.edu.ifpb.skyfall.States;

public interface Status {

    public void proximoStatus(Status status);
    public String toString();
    //Colocar os métodos aqui
    public void confirmarVoo() throws Exception;
    public void cancelarVoo() throws Exception;
    public void finalizarVoo() throws Exception;
    public void mudarPortao(String novoPortao) throws Exception;
    public void atrasarVoo(Long minutos) throws Exception;

}
