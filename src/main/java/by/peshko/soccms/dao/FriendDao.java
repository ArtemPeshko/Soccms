package by.peshko.soccms.dao;

import by.peshko.soccms.model.FriendEntity;
import by.peshko.soccms.model.ProfileEntity;

import java.util.List;

public interface FriendDao {

    void addFriend(ProfileEntity currentProfile, ProfileEntity newFriend);

    List<FriendEntity> getAllTheFriends(Long profileId);

    List<FriendEntity> getAllTheFriendsForFriendUser(Long profileId);

    List<FriendEntity> getAllThePendingRequests();

    void deleteFriend(Long loggedUserProfileId, Long frendProfileId);

    void approveFriendRequest(Long loggedUserProfileId, Long frendProfileId);

    void rejectFriendRequest(Long loggedUserProfileId, Long frendProfileId);

    FriendEntity getById(Long friendId);
}