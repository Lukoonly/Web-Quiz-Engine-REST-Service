package engine.domain.repository;

import engine.domain.entity.Quiz;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PageRep extends PagingAndSortingRepository<Quiz, Long> {
}
