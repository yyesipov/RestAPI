package hello;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CharRepository extends CrudRepository <Character, Integer>{


    /*@Query(value = "SELECT * FROM Character c WHERE c.name  LIKE  '% ? %' ", nativeQuery = true)
    List<Character> findCharByKeyword(String keyword);*/

    @Query(value = "SELECT * FROM Character c WHERE charindex(' ? ', name)> 0", nativeQuery = true)
    List<Character> findCharByKeyword(String keyword);


  @Query ( value = "SELECT * FROM Character c  ORDER BY random() LIMIT 1", nativeQuery = true)
  Character getRandomChar();
}




