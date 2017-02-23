package by.peshko.soccms.dto;

import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

public class PostDTO {
    private static final int HASH_NUMBER = 31;
    private Long postID;
    private Date postDate;
    private ProfileDTO senderProfileDTO;
    private ProfileDTO wallOwnerProfileDTO;
    private ProfileDTO firstname;
    private ProfileDTO lastname;
    private String text;
    private String photoFileName;
    private MultipartFile photo;

    public ProfileDTO getFirstname() {
        return firstname;
    }

    public void setFirstname(ProfileDTO firstname) {
        this.firstname = firstname;
    }

    public ProfileDTO getLastname() {
        return lastname;
    }

    public void setLastname(ProfileDTO lastname) {
        this.lastname = lastname;
    }

    public String getText() {
        return text;
    }

    public void setPostID(final Long postID) {
        this.postID = postID;
    }

    public void setText(final String text) {
        this.text = text;
    }

    public Long getPostID() {
        return postID;
    }

    public void setPostDate(final Date postDate) {
        this.postDate = postDate;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setWallOwnerProfileDTO(final ProfileDTO wallOwnerProfileDTO) {
        this.wallOwnerProfileDTO = wallOwnerProfileDTO;
    }

    public ProfileDTO getWallOwnerProfileDTO() {
        return wallOwnerProfileDTO;
    }

    public void setSenderProfileDTO(final ProfileDTO senderProfileDTO) {
        this.senderProfileDTO = senderProfileDTO;
    }

    public ProfileDTO getSenderProfileDTO() {
        return senderProfileDTO;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PostDTO)) {
            return false;
        }

        PostDTO postDTO = (PostDTO) o;

        if (!getPostID().equals(postDTO.getPostID())) {
            return false;
        }
        if (!getPostDate().equals(postDTO.getPostDate())) {
            return false;
        }
        if (!getSenderProfileDTO().equals(postDTO.getSenderProfileDTO())) {
            return false;
        }
        if (!getWallOwnerProfileDTO().equals(postDTO.getWallOwnerProfileDTO())) {
            return false;
        }
        if (!getText().equals(postDTO.getText())) {
            return false;
        }
        if (!getPhotoFileName().equals(postDTO.getPhotoFileName())) {
            return false;
        }
        if (!getLastname().equals(postDTO.getLastname())) {
            return false;
        }
        if (!getFirstname().equals(postDTO.getFirstname())) {
            return false;
        }
        return getPhoto().equals(postDTO.getPhoto());

    }

    @Override
    public int hashCode() {
        int result = getPostID().hashCode();
        result = HASH_NUMBER * result + getFirstname().hashCode();
        result = HASH_NUMBER * result + getLastname().hashCode();
        result = HASH_NUMBER * result + getPostDate().hashCode();
        result = HASH_NUMBER * result + getSenderProfileDTO().hashCode();
        result = HASH_NUMBER * result + getWallOwnerProfileDTO().hashCode();
        result = HASH_NUMBER * result + getText().hashCode();
        result = HASH_NUMBER * result + getPhotoFileName().hashCode();
        result = HASH_NUMBER * result + getPhoto().hashCode();
        return result;
    }

    public MultipartFile getPhoto() {
        return photo;
    }

    public void setPhoto(final MultipartFile photo) {
        this.photo = photo;
    }

    public void setPhotoFileName(final String photoFileName) {
        this.photoFileName = photoFileName;
    }

    public String getPhotoFileName() {
        return photoFileName;
    }
}