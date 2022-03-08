package com.example.dating.dto;

import com.example.dating.domain.Idel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class IdelInsertDTO {

    private Idel.Type type;

    private int rangeStart;

    private int rangeEnd;
}
