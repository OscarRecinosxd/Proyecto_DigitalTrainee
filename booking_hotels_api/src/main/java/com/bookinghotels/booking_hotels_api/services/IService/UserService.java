package com.bookinghotels.booking_hotels_api.services.IService;

import com.bookinghotels.booking_hotels_api.models.dtos.CreateUserDTO;
import com.bookinghotels.booking_hotels_api.models.dtos.UpdateUserDTO;
import com.bookinghotels.booking_hotels_api.models.dtos.response.HotelChainResponseDTO;
import com.bookinghotels.booking_hotels_api.models.dtos.response.UserResponseDTO;
import com.bookinghotels.booking_hotels_api.models.entities.HotelChain;
import com.bookinghotels.booking_hotels_api.models.entities.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User save(CreateUserDTO newUser);

    User findById(Long id);

    User deleteById(Long id);

    User updateUser(Long id, UpdateUserDTO updateUserDTO);

    UserResponseDTO convertToDTO(User user);

    List<UserResponseDTO> converListToDTOList(List<User> users);
}
