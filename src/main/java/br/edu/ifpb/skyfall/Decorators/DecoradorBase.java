package src.main.java.br.edu.ifpb.skyfall.Decorators;
public class DecoradorBase implements Logger {
    
    protected Logger logger;

    public DecoradorBase(Logger logger){
        this.logger = logger;
    }

    @Override
    public void registrarLog(String mensagem){
        this.logger.registrarLog(mensagem);
    }
}
