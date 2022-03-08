package com.example.dating.repository;

import com.example.dating.domain.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Integer> {

    List<Chat> findAllByMatch(Integer matchId);
}
