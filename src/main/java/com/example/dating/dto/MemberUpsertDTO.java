package com.example.dating.dto;

import com.example.dating.domain.Idel;
import com.example.dating.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class MemberUpsertDTO {

    private String name;

    private String phone;

    private Member.Gender gender;

    private int age;

    private int tall;

    private String img;

    private String description;

    private List<IdelInsertDTO> idels;
}
