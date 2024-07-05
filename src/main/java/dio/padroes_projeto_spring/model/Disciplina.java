package dio.padroes_projeto_spring.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
public class Disciplina {

    final private List<String> DISCIPLINAS_DE_TODOS = Arrays.asList("Língua Portuguesa", "Artes", "Língua Inglesa", "Educação Física", "Matemática", "Geografia", "História");
    final private List<String> DISCIPLINAS_FUNDAMENTAL = List.of("Ciências");
    final private List<String> DISCIPLINAS_MEDIO = Arrays.asList("Sociologia", "Filosofia", "Biólogia", "Física", "Química");

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String disciplina;
    private float nota;
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

}