package com.sungho.traveltogether.domain.member.entity;

import com.sungho.traveltogether.global.entity.BaseTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberProfile extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String image;

    @Column(nullable = false, length = 20)
    private String nickname;

    @Column(length = 30)
    private String location;

    private String aboutMe;

}
