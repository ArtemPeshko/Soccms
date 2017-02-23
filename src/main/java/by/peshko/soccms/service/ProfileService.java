package by.peshko.soccms.service;

import by.peshko.soccms.model.ProfileEntity;

import java.util.List;

public interface ProfileService {

    void createProfile(ProfileEntity profileEntity);

    ProfileEntity getProfileById(Long profileId);

    void updateProfile(ProfileEntity profileEntity);

    void deleteProfile(ProfileEntity profileEntity);

    List<ProfileEntity> getAllTheProfiles();

    List<ProfileEntity> getAllTheProfilesOfFriends(Long currentLoggedUserProfileId);

    List<ProfileEntity> getAllTheProfilesOfNonPendingAndNotFriends(Long currentLoggedUserProfileId, String currentLoggedUsername);

    List<ProfileEntity> getAllTheProfilesOneParameter(String request);
}
