package by.peshko.soccms.dto.converter;

import by.peshko.soccms.dto.PhotoDTO;
import by.peshko.soccms.dto.ProfileDTO;
import by.peshko.soccms.model.PhotoEntity;
import by.peshko.soccms.model.ProfileEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PhotoDTOReverseConverter implements Converter<PhotoDTO, PhotoEntity> {

    @Override
    public PhotoEntity convert(final PhotoDTO photoDTO) {

        if (photoDTO == null) {
            return null;
        }

        PhotoEntity photoEntity = new PhotoEntity();
        photoEntity.setId(photoDTO.getId());
        photoEntity.setPhotoFileName(photoDTO.getPhotoFileName());

        if (photoDTO.getProfileDTO() != null) {
            ProfileEntity profileEntity = new ProfileEntity();

            ProfileDTO profileDTO = photoDTO.getProfileDTO();

            profileEntity.setId(profileDTO.getProfileID());
            profileEntity.setFirstname(profileDTO.getFirstname());
            profileEntity.setLastname(profileDTO.getLastname());
            profileEntity.setEmail(profileDTO.getEmail());
            profileEntity.setAge(profileDTO.getAge());
            profileEntity.setBirthDate(profileDTO.getBirthDate());
            profileEntity.setSex(profileDTO.getSex());
            profileEntity.setCity(profileDTO.getCity());
            profileEntity.setPhoneNumber(profileDTO.getPhoneNumber());

            photoEntity.setProfileEntity(profileEntity);
        }

        return photoEntity;
    }
}