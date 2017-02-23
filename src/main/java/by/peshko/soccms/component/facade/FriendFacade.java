package by.peshko.soccms.component.facade;

import by.peshko.soccms.dto.FriendDTO;
import by.peshko.soccms.dto.ProfileDTO;

import java.util.List;
import java.util.Set;

public interface FriendFacade {

    void addFriend(ProfileDTO currentProfileDTO, ProfileDTO newFriend);

    Set<FriendDTO> getAllThePendingFriendRequest(Long currentLoggedUserProfileId);

    List<FriendDTO> getAllThePendingRequests();

    void deleteFriend(Long loggedUserProfileId, Long frendProfileId);

    void approveFriendRequest(Long loggedUserProfileId, Long frendProfileId);

    void rejectFriendRequest(Long loggedUserProfileId, Long frendProfileId);
}