package by.peshko.soccms.dto.converter;

import by.peshko.soccms.dto.ProfileDTO;
import by.peshko.soccms.dto.UserDTO;
import by.peshko.soccms.model.ProfileEntity;
import by.peshko.soccms.model.RoleEntity;
import by.peshko.soccms.model.UserEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ProfileDTOReverseConverter implements Converter<ProfileDTO, ProfileEntity> {
    public ProfileEntity convert(final ProfileDTO profileDTO) {

        if (profileDTO == null) {
            return null;
        }

        final ProfileEntity profileEntity = new ProfileEntity();

        profileEntity.setId(profileDTO.getProfileID());
        profileEntity.setFirstname(profileDTO.getFirstname());
        profileEntity.setLastname(profileDTO.getLastname());
        profileEntity.setEmail(profileDTO.getEmail());
        profileEntity.setAge(profileDTO.getAge());
        profileEntity.setBirthDate(profileDTO.getBirthDate());
        profileEntity.setSex(profileDTO.getSex());
        profileEntity.setCity(profileDTO.getCity());
        profileEntity.setPhoneNumber(profileDTO.getPhoneNumber());

        UserEntity userEntity = new UserEntity();
        UserDTO userDTO = profileDTO.getUserDTO();

        if (userDTO != null) {
            userEntity.setEnabled(userDTO.isEnabled());
            userEntity.setId(userDTO.getId());
            userEntity.setEmail(userDTO.getEmail());
            userEntity.setUsername(userDTO.getUsername());
            userEntity.setPassword(userDTO.getPassword());
            userEntity.setProfileEntity(profileEntity);

            if (userDTO.getRoleDTO() != null) {
                RoleEntity roleEntity = new RoleEntity();
                roleEntity.setRole(userDTO.getRoleDTO().getRole());
                roleEntity.setId(userDTO.getRoleDTO().getId());
                userEntity.setRoleEntity(roleEntity);
            }

        }

        profileEntity.setUserEntity(userEntity);

        return profileEntity;
    }
}
