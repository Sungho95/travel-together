package com.sungho.traveltogether.domain.party;

import com.sungho.traveltogether.domain.member.entity.Member;
import com.sungho.traveltogether.global.entity.BaseTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;


@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PartyMember extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "party_id")
    private Party party;
}
