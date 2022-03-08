package com.example.dating.service;

import com.example.dating.domain.Match;
import com.example.dating.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {

    @Autowired
    MatchRepository matchRepository;

    public List<Match> findAllByToMember(int memberId) {
        return matchRepository.findAllByToMemberId(memberId);
    }

    public List<Match> findAllByFromMember(int memberId) {
        return matchRepository.findAllByFromMemberId(memberId);
    }

    public Match saveMatch(Match match) {
        return matchRepository.save(match);
    }
}
