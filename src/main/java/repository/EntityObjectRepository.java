package repository;

import model.EntityObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntityObjectRepository extends JpaRepository<EntityObject, Long> {
}
