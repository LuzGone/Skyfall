import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class Voo {
    private long codigo;
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

    public void setStatus(Status status){
        this.status = status;
    }

    public void cancelarVoo(){
        this.status.proximoStatus((Status) new Cancelado(this));
    }

    public void atrasarVoo(Long minutos){
        this.data.plusMinutes(minutos);
        this.previsaoChegada.plusMinutes(minutos);
        this.previsaoPartida.plusMinutes(minutos);
        this.status.proximoStatus((Status) new Atrasado(this));
    }

    public void confirmarVoo(){
        this.status.proximoStatus((Status) new Confirmado(this));
    }

    public void mudarPortao(String novoPortao){
        this.portaoEmbarque = novoPortao;
        this.status.proximoStatus((Status) new MudancaPortao(this));
    }

    public void finalizarVoo(){
        this.status.proximoStatus((Status) new Finalizado(this));
    }

    public String venderPassagem(Cliente cliente){
        if(this.assentosDisponiveis>0){
            this.passageiros.add(cliente);
            this.assentosOcupados+=1;
            this.assentosDisponiveis-=1;
            return "Passagem Vendida. Cliente Cadastrado.";
        }
        return "Não há vagas.";
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
