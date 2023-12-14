package src.main.java.br.edu.ifpb.skyfall.States;
import src.main.java.br.edu.ifpb.skyfall.Voo;


public class Programado implements Status  {
    private Voo voo;

    public Programado(Voo voo){
        this.voo = voo;
    }

    public void proximoStatus(Status status){
        this.voo.setStatus(status);
    }

    public void confirmarVoo() throws Exception{
        if(this.voo.getStatus() instanceof Programado){
            this.proximoStatus(new Confirmado(this.voo));
            this.voo.notificarClientes("O Voo "+ this.voo.getCodigo() + " foi confirmado.");
        }else{
            throw new Exception("O voo só pode ser Confirmado se ainda estiver como Programado.");
        }
    }

    public void atrasarVoo(Long minutos) throws Exception{
        if(this.voo.getStatus() instanceof Confirmado){
            this.proximoStatus(new Atrasado(this.voo));
            this.voo.notificarClientes("O Voo "+ this.voo.getCodigo() + " foi atrasado " + minutos + " minutos.");
        }else{
            throw new Exception("O voo só pode ser Atrasado se estiver Confirmado.");
        }
    };

    public void cancelarVoo() throws Exception{
        if(this.voo.getStatus() instanceof Programado){
            this.proximoStatus(new Cancelado(this.voo));
            this.voo.notificarClientes("O Voo "+ this.voo.getCodigo() + " foi cancelado.");
        }else{
            throw new Exception("O voo só pode ser Cancelado se ainda estiver como Programado.");
        }
    };

    public void finalizarVoo() throws Exception{
        if(this.voo.getStatus() instanceof Confirmado 
        || this.voo.getStatus() instanceof MudancaPortao 
        || this.voo.getStatus() instanceof Atrasado){
            this.proximoStatus(new Finalizado(this.voo));
            this.voo.notificarClientes("O Voo "+ this.voo.getCodigo() + " foi finalizado. Obrigado.");
        }else{
            throw new Exception("O voo só pode ser Finalizado se estiver como Confirmado, Mundança de Portão ou Atrasado.");
        }
    };

    public void mudarPortao(String novoPortao) throws Exception{
        if(this.voo.getStatus() instanceof Confirmado || this.voo.getStatus() instanceof Atrasado){
            this.proximoStatus(new MudancaPortao(this.voo));
            this.voo.notificarClientes("O Voo "+ this.voo.getCodigo() + " mudou para o portao: " + novoPortao + ".");
        }else{
            throw new Exception("O voo só pode Mudar de Portão se estiver como Confirmado ou Atrasado.");
        }
    };
    
}