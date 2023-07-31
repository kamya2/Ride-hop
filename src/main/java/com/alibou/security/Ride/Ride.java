package com.alibou.security.Ride;

import com.alibou.security.user.User;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name = "t_ride")
public class Ride {
    @Id
    @GeneratedValue
    private Long id;
    private String fromPlace;
    private String toPlace;
    @DateTimeFormat(pattern = "MM-dd-yyyy")
    private Date date;
    private Double price;
    private Integer seats;
    @DateTimeFormat(pattern = "HH:mm:ss")
    private Date time;
    @Enumerated(EnumType.STRING)
    private RideStatus rideStatus;

    @ManyToOne(fetch = FetchType.LAZY,
    cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;
}
