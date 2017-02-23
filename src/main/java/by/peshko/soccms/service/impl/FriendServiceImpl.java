package by.peshko.soccms.service.impl;

import by.peshko.soccms.dao.FriendDao;
import by.peshko.soccms.model.FriendEntity;
import by.peshko.soccms.model.FriendRequestApprovalStatus;
import by.peshko.soccms.model.ProfileEntity;
import by.peshko.soccms.service.FriendService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("friendService")
public class FriendServiceImpl implements FriendService {
    private static final Logger LOGGER = Logger.getLogger(FriendServiceImpl.class);

    @Autowired
    private FriendDao friendDao;

    @Transactional
    public void addFriend(final ProfileEntity currentProfile, final ProfileEntity newFriend) {
        friendDao.addFriend(currentProfile, newFriend);
        LOGGER.info("Added new friend request from profileID " + newFriend.getId() + " for profileID " + currentProfile.getId());
    }

    @Transactional
    public void deleteFriend(final Long loggedUserProfileId, final Long frendProfileId) {
        friendDao.deleteFriend(loggedUserProfileId, frendProfileId);
        LOGGER.info("Deleted friend with profileID " + frendProfileId + " from profileID " + loggedUserProfileId);

    }

    @Transactional(readOnly = true)
    public List<FriendEntity> getAllThePendingFriendRequestForUser(final Long currentLoggedUserProfileId) {
        List<FriendEntity> result = new ArrayList<>();

        friendDao.getAllTheFriendsForFriendUser(currentLoggedUserProfileId).stream().
                filter(elem -> elem.getStatus() == FriendRequestApprovalStatus.PENDING_REQUEST).
                forEach(result::add);

        LOGGER.info("Got list of pending friend requests for profileID " + currentLoggedUserProfileId);
        return result;
    }

    @Transactional(readOnly = true)
    public List<FriendEntity> getAllThePendingRequests() {
        LOGGER.info("Got all pending friend requests for all users");
        return friendDao.getAllThePendingRequests();
    }

    @Transactional
    public void approveFriendRequest(final Long loggedUserProfileId, final Long frendProfileId) {
        friendDao.approveFriendRequest(loggedUserProfileId, frendProfileId);
        LOGGER.info("Approved friend request for profileID " + frendProfileId + " from user with profileID " + loggedUserProfileId);

    }

    @Transactional
    public void rejectFriendRequest(final Long loggedUserProfileId, final Long frendProfileId) {
        friendDao.rejectFriendRequest(loggedUserProfileId, frendProfileId);
        LOGGER.info("Rejected friend request for profileID " + frendProfileId + " from user with profileID " + loggedUserProfileId);

    }

}