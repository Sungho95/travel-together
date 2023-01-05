package com.sungho.traveltogether.domain.member.entity;

import com.sungho.traveltogether.domain.GenderType;
import com.sungho.traveltogether.domain.party.PartyMember;
import com.sungho.traveltogether.global.entity.BaseTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false)
    private String name;

    @Column(nullable = false, updatable = false, unique = true)
    private String email;

    @Column(nullable = false, length = 100)
    private String password;

    @Column(length = 13, nullable = false, unique = true)
    private String phone;

    @Column(nullable = false)
    private LocalDateTime dateOfBirth;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private GenderType genderType;

    @ManyToOne
    @JoinColumn(name = "member_profile_id")
    private MemberProfile profile;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<PartyMember> partyMembers = new ArrayList<>();

}
