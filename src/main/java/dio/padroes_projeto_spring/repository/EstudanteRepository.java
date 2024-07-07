package dio.padroes_projeto_spring.repository;

import dio.padroes_projeto_spring.model.Estudante;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudanteRepository extends CrudRepository<Estudante, Long> {
}
