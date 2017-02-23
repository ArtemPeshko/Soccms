package by.peshko.soccms.dto.converter;

import by.peshko.soccms.dto.ProfileDTO;
import by.peshko.soccms.dto.UserDTO;
import by.peshko.soccms.model.ProfileEntity;
import by.peshko.soccms.model.UserEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ProfileDTOConverter implements Converter<ProfileEntity, ProfileDTO> {

    public ProfileDTO convert(final ProfileEntity profileEntity) {

        if (profileEntity == null) {
            return null;
        }

        ProfileDTO profileDTO = new ProfileDTO();

        profileDTO.setProfileID(profileEntity.getId());
        profileDTO.setFirstname(profileEntity.getFirstname());
        profileDTO.setLastname(profileEntity.getLastname());
        profileDTO.setEmail(profileEntity.getEmail());
        profileDTO.setBirthDate(profileEntity.getBirthDate());
        profileDTO.setAge(profileEntity.getAge());
        profileDTO.setSex(profileEntity.getSex());
        profileDTO.setCity(profileEntity.getCity());
        profileDTO.setPhoneNumber(profileEntity.getPhoneNumber());

        UserDTO userDTO = new UserDTO();
        UserEntity userEntity = profileEntity.getUserEntity();

        userDTO.setProfileDTO(profileDTO);
        userDTO.setId(userEntity.getId());
        userDTO.setUsername(userEntity.getUsername());
        userDTO.setPassword(userEntity.getPassword());
        userDTO.setEmail(userEntity.getEmail());
        userDTO.setEnabled(userEntity.isEnabled());

        profileDTO.setUserDTO(userDTO);

        return profileDTO;
    }
}
