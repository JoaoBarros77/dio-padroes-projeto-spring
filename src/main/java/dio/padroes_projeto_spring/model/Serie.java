package dio.padroes_projeto_spring.model;

import jakarta.persistence.*;

@Entity
public class Serie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String grauEscolaridade; //Ensino Fundamental ou Medio
    private int serieAluno;

    public String getGrauEscolaridade() {
        return grauEscolaridade;
    }
    public void setGrauEscolaridade(String grauEscolaridade) throws Exception {
        if(grauEscolaridade.equals("Ensino Fundamental")  || grauEscolaridade.equals("Ensino Médio")){
            this.grauEscolaridade = grauEscolaridade;
        }
        throw new IncorrectDataInsertion("O grau de escolaridade deve ser Ensino Fundamental ou Ensino Médio");
    }

    public int getSerieAluno() {
        return serieAluno;
    }
    public void setSerieAluno(int serieAluno) throws Exception {
        if(grauEscolaridade.equals("Ensino Fundamental")){
            if(serieAluno < 1 || serieAluno > 10){
                throw new IncorrectDataInsertion("Série deve estar entre 1 e 9");
            }
        } else {
            if(serieAluno < 1 || serieAluno > 3){
                throw new IncorrectDataInsertion("Série deve estar entre 1 e 3");
            }
        }
        this.serieAluno = serieAluno;
    }
}
