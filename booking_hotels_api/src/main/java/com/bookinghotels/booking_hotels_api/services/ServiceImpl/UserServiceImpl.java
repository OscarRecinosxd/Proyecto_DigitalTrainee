package com.bookinghotels.booking_hotels_api.services.ServiceImpl;

import com.bookinghotels.booking_hotels_api.models.dtos.CreateUserDTO;
import com.bookinghotels.booking_hotels_api.models.dtos.UpdateUserDTO;
import com.bookinghotels.booking_hotels_api.models.dtos.response.HotelBranchResponseDTO;
import com.bookinghotels.booking_hotels_api.models.dtos.response.UserResponseDTO;
import com.bookinghotels.booking_hotels_api.models.entities.Role;
import com.bookinghotels.booking_hotels_api.models.entities.User;
import com.bookinghotels.booking_hotels_api.repositories.RoleRepository;
import com.bookinghotels.booking_hotels_api.repositories.UserRepository;
import com.bookinghotels.booking_hotels_api.services.IService.RoleService;
import com.bookinghotels.booking_hotels_api.services.IService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleService roleService;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleService roleService) {
        this.userRepository = userRepository;
        this.roleService = roleService;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User save(CreateUserDTO newUser) {
        User user = new User();
        user.setFirstName(newUser.getFirstName());
        user.setLastName(newUser.getLastName());
        user.setEmail(newUser.getEmail());
        user.setPassword(newUser.getPassword());
        user.setPhone(newUser.getPhone());
        user.setUserRole(findRole(newUser.getRole()));

        return userRepository.save(user);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User deleteById(Long id) {
        User userDeleted = findById(id);
        if(userDeleted == null){
            return null;
        }
        userDeleted.setDeleted(true);
        userDeleted = userRepository.save(userDeleted);
        return userDeleted;
    }

    @Override
    public User updateUser(Long id, UpdateUserDTO updateUserDTO) {
        User user = findById(id);
        if(user == null){
            return null;
        }
        user.setFirstName(updateUserDTO.getFirstName());
        user.setLastName(updateUserDTO.getLastName());
        user.setEmail(updateUserDTO.getEmail());
        user.setPhone(updateUserDTO.getPhone());
        user.setUserRole(findRole(updateUserDTO.getRole()));
        user = userRepository.save(user);

        return user;
    }

    @Override
    public UserResponseDTO convertToDTO(User user) {
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setId(user.getId());
        userResponseDTO.setFirstName(user.getFirstName());
        userResponseDTO.setLastName(user.getLastName());
        userResponseDTO.setEmail(user.getEmail());
        userResponseDTO.setPhone(user.getPhone());
        userResponseDTO.setDeleted(user.isDeleted());
        userResponseDTO.setUserRole(user.getUserRole());
        userResponseDTO.setBookings(user.getBookings());

        return userResponseDTO;
    }

    @Override
    public List<UserResponseDTO> converListToDTOList(List<User> users) {
        List<UserResponseDTO> userResponseDTOS = new ArrayList<>();
        users.forEach(user -> userResponseDTOS.add(convertToDTO(user)));

        return userResponseDTOS;
    }

    public Role findRole(int role){
        return switch (role) {
            case 0 -> roleService.getAdminRole();
            case 1 -> roleService.getClientRole();
            case 2 -> roleService.getHotelOwnerRole();
            default -> null;
        };

    }


}
