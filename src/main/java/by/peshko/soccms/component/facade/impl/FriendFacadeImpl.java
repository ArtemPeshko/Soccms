package by.peshko.soccms.component.facade.impl;

import by.peshko.soccms.dto.FriendDTO;
import by.peshko.soccms.dto.ProfileDTO;
import by.peshko.soccms.component.facade.FriendFacade;
import by.peshko.soccms.model.ProfileEntity;
import by.peshko.soccms.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component("friendFacade")
public class FriendFacadeImpl implements FriendFacade {
    @Autowired
    private FriendService friendService;
    @Autowired
    private ConversionService conversionService;


    public void addFriend(final ProfileDTO currentProfileDTO, final ProfileDTO newFriend) {
        ProfileEntity currentProfileEntity = conversionService.convert(currentProfileDTO, ProfileEntity.class);
        ProfileEntity newFriendProfileEntity = conversionService.convert(newFriend, ProfileEntity.class);
        friendService.addFriend(currentProfileEntity, newFriendProfileEntity);
    }

    public Set<FriendDTO> getAllThePendingFriendRequest(final Long currentLoggedUserProfileId) {
        Set<FriendDTO> allTheProfilesDTO = new HashSet<>();

        friendService.getAllThePendingFriendRequestForUser(currentLoggedUserProfileId).
                forEach(elem -> allTheProfilesDTO.add(conversionService.convert(elem, FriendDTO.class)));

        return allTheProfilesDTO;
    }

    public List<FriendDTO> getAllThePendingRequests() {
        List<FriendDTO> allPendingFriends = new ArrayList<>();

        friendService.getAllThePendingRequests().
                forEach(elem -> allPendingFriends.add(conversionService.convert(elem, FriendDTO.class)));

        return allPendingFriends;
    }

    public void deleteFriend(final Long loggedUserProfileId, final Long frendProfileId) {
        friendService.deleteFriend(loggedUserProfileId, frendProfileId);
    }

    public void approveFriendRequest(final Long loggedUserProfileId, final Long frendProfileId) {
        friendService.approveFriendRequest(loggedUserProfileId, frendProfileId);
    }

    public void rejectFriendRequest(final Long loggedUserProfileId, final Long frendProfileId) {
        friendService.rejectFriendRequest(loggedUserProfileId, frendProfileId);
    }
}