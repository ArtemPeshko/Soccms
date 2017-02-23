package by.peshko.soccms.component.facade.impl;

import by.peshko.soccms.dto.ProfileDTO;
import by.peshko.soccms.component.facade.ProfileFacade;
import by.peshko.soccms.model.ProfileEntity;
import by.peshko.soccms.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component("profileFacade")
public class ProfileFacadeImpl implements ProfileFacade {
    @Autowired
    private ProfileService profileService;
    @Autowired
    private ConversionService conversionService;

    public void createProfile(final ProfileDTO profileDTO) {
        profileService.createProfile(conversionService.convert(profileDTO, ProfileEntity.class));
    }

    public ProfileDTO getProfileById(final Long profileId) {
        return conversionService.convert(profileService.getProfileById(profileId), ProfileDTO.class);
    }

    public void updateProfile(final ProfileDTO profileDTO) {
        profileService.updateProfile(conversionService.convert(profileDTO, ProfileEntity.class));
    }

    public void deleteProfile(final ProfileDTO profileDTO) {
        profileService.deleteProfile(conversionService.convert(profileDTO, ProfileEntity.class));
    }

    public List<ProfileDTO> getAllTheProfiles() {
        List<ProfileDTO> allTheDTOProfiles = new ArrayList<>();

        profileService.getAllTheProfiles().
                forEach(element -> allTheDTOProfiles.add(conversionService.convert(element, ProfileDTO.class)));

        return allTheDTOProfiles;
    }

    public Set<ProfileDTO> getAllTheProfilesOfFriends(final Long currentLoggedUserProfileId) {
        Set<ProfileDTO> allTheProfilesDTO = new HashSet<>();

        profileService.getAllTheProfilesOfFriends(currentLoggedUserProfileId).
                forEach(element -> allTheProfilesDTO.add(conversionService.convert(element, ProfileDTO.class)));

        return allTheProfilesDTO;
    }

    public Set<ProfileDTO> getAllTheProfilesOfNonPendingAndNotFriends(final Long currentLoggedUserProfileId,
                                                                      final String currentLoggedUsername) {
        Set<ProfileDTO> allTheProfilesDTO = new HashSet<>();

        profileService.getAllTheProfilesOfNonPendingAndNotFriends(currentLoggedUserProfileId, currentLoggedUsername).
                forEach(element -> allTheProfilesDTO.add(conversionService.convert(element, ProfileDTO.class)));

        return allTheProfilesDTO;
    }

    @Override
    public List<ProfileDTO> getAllTheProfilesOneParameter(final String request) {
        List<ProfileDTO> allTheProfilesDTO = new ArrayList<>();
        profileService.getAllTheProfilesOneParameter(request)
                .forEach(element -> allTheProfilesDTO.add(conversionService.convert(element, ProfileDTO.class)));
        return allTheProfilesDTO;
    }
}
