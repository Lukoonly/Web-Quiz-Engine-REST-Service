package engine.api.mapper;

import engine.api.dto.PageResponseDTO;
import engine.domain.entity.Quiz;
import engine.domain.entity.SolvedQuiz;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@NoArgsConstructor
@Component
public class PageMapper {

    private QuizMapper quizMapper;

    public PageResponseDTO toPageResponseDTO(Page<SolvedQuiz> page) {
        return PageResponseDTO.builder()
                .content(page.getContent().stream()
                        .map(quiz -> quizMapper.toSolvedQuizDTOFromSolvedQuiz(quiz))
                        .collect(Collectors.toList()))
                .totalPages(page.getTotalPages())
                .totalElements(page.getSize())
                .build();
    }

    public PageResponseDTO pageResponseDTOFromPage(Page<Quiz> page) {
        return PageResponseDTO.builder()
                .content(page.getContent().stream()
                        .map(quiz -> quizMapper.toQuizResponseDTOFromQuiz(quiz))
                        .collect(Collectors.toList()))
                .totalPages(page.getTotalPages())
                .totalElements(page.getSize())
                .build();
    }
}
