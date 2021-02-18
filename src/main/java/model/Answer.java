package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "answer")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answers_id")
    private int answersId;

    @Column(name = "answer")
    private String answer;

    @Deprecated
    @Column(name = "correct_answer")
    private boolean correctAnswer;

    @ManyToOne
    @JoinColumn(name = "questions_id")
    private Question questions;
}
