package com.sungho.traveltogether.global.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private String targetAddress;
    private String detailAddress;
//    private Double latitude;
//    private Double longitude;
}
