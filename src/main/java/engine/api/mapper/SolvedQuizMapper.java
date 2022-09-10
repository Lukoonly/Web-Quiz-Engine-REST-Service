package engine.api.mapper;

import engine.domain.entity.SolvedQuiz;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class SolvedQuizMapper {
    public SolvedQuiz toSolvedQuiz(String email, long quizId){
       return SolvedQuiz.builder()
                .quizId(quizId)
                .userEmail(email)
                .completedAt(LocalDateTime.now())
                .build();
    }
}
