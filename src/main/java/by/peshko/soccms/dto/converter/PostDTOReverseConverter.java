package by.peshko.soccms.dto.converter;

import by.peshko.soccms.dto.PostDTO;
import by.peshko.soccms.dto.ProfileDTO;
import by.peshko.soccms.model.PostEntity;
import by.peshko.soccms.model.ProfileEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PostDTOReverseConverter implements Converter<PostDTO, PostEntity> {

    @Override
    public PostEntity convert(final PostDTO postDTO) {

        if (postDTO == null) {
            return null;
        }

        PostEntity postEntity = new PostEntity();

        ProfileEntity senderProfileEntity = new ProfileEntity();
        ProfileDTO senderProfileDTO = postDTO.getSenderProfileDTO();
        senderProfileEntity.setId(senderProfileDTO.getProfileID());
        senderProfileEntity.setFirstname(senderProfileDTO.getFirstname());
        senderProfileEntity.setLastname(senderProfileDTO.getLastname());
        senderProfileEntity.setEmail(senderProfileDTO.getEmail());
        senderProfileEntity.setAge(senderProfileDTO.getAge());
        senderProfileEntity.setBirthDate(senderProfileDTO.getBirthDate());
        senderProfileEntity.setSex(senderProfileDTO.getSex());
        senderProfileEntity.setCity(senderProfileDTO.getCity());
        senderProfileEntity.setPhoneNumber(senderProfileDTO.getPhoneNumber());

        ProfileEntity wallOwnerProfileEntity = new ProfileEntity();
        ProfileDTO wallOwnerProfileDTO = postDTO.getWallOwnerProfileDTO();
        wallOwnerProfileEntity.setId(wallOwnerProfileDTO.getProfileID());
        wallOwnerProfileEntity.setFirstname(wallOwnerProfileDTO.getFirstname());
        wallOwnerProfileEntity.setLastname(wallOwnerProfileDTO.getLastname());
        wallOwnerProfileEntity.setEmail(wallOwnerProfileDTO.getEmail());
        wallOwnerProfileEntity.setAge(wallOwnerProfileDTO.getAge());
        wallOwnerProfileEntity.setBirthDate(wallOwnerProfileDTO.getBirthDate());
        wallOwnerProfileEntity.setSex(wallOwnerProfileDTO.getSex());
        wallOwnerProfileEntity.setCity(wallOwnerProfileDTO.getCity());
        wallOwnerProfileEntity.setPhoneNumber(wallOwnerProfileDTO.getPhoneNumber());

        postEntity.setPostID(postDTO.getPostID());

        postEntity.setWallOwnerProfile(wallOwnerProfileEntity);
        postEntity.setProfileSender(senderProfileEntity);

        postEntity.setText(postDTO.getText());
        postEntity.setPostDate(postDTO.getPostDate());

        return postEntity;
    }
}