package com.alibou.security.Ride;

import com.alibou.security.Ride.RideDTOs.RideRequestDTO;
import com.alibou.security.Ride.RideDTOs.RideResponseDTO;
import com.alibou.security.user.User;
import com.alibou.security.user.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Transactional
@Service
public class RideServiceImpl implements RideService {

    private RideRepository rideRepository;
    private UserRepository userRepository;

    public RideServiceImpl(RideRepository rideRepository,
                           UserRepository userRepository){
        this.rideRepository = rideRepository;
        this.userRepository = userRepository;
    }


    @Override
    public RideResponseDTO createRide(RideRequestDTO rideRequestDTO) {
        Optional<User> optionalUser = userRepository.findById(rideRequestDTO.getUserId());
        if (optionalUser.isPresent()){
            Ride newRide = new Ride();
            newRide.setRideStatus(RideStatus.YET_TO_START);
            newRide.setDate(rideRequestDTO.getDate());
            newRide.setPrice(rideRequestDTO.getPrice());
            newRide.setSeats(rideRequestDTO.getSeats());
            newRide.setFromPlace(rideRequestDTO.getFromPlace());
            newRide.setToPlace(rideRequestDTO.getToPlace());
            newRide.setTime(rideRequestDTO.getTime());
            newRide.setRideStatus(RideStatus.YET_TO_START);
            newRide.setUser(optionalUser.get());

            Ride persistedRide = rideRepository.save(newRide);

            RideResponseDTO response = new RideResponseDTO();
            response.setId(persistedRide.getId());
            response.setDate(persistedRide.getDate());
            response.setTime(persistedRide.getTime());
            response.setSeats(persistedRide.getSeats());
            response.setFromPlace(persistedRide.getFromPlace());
            response.setToPlace(persistedRide.getToPlace());
            response.setPrice(persistedRide.getPrice());
            response.setRideStatus(persistedRide.getRideStatus());
//            response.setUser(persistedRide.getUser());
            response.setMessage("Ride created");
            return response;
        } else {
            return null;
        }
    }

    @Override
    public RideResponseDTO bookRide(Long id) {

        Optional<Ride> optionalRide = rideRepository.findById(id);
        if (optionalRide.isPresent()){
            Ride ride = optionalRide.get();
            ride.setRideStatus(RideStatus.IN_PROGRESS);
            Ride persistedRide = rideRepository.save(ride);
            RideResponseDTO response = new RideResponseDTO();
            response.setId(persistedRide.getId());
            response.setDate(persistedRide.getDate());
            response.setTime(persistedRide.getTime());
            response.setSeats(persistedRide.getSeats());
            response.setFromPlace(persistedRide.getFromPlace());
            response.setToPlace(persistedRide.getToPlace());
            response.setPrice(persistedRide.getPrice());
            response.setRideStatus(persistedRide.getRideStatus());
            response.setMessage("Ride Booked");
            return response;
        } else {
            return null;
        }
    }

    @Override
    public RideResponseDTO updateRide(Long id, RideRequestDTO updateDTO) {
        Optional<Ride> optionalRide = rideRepository.findById(id);
        if (optionalRide.isPresent()){
            Ride ride = optionalRide.get();

            ride.setTime(updateDTO.getTime());
            ride.setDate(updateDTO.getDate());
            ride.setSeats(updateDTO.getSeats());
            ride.setFromPlace(updateDTO.getFromPlace());
            ride.setToPlace(updateDTO.getToPlace());
            ride.setPrice(updateDTO.getPrice());

            RideResponseDTO response = new RideResponseDTO();
            response.setId(ride.getId());
            response.setDate(ride.getDate());
            response.setTime(ride.getTime());
            response.setSeats(ride.getSeats());
            response.setFromPlace(ride.getFromPlace());
            response.setToPlace(ride.getToPlace());
            response.setPrice(ride.getPrice());
            response.setRideStatus(ride.getRideStatus());
            response.setMessage("Ride Updated");

            return response;
        } else {
            return null;
        }
    }
}
