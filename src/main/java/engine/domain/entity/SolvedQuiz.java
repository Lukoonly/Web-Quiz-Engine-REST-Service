package engine.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class SolvedQuiz {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long quizId;
    private String userEmail;
    private LocalDateTime completedAt;
}
