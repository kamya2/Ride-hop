package com.alibou.security.Ride;

import com.alibou.security.Ride.RideDTOs.RideRequestDTO;
import com.alibou.security.Ride.RideDTOs.RideResponseDTO;

public interface RideService {
    RideResponseDTO createRide(RideRequestDTO rideRequestDTO);
    RideResponseDTO bookRide(Long id);
    RideResponseDTO updateRide(Long id, RideRequestDTO rideRequestDTO);
}
