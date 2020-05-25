package com.pollaid.api.answer.model;

import com.pollaid.api.optionAnswer.model.OptionAnswerEntity;
import com.pollaid.api.poll.model.PollEntity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity (name = "Answer")
@Table(name = "Answer")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AnswerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "poll_id", nullable = false)
    @ToString.Exclude
    private PollEntity poll;

    @OneToMany(mappedBy="answer")
    List<OptionAnswerEntity> optionAnswers;
}


