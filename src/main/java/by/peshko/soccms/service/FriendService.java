package by.peshko.soccms.service;

import by.peshko.soccms.model.FriendEntity;
import by.peshko.soccms.model.ProfileEntity;

import java.util.List;

public interface FriendService {

    void addFriend(ProfileEntity currentProfile, ProfileEntity newFriend);

    void deleteFriend(Long loggedUserProfileId, Long frendProfileId);

    List<FriendEntity> getAllThePendingFriendRequestForUser(Long currentLoggedUserProfileId);

    List<FriendEntity> getAllThePendingRequests();

    void approveFriendRequest(Long loggedUserProfileId, Long frendProfileId);

    void rejectFriendRequest(Long loggedUserProfileId, Long frendProfileId);

}