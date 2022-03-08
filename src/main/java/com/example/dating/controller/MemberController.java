package com.example.dating.controller;

import com.example.dating.dto.IdelInsertDTO;
import com.example.dating.mapper.IdelMapper;
import com.example.dating.mapper.MemberMapper;
import com.example.dating.domain.Idel;
import com.example.dating.domain.Member;
import com.example.dating.dto.MemberUpsertDTO;
import com.example.dating.service.IdelService;
import com.example.dating.service.MatchService;
import com.example.dating.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {

    @Autowired
    MemberService memberService;

    @Autowired
    IdelService idelService;

    @Autowired
    MatchService matchService;

    @GetMapping
    public List<Member> getMemberList(@RequestParam(name = "randomMember",
            required = false, defaultValue = "false") Boolean isRandomMember) {
        return memberService.findAll();
    }

    @GetMapping("{/id}")
    public Member getMember(@PathVariable("id") int id) {
        return memberService.findById(id);
    }

    @PostMapping
    public Member insertMember(@RequestBody MemberUpsertDTO request) {
        Member member = memberService.saveMember(MemberMapper.INSTANCE.insertRequestToMember(request));

        List<IdelInsertDTO> idels = request.getIdels();

        for(IdelInsertDTO dto : idels) {
            Idel idel = IdelMapper.INSTANCE.insertRequestToIdel(dto);
            idelService.saveIdel(idel);
        }

        return member;
    }

    @PutMapping("/{id}")
    public Member updateMember(@PathVariable("id") int id, @RequestBody MemberUpsertDTO request) {
        Member member = memberService.findById(id);
        MemberMapper.INSTANCE.updateRequestToMember(request, member);

        memberService.saveMember(member);

        for(Idel idel : member.getIdels()) {
            idelService.deleteIdel(idel.getId());
        }

        List<IdelInsertDTO> idels = request.getIdels();

        for(IdelInsertDTO dto : idels) {
            Idel idel = IdelMapper.INSTANCE.insertRequestToIdel(dto);
            idelService.saveIdel(idel);
        }

        return member;
    }

    @DeleteMapping("/{id}")
    public void deleteMember(@PathVariable("id") int id) {
        Member member = memberService.findById(id);
        memberService.deleteMember(member);
    }
}
