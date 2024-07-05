package dio.padroes_projeto_spring.service;

import dio.padroes_projeto_spring.model.Estudante;

import java.util.Optional;

public interface EstudanteService {
    Iterable<Estudante> buscarTodos();
    Optional<Estudante> buscarPorId(int id);
    void inserirEstudante(Estudante estudante);
    void atualizarEstudante(int id, Estudante estudante);
    void removerEstudante(int id);
}
