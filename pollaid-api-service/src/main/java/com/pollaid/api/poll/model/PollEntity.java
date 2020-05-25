package com.pollaid.api.poll.model;

import com.pollaid.api.answer.model.AnswerEntity;
import com.pollaid.api.option.model.OptionEntity;
import com.pollaid.api.poll.enums.PollCategory;
import com.pollaid.api.poll.enums.PollStatus;
import com.pollaid.api.poll.enums.PollType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity (name = "Poll")
@Table(name = "Poll")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PollEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //TODO UserId: Long [Unique]

    @NotEmpty
    private String question;

    @Builder.Default
    private PollStatus status = PollStatus.DRAFT;

    private PollType type;

    private PollCategory category;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy="poll", fetch = FetchType.LAZY)
    List<OptionEntity> options;

    @OneToMany(mappedBy="poll")
    List<AnswerEntity> answers;

}
