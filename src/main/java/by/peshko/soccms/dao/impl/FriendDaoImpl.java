package by.peshko.soccms.dao.impl;

import by.peshko.soccms.dao.FriendDao;
import by.peshko.soccms.model.FriendEntity;
import by.peshko.soccms.model.FriendRequestApprovalStatus;
import by.peshko.soccms.model.ProfileEntity;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Repository("friendDao")
@Transactional
public class FriendDaoImpl extends AbstractBaseDAO implements FriendDao {
    private static final String DELETE_FRIEND_BY_FRIEND_ID
            = "DELETE FROM FriendEntity WHERE main_profile_id  = :loggedUserProfileId AND friends_profile_id = :frendProfileId";

    private static final String GET_ALL_THE_FRIENDS_QUERY = "FROM FriendEntity " + "WHERE main_profile_id = :profileId";

    private static final String GET_ALL_THE_FRIENDS_OF_FRIEND_QUERY
            = "FROM FriendEntity WHERE friends_profile_id = :friendProfileId";

    private static final String GET_ALL_THE_FRIENDS_WITH_PENDING_STATUS_QUERY
            = "FROM FriendEntity WHERE friend_request_status =:status";

    private static final String CHANGE_FRIEND_REQUEST_STATUS_QUERY = "UPDATE FriendEntity SET friend_request_status =:status " +
            "WHERE main_profile_id = :loggedUserProfileId AND  friends_profile_id = :frendProfileId";

    public void addFriend(final ProfileEntity currentProfile, final ProfileEntity newFriend) {
        FriendEntity friendEntity = new FriendEntity();
        friendEntity.setCurrentProfileEntity(currentProfile);
        friendEntity.setFriendProfileEntity(newFriend);
        friendEntity.setStatus(FriendRequestApprovalStatus.PENDING_REQUEST);

        Set<FriendEntity> friends = currentProfile.getCurrentProfileFriends();
        friends.add(friendEntity);

        currentProfile.setCurrentProfileFriends(friends);
        super.udate(currentProfile);
        super.save(friendEntity);
    }

    public List<FriendEntity> getAllTheFriends(final Long profileId) {
        Query query = super.getCurrentSession().createQuery(GET_ALL_THE_FRIENDS_QUERY);
        query.setParameter("profileId", profileId);
        return query.list();
    }

    public List<FriendEntity> getAllTheFriendsForFriendUser(final Long friendProfileId) {
        Query query = super.getCurrentSession().createQuery(GET_ALL_THE_FRIENDS_OF_FRIEND_QUERY);
        query.setParameter("friendProfileId", friendProfileId);
        return query.list();
    }

    public List<FriendEntity> getAllThePendingRequests() {
        Query query = super.getCurrentSession().createQuery(GET_ALL_THE_FRIENDS_WITH_PENDING_STATUS_QUERY);
        query.setParameter("status", FriendRequestApprovalStatus.PENDING_REQUEST.name());
        return query.list();
    }

    public void deleteFriend(final Long loggedUserProfileId, final Long frendProfileId) {
        Query query = super.getCurrentSession().createQuery(DELETE_FRIEND_BY_FRIEND_ID);
        query.setParameter("loggedUserProfileId", loggedUserProfileId);
        query.setParameter("frendProfileId", frendProfileId);
        query.executeUpdate();
    }

    public void approveFriendRequest(final Long loggedUserProfileId, final Long frendProfileId) {
        Query query = super.getCurrentSession().createQuery(CHANGE_FRIEND_REQUEST_STATUS_QUERY);

        query.setParameter("loggedUserProfileId", frendProfileId);
        query.setParameter("frendProfileId", loggedUserProfileId);
        query.setParameter("status", FriendRequestApprovalStatus.APPROVED_REQUEST.name());
        query.executeUpdate();

    }

    public void rejectFriendRequest(final Long loggedUserProfileId, final Long frendProfileId) {
        deleteFriend(frendProfileId, loggedUserProfileId);
    }

    public FriendEntity getById(final Long friendId) {
        return (FriendEntity) super.getById(FriendEntity.class, friendId);
    }
}