package com.pollaid.api.option.model;

import com.pollaid.api.optionAnswer.model.OptionAnswerEntity;
import com.pollaid.api.poll.model.PollEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity(name = "Option")
@Table(name = "Option")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OptionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "poll_id", nullable = false)
    @ToString.Exclude
    private PollEntity poll;

    @NotEmpty
    private String description;

    @OneToMany(mappedBy="option")
    private List<OptionAnswerEntity> optionAnswers;

}

