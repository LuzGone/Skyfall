package src.main.java.br.edu.ifpb.skyfall.Decorators;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import src.main.java.br.edu.ifpb.skyfall.Voo;

//[Voo];[Status];[Mensagem]
public class GerenciadorLogger implements Logger{
    private Voo voo;

    public GerenciadorLogger(Voo voo){
        this.voo = voo;
    }

    public void registrarLog(String mensagem){
        File documento = new File("../", "Log.txt");
        try{
            documento.createNewFile();
            FileWriter fileWriter = new FileWriter(documento,true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println("[Voo:"+this.voo.getCodigo()+"]"+ 
                                "["+this.voo.getStatus()+"]"+
                                "["+mensagem+"]"); 
            printWriter.flush(); 
            printWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
