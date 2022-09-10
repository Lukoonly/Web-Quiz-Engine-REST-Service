package engine.domain.repository;

import engine.domain.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRep extends CrudRepository<User, Long> {

    Optional<User> findUserByEmail(String email);

}
