package by.peshko.soccms.dto.converter;

import by.peshko.soccms.dto.FriendDTO;
import by.peshko.soccms.dto.ProfileDTO;
import by.peshko.soccms.model.FriendEntity;
import by.peshko.soccms.model.ProfileEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class FriendDTOConverter implements Converter<FriendEntity, FriendDTO> {
    public FriendDTO convert(final FriendEntity friendEntity) {
        if (friendEntity == null) {
            return null;
        }

        FriendDTO friendDTO = new FriendDTO();

        ProfileEntity profileEntity = friendEntity.getCurrentProfileEntity();
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

        ProfileEntity profileEntityForFriend = friendEntity.getFriendProfileEntity();
        ProfileDTO profileDTOForFriend = new ProfileDTO();
        profileDTOForFriend.setProfileID(profileEntityForFriend.getId());
        profileDTOForFriend.setFirstname(profileEntityForFriend.getFirstname());
        profileDTOForFriend.setLastname(profileEntityForFriend.getLastname());
        profileDTOForFriend.setEmail(profileEntityForFriend.getEmail());
        profileDTOForFriend.setBirthDate(profileEntityForFriend.getBirthDate());
        profileDTOForFriend.setAge(profileEntityForFriend.getAge());
        profileDTOForFriend.setSex(profileEntityForFriend.getSex());
        profileDTOForFriend.setCity(profileEntityForFriend.getCity());
        profileDTOForFriend.setPhoneNumber(profileEntityForFriend.getPhoneNumber());

        friendDTO.setProfileDTO(profileDTO);
        friendDTO.setFriendProfileDTO(profileDTOForFriend);

        friendDTO.setId(friendEntity.getId());
        friendDTO.setStatus(friendEntity.getStatus());

        return friendDTO;
    }
}