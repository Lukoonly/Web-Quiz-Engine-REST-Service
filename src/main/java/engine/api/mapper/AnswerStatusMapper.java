package engine.api.mapper;

import engine.api.dto.AnswerStatusResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class AnswerStatusMapper {
    public AnswerStatusResponseDTO toAnswerStatusResponseDTO(boolean isQuizSolved) {
        return isQuizSolved ?
                new AnswerStatusResponseDTO(true, "Congratulations, you're right!")
                : new AnswerStatusResponseDTO(false, "Wrong answer! Please, try again.");
    }
}
