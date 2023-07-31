package com.alibou.security.Ride;

import com.alibou.security.Ride.RideDTOs.RideRequestDTO;
import com.alibou.security.Ride.RideDTOs.RideResponseDTO;
import com.alibou.security.auth.AuthenticationResponse;
import com.alibou.security.auth.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/ride")
public class RideController {

    private RideService rideService;
    @Autowired
    public RideController(RideService rideService){
        this.rideService = rideService;
    }

    @RequestMapping(value = "/createRide", method = RequestMethod.POST)
    private ResponseEntity<RideResponseDTO> create(
            @RequestBody RideRequestDTO request
    ) {
        return ResponseEntity.ok(rideService.createRide(request));
    }

    @PutMapping("/bookRide/{id}")
    private ResponseEntity<RideResponseDTO> book(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(rideService.bookRide(id));
    }

    @PutMapping("/updateRide/{id}")
    private ResponseEntity<RideResponseDTO> update(
            @RequestBody RideRequestDTO request,
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(rideService.updateRide(id, request));
    }

}
