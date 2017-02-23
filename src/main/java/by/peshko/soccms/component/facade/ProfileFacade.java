package by.peshko.soccms.component.facade;

import by.peshko.soccms.dto.ProfileDTO;

import java.util.List;
import java.util.Set;

public interface ProfileFacade {


    void createProfile(ProfileDTO profileDTO);

    ProfileDTO getProfileById(Long profileId);

    void updateProfile(ProfileDTO profileDTO);

    void deleteProfile(ProfileDTO profileDTO);

    List<ProfileDTO> getAllTheProfiles();

    Set<ProfileDTO> getAllTheProfilesOfFriends(Long currentLoggedUserProfileId);

    Set<ProfileDTO> getAllTheProfilesOfNonPendingAndNotFriends(Long currentLoggedUserProfileId, String currentLoggedUsername);

    List<ProfileDTO> getAllTheProfilesOneParameter(String reqiest);

}
