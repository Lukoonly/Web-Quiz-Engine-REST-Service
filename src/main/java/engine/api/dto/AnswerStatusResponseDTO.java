package engine.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class AnswerStatusResponseDTO {
    private boolean success;
    private String feedback;
}