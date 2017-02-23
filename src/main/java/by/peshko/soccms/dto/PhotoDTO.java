package by.peshko.soccms.dto;

import org.springframework.web.multipart.MultipartFile;

public class PhotoDTO {
    private static final int HASH_NUMBER = 31;
    private Long id;
    private String photoFileName;
    private MultipartFile photo;
    private ProfileDTO profileDTO;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public void setPhotoFileName(final String photoFileName) {
        this.photoFileName = photoFileName;
    }

    public String getPhotoFileName() {
        return photoFileName;
    }

    public MultipartFile getPhoto() {
        return photo;
    }

    public void setPhoto(final MultipartFile photo) {
        this.photo = photo;
    }

    public ProfileDTO getProfileDTO() {
        return profileDTO;
    }

    public void setProfileDTO(final ProfileDTO profileDTO) {
        this.profileDTO = profileDTO;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PhotoDTO)) {
            return false;
        }

        PhotoDTO photoDTO = (PhotoDTO) o;

        if (!getId().equals(photoDTO.getId())) {
            return false;
        }
        if (!getPhotoFileName().equals(photoDTO.getPhotoFileName())) {
            return false;
        }
        if (!getPhoto().equals(photoDTO.getPhoto())) {
            return false;
        }
        return getProfileDTO() != null ? getProfileDTO().equals(photoDTO.getProfileDTO()) : photoDTO.getProfileDTO() == null;

    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = HASH_NUMBER * result + getPhotoFileName().hashCode();
        result = HASH_NUMBER * result + getPhoto().hashCode();
        result = HASH_NUMBER * result + (getProfileDTO() != null ? getProfileDTO().hashCode() : 0);
        return result;
    }
}