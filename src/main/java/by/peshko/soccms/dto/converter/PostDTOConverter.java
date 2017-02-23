package by.peshko.soccms.dto.converter;

import by.peshko.soccms.dto.PostDTO;
import by.peshko.soccms.dto.ProfileDTO;
import by.peshko.soccms.model.PostEntity;
import by.peshko.soccms.model.ProfileEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PostDTOConverter implements Converter<PostEntity, PostDTO> {
    @Override
    public PostDTO convert(final PostEntity postEntity) {
        if (postEntity == null) {
            return null;
        }

        PostDTO postDTO = new PostDTO();

        ProfileEntity senderProfileEntity = postEntity.getProfileSender();
        ProfileDTO senderProfileDTO = new ProfileDTO();
        senderProfileDTO.setProfileID(senderProfileEntity.getId());
        senderProfileDTO.setFirstname(senderProfileEntity.getFirstname());
        senderProfileDTO.setLastname(senderProfileEntity.getLastname());
        senderProfileDTO.setEmail(senderProfileEntity.getEmail());
        senderProfileDTO.setBirthDate(senderProfileEntity.getBirthDate());
        senderProfileDTO.setAge(senderProfileEntity.getAge());
        senderProfileDTO.setSex(senderProfileEntity.getSex());
        senderProfileDTO.setCity(senderProfileEntity.getCity());
        senderProfileDTO.setPhoneNumber(senderProfileEntity.getPhoneNumber());

        ProfileEntity wallOwnerProfileEntity = postEntity.getProfileSender();
        ProfileDTO wallownerProfileDTO = new ProfileDTO();
        wallownerProfileDTO.setProfileID(wallOwnerProfileEntity.getId());
        wallownerProfileDTO.setFirstname(wallOwnerProfileEntity.getFirstname());
        wallownerProfileDTO.setLastname(wallOwnerProfileEntity.getLastname());
        wallownerProfileDTO.setEmail(wallOwnerProfileEntity.getEmail());
        wallownerProfileDTO.setBirthDate(wallOwnerProfileEntity.getBirthDate());
        wallownerProfileDTO.setAge(wallOwnerProfileEntity.getAge());
        wallownerProfileDTO.setSex(wallOwnerProfileEntity.getSex());
        wallownerProfileDTO.setCity(wallOwnerProfileEntity.getCity());
        wallownerProfileDTO.setPhoneNumber(wallOwnerProfileEntity.getPhoneNumber());

        postDTO.setPostID(postEntity.getPostID());
        postDTO.setSenderProfileDTO(senderProfileDTO);
        postDTO.setWallOwnerProfileDTO(wallownerProfileDTO);
        postDTO.setText(postEntity.getText());
        postDTO.setPostDate(postEntity.getPostDate());
        postDTO.setPhotoFileName(postEntity.getPhotoFileName());

        return postDTO;
    }
}