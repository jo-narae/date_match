package com.example.dating.service;

import com.example.dating.domain.Chat;
import com.example.dating.repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatService {

    @Autowired
    ChatRepository chatRepository;

    public List<Chat> findAllByMatch(int matchId) {
        return chatRepository.findAllByMatchId(matchId);
    }

    public Chat saveChat(Chat chat) {
        return chatRepository.save(chat);
    }

    public void deleteChat(int chatId) {
        chatRepository.deleteById(chatId);
    }
}
