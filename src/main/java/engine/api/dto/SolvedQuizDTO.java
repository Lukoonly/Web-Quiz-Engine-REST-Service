package engine.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Builder
public class SolvedQuizDTO implements PageDTO {
    private long id;
    private LocalDateTime completedAt;
}
