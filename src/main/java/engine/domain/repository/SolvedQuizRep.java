package engine.domain.repository;

import engine.domain.entity.SolvedQuiz;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SolvedQuizRep extends PagingAndSortingRepository<SolvedQuiz, Long> {
    @Query(value = "SELECT c FROM SolvedQuiz c WHERE c.userEmail = :userEmail")
    Page<SolvedQuiz> findAll(@Param("userEmail") String userEmail, Pageable pageable);
}
