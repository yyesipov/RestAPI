package api.repository;

import api.model.forDB.Location;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LocRepository extends CrudRepository<Location, Integer>{

    @Query(value = "SELECT l from Location l where l.name like %:name%")
    Location isExistLocation(@Param("name") String name);
}
