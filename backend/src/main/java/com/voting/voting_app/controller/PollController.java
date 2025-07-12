package com.voting.voting_app.controller;

import com.voting.voting_app.model.Poll;
import com.voting.voting_app.request.Vote;
import com.voting.voting_app.service.PollService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/polls")
@CrossOrigin(origins = "http://localhost:4200/")
public class PollController {

    private final PollService pollService;

    public PollController(PollService pollService) {
        this.pollService = pollService;
    }

    @PostMapping
    public Poll createPoll(@RequestBody Poll poll){
//        System.out.println(poll.getQuestion());
//        System.out.println(poll.getOptions());
//        System.out.println(poll.getVotes());
        return pollService.createPoll(poll);
    }

    @GetMapping
    public List<Poll> getAllPolls() {
        return pollService.getAllPolls();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Poll> getPoll(@PathVariable long id) {
        return pollService.getPollByID(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //POST
    //VOTE
    //-> Service
    @PostMapping("/vote")
    public void vote(@RequestBody Vote vote){
        pollService.vote(vote.getPollId(), vote.getOptionIndex());
    }
}
