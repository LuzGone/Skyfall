package src.main.java.br.edu.ifpb.skyfall;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import src.main.java.br.edu.ifpb.skyfall.States.Programado;
import src.main.java.br.edu.ifpb.skyfall.States.Status;

public class Voo {
    private Long codigo;
    private ArrayList<Cliente> passageiros;
    private Status status;
    private String origem;
    private String destino;
    private String portaoEmbarque;
    private LocalDateTime data;
    private LocalDateTime previsaoPartida;
    private LocalDateTime previsaoChegada;
    private Aeronave aeronave;
    private int assentosDisponiveis;
    private int assentosOcupados;
    
    public Voo(
        String origem, 
        String destino,
        String portaoEmbarque, 
        LocalDateTime data, 
        LocalDateTime previsaoPartida, 
        LocalDateTime previsaoChegada, 
        Aeronave aeronave){
            this.codigo = new Date().getTime();
            this.passageiros = new ArrayList<Cliente>(aeronave.getQuantidaDeAssentos());
            this.status = new Programado(this);
            this.origem = origem;
            this.destino = destino;
            this.portaoEmbarque = portaoEmbarque;
            this.data = data;
            this.previsaoPartida = previsaoPartida;
            this.previsaoChegada = previsaoChegada;
            this.aeronave = aeronave;
            this.assentosDisponiveis = aeronave.getQuantidaDeAssentos();
            this.assentosOcupados = 0;
    }

    //GETS

    public Long getCodigo(){
        return this.codigo;
    }

    public Status getStatus(){
        return this.status;
    }

    public String getPortao(){
        return this.portaoEmbarque;
    }

    public LocalDateTime getPrevisaoPartida(){
        return this.previsaoPartida;
    }

    public LocalDateTime getPrevisaoChegada(){
        return this.previsaoChegada;
    }

    public ArrayList<Cliente> getPassageiros(){
        return this.passageiros;
    }

    //SETS

    public void setStatus(Status status){
        this.status = status;
    }

    //Mudanças de Estado do Voo

    public void cancelarVoo() throws Exception{
        try{
            this.status.cancelarVoo();
        }catch(Exception e){
            throw new Exception(e);
        }
    }

    public void atrasarVoo(Long minutos) throws Exception{
        try{
            this.status.atrasarVoo(minutos);
            this.data = this.data.plusMinutes(minutos);
            this.previsaoChegada = this.previsaoChegada.plusMinutes(minutos);
            this.previsaoPartida = this.previsaoPartida.plusMinutes(minutos);
        }catch(Exception e){
            throw new Exception(e);
        }
    }

    public void confirmarVoo() throws Exception{
        try{
            this.status.confirmarVoo();
        }catch(Exception e){
            throw new Exception(e);
        }
    }

    public void mudarPortao(String novoPortao) throws Exception{
        try{
            this.portaoEmbarque = novoPortao;
            this.status.mudarPortao(novoPortao);
        }catch(Exception e){
            throw new Exception(e);
        }
    }

    public void finalizarVoo() throws Exception{
        try{
            this.status.finalizarVoo();
        }catch(Exception e){
            throw new Exception(e);
        }
    }

    //Funções como Publicadora

    public void notificarClientes(String notificacao){
        for (Cliente cliente: this.passageiros){
            cliente.receberNotificacao(notificacao);
        }
    }

    //Outras Funções

    public String cadastrarCliente(Cliente cliente) throws Exception{
        if(this.status instanceof Programado){
            if(this.assentosDisponiveis>0){
                this.passageiros.add(cliente);
                this.assentosOcupados+=1;
                this.assentosDisponiveis-=1;
                return "Passagem Vendida. Cliente Cadastrado.";
            }
            throw new Exception("Não há vagas");
        }else{
            throw new Exception("Não pode cadastrar cliente com voo fora do estado de Programado");
        }
    }

    public String removerCliente(Cliente cliente){
        try{
            this.passageiros.remove(cliente);
            return "Cliente removido com Sucesso";
        }catch (Exception e){
            return "Cliente não Encontrado";
        }

    }

    @Override
    public String toString(){
        DateTimeFormatter CUSTOM_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss");
        String saida = "Voo: " + this.codigo + "\n";
        saida = saida + "Status: " + this.status + "\n";
        saida = saida + "Origem: " + this.origem + "\n";
        saida = saida + "Destino: " + this.destino + "\n";
        saida = saida + "Portao de Embarque: " + this.portaoEmbarque + "\n";
        saida = saida + "Data: " + this.data.format(CUSTOM_FORMATTER) + "\n"; 
        saida = saida + "Previsão de Partida: " + this.previsaoPartida.format(CUSTOM_FORMATTER) + "\n";
        saida = saida + "Previsão de Chegada: " + this.previsaoChegada.format(CUSTOM_FORMATTER) + "\n";
        saida = saida + "Assentos Disponíveis: " + this.assentosDisponiveis + "\n";
        saida = saida + "Assentos Ocupados: " + this.assentosOcupados + "\n";
        saida = saida + "Tipo da Aeronave: " + this.aeronave.getTipo() + "\n";
        saida = saida + "Lista de Passageiros: \n";
        for(Cliente cliente : this.passageiros){
            saida = saida + cliente + "\n";
        }
        return saida;
    }


}
