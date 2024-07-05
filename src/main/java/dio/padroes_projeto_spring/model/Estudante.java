package dio.padroes_projeto_spring.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Estudante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column (length = 100, nullable = false)
    private String nome;
    @Column (nullable = false)
    private int idade;
    @ManyToOne
    @JoinColumn (nullable = false)
    private Endereco endereco;
    @ManyToOne
    @JoinColumn (nullable = false)
    private Serie serie;
    @Column (nullable = false)
    private String numeroCelular;
    @Column (length = 100, nullable = false)
    private String email;

    @ManyToOne
    @JoinColumn (nullable = false)
    private Disciplina disciplina;
    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public Serie getSerie() {
        return serie;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public String getEmail() {
        return email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
}
