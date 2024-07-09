package dio.padroes_projeto_spring.service;

import dio.padroes_projeto_spring.model.Disciplina;
import dio.padroes_projeto_spring.model.Estudante;

import java.util.Optional;

public interface EstudanteService {
    Iterable<Estudante> buscarTodos();
    Optional<Estudante> buscarPorId(Long id);
    void inserirEstudante(Estudante estudante);
    void atualizarEnderecoEstudante(Long id, Estudante estudante);
    void removerEstudante(Long id);
}
