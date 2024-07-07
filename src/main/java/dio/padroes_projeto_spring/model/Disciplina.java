package dio.padroes_projeto_spring.model;

import jakarta.persistence.*;

@Entity
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String disciplina;
    private float nota;

    public Disciplina() {
    }

    public Disciplina(String disciplina, float nota) {
        this.disciplina = disciplina;
        this.nota = nota;
    }

    public String getDisciplina() {
        return disciplina;
    }
    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }
    public float getNota() {
        return nota;
    }
    public void setNota(float nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Disciplina{" +
                "Disciplina:'" + disciplina + '\'' +
                ", Nota:" + nota +
                '}';
    }
}