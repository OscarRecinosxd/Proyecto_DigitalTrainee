package com.bookinghotels.booking_hotels_api.services.ServiceImpl;

import com.bookinghotels.booking_hotels_api.models.dtos.CreateRoomDTO;
import com.bookinghotels.booking_hotels_api.models.dtos.UpdateRoomDTO;
import com.bookinghotels.booking_hotels_api.models.dtos.response.RoomResponseDTO;
import com.bookinghotels.booking_hotels_api.models.entities.HotelBranch;
import com.bookinghotels.booking_hotels_api.models.entities.Room;
import com.bookinghotels.booking_hotels_api.models.entities.RoomType;
import com.bookinghotels.booking_hotels_api.repositories.RoomRepository;
import com.bookinghotels.booking_hotels_api.services.IService.HotelBranchService;
import com.bookinghotels.booking_hotels_api.services.IService.RoomService;
import com.bookinghotels.booking_hotels_api.services.IService.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    RoomRepository roomRepository;

    @Autowired
    HotelBranchService hotelBranchService;

    @Autowired
    RoomTypeService roomTypeService;

    @Override
    public List<Room> findAll() {
        return roomRepository.findAll();
    }

    @Override
    public Room save(CreateRoomDTO newHotelChain) {
        Room newRoom = new Room();
        newRoom.setNumber(newHotelChain.getRoomIdentifier());
        newRoom.setCheckInTime(newHotelChain.getCheckIntTime());
        newRoom.setCheckOutTime(newHotelChain.getCheckOutTime());
        newRoom.setCapacity(newHotelChain.getCapacity());
        newRoom.setPrice(newHotelChain.getPrice());

        //Validation
        HotelBranch hotelBranch = hotelBranchService.findById(newHotelChain.getHotelBranchId());
        RoomType roomType = roomTypeService.findById(newHotelChain.getRoomTypeId());

        newRoom.setHotelBranch(hotelBranch);
        newRoom.setRoomType(roomType);
        newRoom = roomRepository.save(newRoom);

        return newRoom;
    }

    @Override
    public Room findById(Long id) {
        return roomRepository.findById(id).orElse(null);
    }

    @Override
    public Room deleteById(Long id) {
        Room deletedRoom = findById(id);
        deletedRoom.setDeleted(true);
        deletedRoom = roomRepository.save(deletedRoom);
        return deletedRoom;
    }

    @Override
    public Room updateRoom(Long id, UpdateRoomDTO updateRoomDTO) {
        Room updatedRoom = findById(id);
        RoomType roomType = roomTypeService.findById(updateRoomDTO.getRoomTypeId());
        updatedRoom.setRoomType(roomType);
        updatedRoom.setCheckInTime(updateRoomDTO.getCheckIntTime());
        updatedRoom.setCheckOutTime(updateRoomDTO.getCheckOutTime());
        updatedRoom.setCapacity(updateRoomDTO.getCapacity());
        updatedRoom.setPrice(updateRoomDTO.getPrice());

        updatedRoom = roomRepository.save(updatedRoom);

        return updatedRoom;
    }

    @Override
    public RoomResponseDTO converToDTO(Room room) {
        RoomResponseDTO roomResponseDTO = new RoomResponseDTO();
        roomResponseDTO.setId(room.getId());
        roomResponseDTO.setNumber(room.getNumber());
        roomResponseDTO.setCheckInTime(room.getCheckInTime());
        roomResponseDTO.setCheckOutTime(room.getCheckOutTime());
        roomResponseDTO.setCapacity(room.getCapacity());
        roomResponseDTO.setPrice(room.getPrice());
        roomResponseDTO.setDeleted(room.isDeleted());
        roomResponseDTO.setRoomType(room.getRoomType());
        roomResponseDTO.setHotelBranch(room.getHotelBranch());
        roomResponseDTO.setBookings(room.getBookings());

        return roomResponseDTO;
    }

    @Override
    public List<RoomResponseDTO> converListToDTO(List<Room> rooms) {
        List<RoomResponseDTO> roomResponseDTOS = new ArrayList<>();
        rooms.forEach(room -> roomResponseDTOS.add(converToDTO(room)));

        return roomResponseDTOS;
    }
}
