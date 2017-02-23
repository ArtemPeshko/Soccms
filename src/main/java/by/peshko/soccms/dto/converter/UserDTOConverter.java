package by.peshko.soccms.dto.converter;

import by.peshko.soccms.dto.ProfileDTO;
import by.peshko.soccms.dto.RoleDTO;
import by.peshko.soccms.dto.UserDTO;
import by.peshko.soccms.model.ProfileEntity;
import by.peshko.soccms.model.UserEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserDTOConverter implements Converter<UserEntity, UserDTO> {

    public UserDTO convert(final UserEntity userEntity) {
        if (userEntity != null) {

            UserDTO userDTO = new UserDTO();

            userDTO.setEnabled(userEntity.isEnabled());
            userDTO.setId(userEntity.getId());
            userDTO.setEmail(userEntity.getEmail());
            userDTO.setUsername(userEntity.getUsername());
            userDTO.setPassword(userEntity.getPassword());
            userDTO.setEnabled(userEntity.isEnabled());

            RoleDTO roleDTO = new RoleDTO();
            roleDTO.setId(userEntity.getRoleEntity().getId());
            roleDTO.setRole(userEntity.getRoleEntity().getRole());

            userDTO.setRoleDTO(roleDTO);

            ProfileEntity profileEntity = userEntity.getProfileEntity();
            ProfileDTO profileDTO = new ProfileDTO();
            profileDTO.setUserDTO(userDTO);
            profileDTO.setAge(profileEntity.getAge());
            profileDTO.setBirthDate(profileEntity.getBirthDate());
            profileDTO.setCity(profileEntity.getCity());
            profileDTO.setEmail(profileEntity.getEmail());
            profileDTO.setFirstname(profileEntity.getFirstname());
            profileDTO.setLastname(profileEntity.getLastname());
            profileDTO.setPhoneNumber(profileEntity.getPhoneNumber());
            profileDTO.setProfileID(profileEntity.getId());
            profileDTO.setSex(profileEntity.getSex());

            userDTO.setProfileDTO(profileDTO);

            return userDTO;
        }
        return null;
    }
}
