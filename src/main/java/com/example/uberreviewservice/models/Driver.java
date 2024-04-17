package com.example.uberreviewservice.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Driver extends BaseModel{

    private String name;

    @Column(nullable = false , unique = true)
    private String licenseNumber ;

    //1:m  , driver : booking
    @OneToMany(mappedBy = "driver",fetch = FetchType.LAZY)
    private List<Booking> bookings = new ArrayList<>();


}
