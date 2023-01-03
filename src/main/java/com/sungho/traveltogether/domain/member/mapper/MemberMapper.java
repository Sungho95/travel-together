package com.sungho.traveltogether.domain.member.mapper;

import com.sungho.traveltogether.domain.member.controller.dto.MemberJoinDto;
import com.sungho.traveltogether.domain.member.controller.dto.MemberLoginDto;
import com.sungho.traveltogether.domain.member.entity.Member;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MemberMapper {

    Member memberJoinDtoToMember(MemberJoinDto requestBody);
    Member memberLoginDtoToMember(MemberLoginDto requestBody);

}
