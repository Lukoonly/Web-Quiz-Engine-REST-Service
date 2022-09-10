package engine.domain.entity;

import lombok.*;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private String text;
    private String[] options;
    private int[] answer;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}