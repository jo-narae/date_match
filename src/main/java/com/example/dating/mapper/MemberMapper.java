package com.example.dating.mapper;

import com.example.dating.domain.Member;
import com.example.dating.dto.MemberUpsertDTO;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MemberMapper {

    MemberMapper INSTANCE = Mappers.getMapper(MemberMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "idels", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
            nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    Member insertRequestToMember (MemberUpsertDTO memberInsertRequest);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "idels", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
            nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    void updateRequestToMember (MemberUpsertDTO memberInsertRequest, @MappingTarget Member member);
}
