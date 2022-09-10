package engine.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class QuizResponseDTO implements PageDTO {
    private long id;
    private String title;
    private String text;
    private String[] options;
}