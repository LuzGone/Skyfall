package src.main.java.br.edu.ifpb.skyfall;
public class Aeronave {
    private String tipo;
    private int quantidadeDeAssentos;

    public Aeronave(String tipo, int quantidadeDeAssentos){
        this.tipo =tipo;
        this.quantidadeDeAssentos = quantidadeDeAssentos;
    }

    public String getTipo(){
        return this.tipo;
    }

    public int getQuantidaDeAssentos(){
        return this.quantidadeDeAssentos;
    }

    @Override
    public String toString(){
        return "Tipo da Aeronave: " + this.tipo + "\nQuantidade de Assentos: " + Integer.toString(quantidadeDeAssentos);
    }
}
