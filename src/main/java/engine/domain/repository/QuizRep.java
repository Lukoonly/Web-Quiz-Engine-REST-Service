package engine.domain.repository;

import engine.domain.entity.Quiz;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuizRep extends CrudRepository<Quiz, Long> {
    Optional<Quiz> findQuizById(long id);
}