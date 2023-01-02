package com.sungho.traveltogether.domain.party;

import com.sungho.traveltogether.global.entity.Address;
import com.sungho.traveltogether.global.entity.BaseTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Party extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Embedded
    private Address travelAddress;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "targetAddress", column = @Column(name = "meeting_address")),
            @AttributeOverride(name = "detailAddress", column = @Column(name = "meeting_detail_address")),
            @AttributeOverride(name = "latitude", column = @Column(name = "meeting_latitude")),
            @AttributeOverride(name = "longitude", column = @Column(name = "meeting_longitude")),
    })
    private Address meetingAddress;

    private LocalDateTime travelDate;

    @OneToMany(mappedBy = "party", cascade = CascadeType.ALL)
    private List<PartyMember> partyMembers = new ArrayList<>();

}
