package com.voting.voting_app.request;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Data
@NoArgsConstructor
public class Vote {
    private Long pollId;
    private int optionIndex;

    public void setPollId(Long pollId) {
        this.pollId = pollId;
    }

    public void setOptionIndex(int optionIndex) {
        this.optionIndex = optionIndex;
    }

    public Long getPollId() {
        return pollId;
    }

    public int getOptionIndex() {
        return optionIndex;
    }
}
