package by.peshko.soccms.dao;

import by.peshko.soccms.model.ProfileEntity;

import java.util.List;

public interface ProfileDao {

    ProfileEntity createProfile(ProfileEntity profileEntity);

    ProfileEntity getById(Long profileId);

    void updateProfile(ProfileEntity profileEntity);

    void deleteProfile(ProfileEntity profileEntity);

    List<ProfileEntity> getAllTheProfiles();

    List<ProfileEntity> getAllTheProfilesTwoParametres(String firstname, String lastname);

    List<ProfileEntity> getAllTheProfilesOneParameter(String parametr);

}
