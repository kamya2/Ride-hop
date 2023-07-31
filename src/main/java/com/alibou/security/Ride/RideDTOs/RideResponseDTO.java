package com.alibou.security.Ride.RideDTOs;

import com.alibou.security.Ride.RideStatus;
import com.alibou.security.user.User;
import lombok.Data;

import java.util.Date;

@Data
public class RideResponseDTO {
    private Long id;
    private String fromPlace;
    private String toPlace;
    private Date date;
    private Double price;
    private Integer seats;
    private Date time;
    private RideStatus rideStatus;
    private User user;
    private String message;
}
