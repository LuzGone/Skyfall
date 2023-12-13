package src.main.java.br.edu.ifpb.skyfall;
import java.time.LocalDateTime;

/**
 * main
 */
public class main {

    public static void main(String[] args) {
        System.out.println("Bem Vindo ao Skyfall");
        //Criação de Aeronaves
        System.out.println("Requisitando Aeronaves...");
        Aeronave boeing767 = new Aeronave("Boeing 767",238);
        Aeronave boeing777 = new Aeronave("Boeing 777",378);
        Aeronave boeing787 = new Aeronave("Boeing 787",420);
        System.out.println(boeing767);
        System.out.println(boeing777);
        System.out.println(boeing787);
        //Criação do Voo
        Voo voo1 = new Voo("JPA", 
        "EUA", 
        "H23", 
        LocalDateTime.of(2023, 12, 29, 21, 30, 0), 
        LocalDateTime.of(2023, 12, 29, 21, 30, 0), 
        LocalDateTime.of(2023, 12, 30, 5, 30, 0), 
        boeing787);
        System.out.println(voo1);
    }
}