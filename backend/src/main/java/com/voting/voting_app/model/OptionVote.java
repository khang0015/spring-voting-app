package com.voting.voting_app.model;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Embeddable
public class OptionVote {
    private String voteOption;
    private Long voteCount = 0L;

    public String getVoteOption() {
        return voteOption;
    }

    public Long getVoteCount() {
        return voteCount;
    }

    public void setVoteOption(String voteOption) {
        this.voteOption = voteOption;
    }

    public void setVoteCount(Long voteCount) {
        this.voteCount = voteCount;
    }
}
