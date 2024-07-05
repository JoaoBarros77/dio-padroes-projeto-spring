package dio.padroes_projeto_spring.repository;

import dio.padroes_projeto_spring.model.Serie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SerieRepository extends CrudRepository<Serie, Integer> {
}
