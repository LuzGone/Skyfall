package src.main.java.br.edu.ifpb.skyfall;
import java.time.LocalDateTime;

import src.main.java.br.edu.ifpb.skyfall.Strategy.EmailStrategy;
import src.main.java.br.edu.ifpb.skyfall.Strategy.SmsStrategy;

/**
 * main
 */
public class main {

    public static void main(String[] args) {
        System.out.println("Bem Vindo ao Skyfall");
        System.out.println("===========================");
        //Criação de Aeronaves
        System.out.println("Requisitando Aeronaves...");
        Aeronave boeing767 = new Aeronave("Boeing 767",238);
        Aeronave boeing777 = new Aeronave("Boeing 777",378);
        Aeronave boeing787 = new Aeronave("Boeing 787",420);
        System.out.println(boeing767);
        System.out.println(boeing777);
        System.out.println(boeing787);
        System.out.println("===========================");
        //Criação do Voo
        System.out.println("Criando Voo...");
        Voo voo1 = new Voo("JPA", 
        "EUA", 
        "H23", 
        LocalDateTime.of(2023, 12, 29, 21, 30, 0), 
        LocalDateTime.of(2023, 12, 29, 21, 30, 0), 
        LocalDateTime.of(2023, 12, 30, 5, 30, 0), 
        boeing787);
        System.out.println(voo1);
        System.out.println("===========================");
        //Criação de Clientes
        System.out.println("Criando Clientes...");
        Passageiro cliente1 = new Passageiro("Luiz Gonzaga", "123.456.789-10");
        cliente1.definirNotificador(new EmailStrategy());
        Passageiro cliente2 = new Passageiro("Louise Fernandes", "987.654.321-98");
        cliente2.definirNotificador(new SmsStrategy());
        System.out.println(cliente1);
        System.out.println("-------------------");
        System.out.println(cliente2);
        System.out.println("===========================");
        //Cadastrando Clientes no Voo
        System.out.println("Cadastrando Clientes no Voo...");
        try{
            System.out.println(voo1.cadastrarCliente(cliente1));
            System.out.println(voo1.cadastrarCliente(cliente2));
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println("===========================");
        //Confirmando Voo
        System.out.println("Confirmando Voo...");
        try{
            voo1.confirmarVoo();
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println("===========================");
        //Atrasando Voo
        System.out.println("Atrasando Voo...");
        try{
            voo1.atrasarVoo(45L);
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println("===========================");
        //Mudando Portão do Voo
        System.out.println("Mudando Portão do Voo...");
        try{
            voo1.mudarPortao("F32");
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println("===========================");
        //Finzalizando Voo
        System.out.println("Finalizando Voo...");
        try{
            voo1.finalizarVoo();
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println("===========================");
        System.out.println("Status Final do Voo...");
        System.out.println(voo1);
        System.out.println("===========================");
    }
}