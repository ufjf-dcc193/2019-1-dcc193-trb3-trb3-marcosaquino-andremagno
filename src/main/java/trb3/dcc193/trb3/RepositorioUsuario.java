package trb3.dcc193.trb3;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface RepositorioUsuario extends CrudRepository<Usuario, Long>{



}