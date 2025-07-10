package com.voting.voting_app.service;

import com.voting.voting_app.model.OptionVote;
import com.voting.voting_app.model.Poll;
import com.voting.voting_app.repository.PollRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PollService {

    private final PollRepository pollRepository;

    public PollService(PollRepository pollRepository) {
        this.pollRepository = pollRepository;
    }


    public Poll createPoll(Poll poll) {
        return pollRepository.save(poll);
    }

    public List<Poll> getAllPolls() {
        return pollRepository.findAll();
    }

    public Optional<Poll> getPollByID(long id) {
        return pollRepository.findById(id);
    }

    public void vote(Long pollId, int optionIndex) {
        // ge the poll from DB
        Poll poll = pollRepository.findById(pollId)
                .orElseThrow(() -> new RuntimeException("Poll not found"));

        // get all options
        List<OptionVote> options = poll.getOptions();

        // if index is not valid. throw the error
        if(optionIndex < 0 || optionIndex >= options.size()) {
            throw new IllegalArgumentException("Invalid option index");
        }

        // get selected option
        OptionVote selectedOption = options.get(optionIndex);

        // Increment vote for selected option
        selectedOption.setVoteCount(selectedOption.getVoteCount() + 1);

        // save incremented vote option into the database
        pollRepository.save(poll);
    }
}
