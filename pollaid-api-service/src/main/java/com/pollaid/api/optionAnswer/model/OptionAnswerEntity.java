package com.pollaid.api.optionAnswer.model;

import com.pollaid.api.answer.model.AnswerEntity;
import com.pollaid.api.option.model.OptionEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity (name = "OptionAnswer")
@Table(name = "OptionAnswer")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OptionAnswerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "option_id", nullable = false)
    @ToString.Exclude
    private OptionEntity option;

    @ManyToOne
    @JoinColumn(name = "answer_id", nullable = false)
    @ToString.Exclude
    private AnswerEntity answer;

    @Transient
    private boolean checked;
}
