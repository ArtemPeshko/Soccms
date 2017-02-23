package by.peshko.soccms.component.facade.impl;

import by.peshko.soccms.dto.UserDTO;
import by.peshko.soccms.component.facade.UserFacade;
import by.peshko.soccms.model.RegistrationStatus;
import by.peshko.soccms.model.UserEntity;
import by.peshko.soccms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("userFacade")
public class UserFacadeImpl implements UserFacade {
    @Autowired
    private UserService userService;
    @Autowired
    private ConversionService conversionService;

    public void createUser(final UserDTO userDTO) {
        userService.createUser(conversionService.convert(userDTO, UserEntity.class));
    }

    public void updateUser(final UserDTO userDTO) {
        userService.updateUser(conversionService.convert(userDTO, UserEntity.class));
    }

    public void deleteUser(final UserDTO userDTO) {
        userService.deleteUser(conversionService.convert(userDTO, UserEntity.class));
    }

    public UserDTO getUserByUsername(final String username) {
        return conversionService.convert(userService.getUserByUsername(username), UserDTO.class);
    }

    public List<UserDTO> getAllTheUsers() {
        List<UserDTO> allTheDTOUsers = new ArrayList<>();

        userService.getAllTheUsers().forEach(elem -> allTheDTOUsers.add(conversionService.convert(elem, UserDTO.class)));

        return allTheDTOUsers;
    }

    public RegistrationStatus registrationStatus(final String username, final String email) {
        List<UserDTO> allTheDTOUsers = new ArrayList<>();
        userService.getUserByUsernameOrEmail(username, email).
                forEach(elem -> allTheDTOUsers.add(conversionService.convert(elem, UserDTO.class)));

        if (allTheDTOUsers.size() > 0) {
            UserDTO userDTO = allTheDTOUsers.get(0);

            if (userDTO.getEmail().equalsIgnoreCase(email)) {
                return RegistrationStatus.EMAIL_EXISTS;
            } else if (userDTO.getUsername().equalsIgnoreCase(username)) {
                return RegistrationStatus.USERNAME_EXISTS;
            }
        }
        return RegistrationStatus.FREE;
    }
}
