package dio.padroes_projeto_spring.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
public class Estudante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (length = 100, nullable = false)
    private String nome;
    @Column (nullable = false)
    private int idade;
    @ManyToOne
    @JoinColumn (nullable = false)
    private Endereco endereco;
    @Column (nullable = false)
    private String numeroCelular;
    @Column (length = 100, nullable = false)
    private String email;

    @ElementCollection
    @CollectionTable(name = "grade_curricular_estudante", joinColumns = @JoinColumn(name = "estudante_id"))
    private List<Disciplina> gradeCurricular;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Disciplina> getGradeCurricular() {
        return gradeCurricular;
    }

    public void setGradeCurricular(List<Disciplina> gradeCurricular) {
        this.gradeCurricular = gradeCurricular;
    }

}
