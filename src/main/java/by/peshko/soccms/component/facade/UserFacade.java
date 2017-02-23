package by.peshko.soccms.component.facade;

import by.peshko.soccms.dto.UserDTO;
import by.peshko.soccms.model.RegistrationStatus;

import java.util.List;

public interface UserFacade {

    void createUser(UserDTO userDTO);

    void updateUser(UserDTO userDTO);

    void deleteUser(UserDTO userDTO);

    UserDTO getUserByUsername(String username);

    List<UserDTO> getAllTheUsers();

    RegistrationStatus registrationStatus(String username, String email);

}
