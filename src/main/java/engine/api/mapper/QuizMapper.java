package engine.api.mapper;

import engine.api.dto.QuizDTO;
import engine.api.dto.QuizResponseDTO;
import engine.api.dto.SolvedQuizDTO;
import engine.domain.entity.Quiz;
import engine.domain.entity.SolvedQuiz;
import org.springframework.stereotype.Component;

@Component
public class QuizMapper {

    public Quiz toQuizFromQuizDTO(QuizDTO quizDTO) {
        return Quiz.builder()
                .answer(quizDTO.getAnswer())
                .options(quizDTO.getOptions())
                .text(quizDTO.getText())
                .title(quizDTO.getTitle())
                .build();
    }

    public QuizResponseDTO toQuizResponseDTOFromQuiz(Quiz quiz) {
        return QuizResponseDTO.builder()
                .options(quiz.getOptions())
                .text(quiz.getText())
                .title(quiz.getTitle())
                .id(quiz.getId())
                .build();
    }

    public SolvedQuizDTO toSolvedQuizDTOFromSolvedQuiz(SolvedQuiz solvedQuiz) {
        return SolvedQuizDTO.builder()
                .completedAt(solvedQuiz.getCompletedAt())
                .id(solvedQuiz.getQuizId())
                .build();
    }
}