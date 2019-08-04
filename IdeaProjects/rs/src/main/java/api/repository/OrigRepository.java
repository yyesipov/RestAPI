package api.repository;

import api.model.forDB.Origin;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrigRepository extends CrudRepository<Origin, Integer>{

    @Query(value = "SELECT o FROM Origin o WHERE o.name like %:name%")
    Origin isExistOrigin(@Param("name") String name);
}
