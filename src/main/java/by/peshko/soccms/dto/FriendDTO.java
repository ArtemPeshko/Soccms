package by.peshko.soccms.dto;

import by.peshko.soccms.model.FriendRequestApprovalStatus;

import java.io.Serializable;

public class FriendDTO implements Serializable {
    private static final int HASH_NUMBER = 31;
    private Long id;
    private ProfileDTO profileDTO;
    private ProfileDTO friendProfileDTO;
    private FriendRequestApprovalStatus status;

    public void setFriendProfileDTO(final ProfileDTO friendProfileDTO) {
        this.friendProfileDTO = friendProfileDTO;
    }

    public void setProfileDTO(final ProfileDTO profileDTO) {
        this.profileDTO = profileDTO;
    }

    public ProfileDTO getFriendProfileDTO() {
        return friendProfileDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public ProfileDTO getProfileDTO() {
        return profileDTO;
    }

    public FriendRequestApprovalStatus getStatus() {
        return status;
    }

    public void setStatus(final FriendRequestApprovalStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FriendDTO)) {
            return false;
        }

        FriendDTO friendDTO = (FriendDTO) o;

        if (!getId().equals(friendDTO.getId())) {
            return false;
        }
        if (!getProfileDTO().equals(friendDTO.getProfileDTO())) {
            return false;
        }
        if (!getFriendProfileDTO().equals(friendDTO.getFriendProfileDTO())) {
            return false;
        }
        return getStatus() == friendDTO.getStatus();

    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = HASH_NUMBER * result + getProfileDTO().hashCode();
        result = HASH_NUMBER * result + getFriendProfileDTO().hashCode();
        result = HASH_NUMBER * result + getStatus().hashCode();
        return result;
    }
}