package engine.api.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class QuizDTO {
    @NotEmpty
    @NotBlank
    @NotNull
    private String title;
    @NotEmpty
    @NotBlank
    @NotNull
    private String text;
    @NotNull
    @Size(min = 2)
    private String[] options;
    private int[] answer;
}
