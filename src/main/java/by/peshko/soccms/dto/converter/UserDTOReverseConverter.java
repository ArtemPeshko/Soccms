package by.peshko.soccms.dto.converter;

import by.peshko.soccms.dto.ProfileDTO;
import by.peshko.soccms.dto.UserDTO;
import by.peshko.soccms.model.ProfileEntity;
import by.peshko.soccms.model.RoleEntity;
import by.peshko.soccms.model.UserEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserDTOReverseConverter implements Converter<UserDTO, UserEntity> {

    public UserEntity convert(final UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();

        userEntity.setEnabled(userDTO.isEnabled());
        userEntity.setId(userDTO.getId());
        userEntity.setEmail(userDTO.getEmail());
        userEntity.setUsername(userDTO.getUsername());
        userEntity.setPassword(userDTO.getPassword());

        ProfileEntity profileEntity = new ProfileEntity();
        ProfileDTO profileDTO = userDTO.getProfileDTO();

        if (profileDTO != null) {
            profileEntity.setId(profileDTO.getProfileID());

            profileEntity.setFirstname(profileDTO.getFirstname());
            profileEntity.setLastname(profileDTO.getLastname());
            profileEntity.setEmail(profileDTO.getEmail());
            profileEntity.setAge(profileDTO.getAge());
            profileEntity.setBirthDate(profileDTO.getBirthDate());
            profileEntity.setSex(profileDTO.getSex());
            profileEntity.setCity(profileDTO.getCity());
            profileEntity.setPhoneNumber(profileDTO.getPhoneNumber());

            userEntity.setProfileEntity(profileEntity);
        }

        if (userDTO.getRoleDTO() != null) {
            RoleEntity roleEntity = new RoleEntity();
            roleEntity.setRole(userDTO.getRoleDTO().getRole());
            roleEntity.setId(userDTO.getRoleDTO().getId());
            userEntity.setRoleEntity(roleEntity);
        }

        return userEntity;
    }
}
