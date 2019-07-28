package api.repository;

import api.model.forDB.Character;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CharRepository extends CrudRepository <Character, Integer>{

  @Query (value = "SELECT c FROM Character c WHERE c.name LIKE %:keyword%")
  List<Character> findCharByKeyword(@Param("keyword") String keyword);


  @Query ( value = "SELECT * FROM Character c  ORDER BY random() LIMIT 1", nativeQuery = true)
  Character getRandomChar();


}




