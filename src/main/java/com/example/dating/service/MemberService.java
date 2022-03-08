package com.example.dating.service;

import com.example.dating.domain.Member;
import com.example.dating.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class MemberService {

    @Autowired
    MemberRepository memberRepository;

    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    public Member findById(int id) {
        return memberRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public Member saveMember(Member member) {
        return memberRepository.save(member);
    }

    public void deleteMember(Member member) {
        memberRepository.delete(member);
    }
}
