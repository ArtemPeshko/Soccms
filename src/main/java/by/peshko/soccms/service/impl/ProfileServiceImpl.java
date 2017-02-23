package by.peshko.soccms.service.impl;

import by.peshko.soccms.dao.FriendDao;
import by.peshko.soccms.dao.ProfileDao;
import by.peshko.soccms.model.FriendRequestApprovalStatus;
import by.peshko.soccms.model.ProfileEntity;
import by.peshko.soccms.service.ProfileService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service("profileService")
public class ProfileServiceImpl implements ProfileService {
    private final static Logger LOGGER = Logger.getLogger(ProfileServiceImpl.class);
    @Autowired
    private ProfileDao profileDao;
    @Autowired
    private FriendDao friendDao;
    @Autowired
    private MessageSource messageSource;

    @Transactional
    public void createProfile(final ProfileEntity profileEntity) {
        profileDao.createProfile(profileEntity);
        LOGGER.info(messageSource.getMessage("service.profile.save", new Object[]{profileEntity}, Locale.ENGLISH));
    }

    @Transactional(readOnly = true)
    public ProfileEntity getProfileById(final Long profileId) {
        LOGGER.info(messageSource.getMessage("service.profile.getById", new Object[]{profileId}, Locale.ENGLISH));
        return profileDao.getById(profileId);
    }

    @Transactional
    public void updateProfile(final ProfileEntity profileEntity) {
        LOGGER.info(messageSource.getMessage("service.profile.update", new Object[]{profileEntity}, Locale.ENGLISH));
        profileDao.updateProfile(profileEntity);
    }

    @Transactional
    public void deleteProfile(final ProfileEntity profileEntity) {
        LOGGER.info(messageSource.getMessage("service.profile.delete", new Object[]{profileEntity}, Locale.ENGLISH));
        profileDao.deleteProfile(profileEntity);

    }

    @Transactional(readOnly = true)
    public List<ProfileEntity> getAllTheProfiles() {
        List<ProfileEntity> allTheProfiles = profileDao.getAllTheProfiles();
        allTheProfiles.removeIf(elem -> elem.getUserEntity().getUsername().equals("admin"));
        return allTheProfiles;
    }

    @Transactional(readOnly = true)
    public List<ProfileEntity> getAllTheProfilesOfFriends(final Long currentLoggedUserProfileId) {
        List<ProfileEntity> allTheFriendProfiles = new ArrayList<>();

        friendDao.getAllTheFriends(currentLoggedUserProfileId).stream().
                filter(elem -> elem.getStatus() == FriendRequestApprovalStatus.APPROVED_REQUEST).
                forEach(elem -> allTheFriendProfiles.add(profileDao.getById(elem.getFriendProfileEntity().getId())));

        return allTheFriendProfiles;
    }

    @Transactional(readOnly = true)
    public List<ProfileEntity> getAllTheProfilesOfNonPendingAndNotFriends(final Long currentLoggedUserProfileId,
                                                                          final String currentLoggedUsername) {
        List<ProfileEntity> allTheFriendProfiles = new ArrayList<>();
        List<ProfileEntity> allTheProfiles = getAllTheProfiles();
        List<ProfileEntity> allTheProfilesOfFriends
                = getAllTheProfilesOfFriends(currentLoggedUserProfileId);

        allTheProfiles.stream().filter(elem -> !allTheProfilesOfFriends.contains(elem)).forEach(allTheFriendProfiles::add);

        allTheProfiles.stream().
                filter(elem -> elem.getUserEntity().getUsername().equalsIgnoreCase(currentLoggedUsername) ||
                        elem.getUserEntity().getUsername().equalsIgnoreCase("admin")).
                forEach(allTheFriendProfiles::remove);

        friendDao.getAllTheFriends(currentLoggedUserProfileId).stream().
                filter(elem -> elem.getStatus() == FriendRequestApprovalStatus.PENDING_REQUEST).
                filter(elem -> allTheFriendProfiles.contains(profileDao.getById(elem.getFriendProfileEntity().getId()))).
                forEach(elem -> allTheFriendProfiles.remove(profileDao.getById(elem.getFriendProfileEntity().getId())));

        return allTheFriendProfiles;
    }

    @Override
    public List<ProfileEntity> getAllTheProfilesOneParameter(final String request) {
        String[] params = request.trim().split(" ");

        List<ProfileEntity> result = new ArrayList<>();

        if (params.length == 1) {
            result = profileDao.getAllTheProfilesOneParameter(params[0]);
        } else if (params.length == 2) {
            result = profileDao.getAllTheProfilesTwoParametres(params[0], params[1]);
        }
        return result;
    }
}
