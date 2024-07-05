package dio.padroes_projeto_spring.model;

public class IncorrectDataInsertion extends Exception{
    public IncorrectDataInsertion(String message){
        super(message);
        System.out.println("Valor digitado inválido");

    }
}
