package dio.padroes_projeto_spring.repository;

import dio.padroes_projeto_spring.model.Disciplina;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplinaRepository  extends CrudRepository<Disciplina, Long> {
}
