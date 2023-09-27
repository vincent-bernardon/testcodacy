package um.fds.agl.ter23.repositories;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import um.fds.agl.ter23.entities.TERManager;

@RepositoryRestResource(exported = false)
public interface TERManagerRepository extends UserBaseRepository<TERManager> {

    <S extends TERManager> S save(S manager);

    public TERManager findByLastName(String lastName);

    Iterable<TERManager> findAll();

}