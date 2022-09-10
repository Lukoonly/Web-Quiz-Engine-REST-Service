package engine.api.controller;


import engine.api.dto.*;
import engine.api.mapper.AnswerStatusMapper;
import engine.api.mapper.PageMapper;
import engine.api.mapper.QuizMapper;
import engine.service.QuizService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@NoArgsConstructor
@RestController
public class QuizController {

    private AnswerStatusMapper answerStatusMapper;
    private QuizMapper quizMapper;
    private QuizService quizService;
    private PageMapper pageMapper;

    @PostMapping("/api/quizzes")
    public QuizResponseDTO addQuiz(@Valid @RequestBody QuizDTO quizDTO) {
        return quizMapper.toQuizResponseDTOFromQuiz(quizService.addAnswer(quizDTO));
    }

    @GetMapping("/api/quizzes/{id}")
    public QuizResponseDTO getQuizById(@PathVariable long id) {
        return quizMapper.toQuizResponseDTOFromQuiz(quizService.getQuizById(id));
    }

    @GetMapping(value = "/api/quizzes")
    public PageResponseDTO getAllQuizzes(
            @Min(0) @RequestParam(defaultValue = "0") int page,
            @Min(10) @Max(30) @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "id") String sortBy) {
        return pageMapper.pageResponseDTOFromPage(quizService.getAllQuizzes(page, pageSize, sortBy));
    }

    @PostMapping("/api/quizzes/{id}/solve")
    public AnswerStatusResponseDTO solvedQuiz(@PathVariable long id, @RequestBody AnswerDTO answerDTO) {
        return answerStatusMapper.toAnswerStatusResponseDTO(quizService.isQuizCompleted(id, answerDTO.getAnswer()));
    }

    @DeleteMapping("/api/quizzes/{id}")
    public ResponseEntity<String> deleteQuizById(@PathVariable long id) {
        quizService.deleteQuizBuId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/api/quizzes/completed")
    public PageResponseDTO getSolvedQuizzes(@Min(0) @RequestParam(defaultValue = "0") int page,
                                            @Min(10) @Max(30) @RequestParam(defaultValue = "10") int pageSize) {
        return pageMapper.toPageResponseDTO(quizService.getSolvedQuizzes(page, pageSize));
    }
}