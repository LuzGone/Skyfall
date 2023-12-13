package src.main.java.br.edu.ifpb.skyfall;
public class Cliente {
    private String nome;
    private String cpf;
    public Cliente(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
    }
    public String getNome(){
        return this.nome;
    }
    public String getCpf(){
        return this.cpf;
    }
    public void receberNotificacao(){
        System.out.println("Notificação recebida");
    }
}
