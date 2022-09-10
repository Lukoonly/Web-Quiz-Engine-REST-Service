package engine.service;

import engine.api.dto.QuizDTO;
import engine.api.mapper.QuizMapper;
import engine.api.mapper.SolvedQuizMapper;
import engine.domain.entity.Quiz;
import engine.domain.entity.SolvedQuiz;
import engine.domain.entity.User;
import engine.domain.exceptions.ForbiddenException;
import engine.domain.exceptions.NotFoundException;
import engine.domain.repository.PageRep;
import engine.domain.repository.QuizRep;
import engine.domain.repository.SolvedQuizRep;
import engine.security.IAuthenticationFacade;
import engine.security.UserPrincipal;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.*;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@NoArgsConstructor
@Service
public class QuizService {

    private QuizMapper quizMapper;
    private QuizRep quizRep;
    private IAuthenticationFacade authenticationFacade;
    private PageRep pageRep;
    private SolvedQuizRep solvedQuizRep;
    private SolvedQuizMapper solvedQuizMapper;

    public Quiz addAnswer(QuizDTO quizDTO) {
        Quiz quiz = quizMapper.toQuizFromQuizDTO(quizDTO);
        quiz.setUser(getAuthUser());
        return quizRep.save(quiz);
    }

    public Quiz getQuizById(long id) {
        return quizRep.findQuizById(id).orElseThrow(() -> new NotFoundException("Quiz is not found"));
    }

    public boolean isQuizCompleted(long id, int[] answer) {
        Quiz quiz = getQuizById(id);
        boolean isAnswerCorrect = isQuizSolved(quiz.getAnswer(), answer);
        if (isAnswerCorrect) {
            User user = getAuthUser();
            solvedQuizRep.save(solvedQuizMapper.toSolvedQuiz(user.getEmail(), quiz.getId()));
        }
        return isAnswerCorrect;
    }

    private boolean isQuizSolved(int[] answers, int[] usersAnswer) {
        if (answers == null) {
            return usersAnswer.length == 0;
        } else {
            return Arrays.equals(answers, usersAnswer);
        }
    }

    public void deleteQuizBuId(Long id) {
        Quiz quiz = getQuizById(id);
        if (quiz.getUser().getId() != getAuthUser().getId()) {
            throw new ForbiddenException();
        }
        quizRep.delete(quiz);
    }

    private User getAuthUser() {
        UserPrincipal userPrincipal = (UserPrincipal) authenticationFacade.getAuthentication().getPrincipal();
        return userPrincipal.getUser();
    }

    public Page<Quiz> getAllQuizzes(int pageNumber, int pageSize, String sortBy) {
        return pageRep.findAll(PageRequest.of(pageNumber, pageSize, Sort.by(sortBy)));
    }

    public Page<SolvedQuiz> getSolvedQuizzes(int page, int pageSize) {
        User user = getAuthUser();
        Pageable paging = PageRequest.of(page, pageSize, Sort.by("completedAt").descending());
        return solvedQuizRep.findAll(user.getEmail(), paging);
    }
}