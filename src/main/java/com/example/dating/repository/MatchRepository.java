package com.example.dating.repository;

import com.example.dating.domain.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchRepository extends JpaRepository<Match, Integer> {

    List<Match> findAllByToMember(Integer toMemberId);

    List<Match> findAllByFromMember(Integer fromMemberId);
}
