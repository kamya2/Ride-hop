package com.alibou.security.Ride.RideDTOs;

import com.alibou.security.Ride.RideStatus;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class RideRequestDTO {
    private Long userId;
    private String fromPlace;
    private String toPlace;
    private Date date;
    private Double price;
    private Integer seats;
    private Date time;
    private RideStatus rideStatus;
}
