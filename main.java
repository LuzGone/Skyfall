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
        //
    }
}