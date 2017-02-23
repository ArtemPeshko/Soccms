package by.peshko.soccms.component;

import by.peshko.soccms.dto.ProfileDTO;
import by.peshko.soccms.dto.UserDTO;
import by.peshko.soccms.component.facade.ProfileFacade;
import by.peshko.soccms.component.facade.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RequestSplitterForUserAndProfile {
    @Autowired
    private ProfileFacade profileFacade;
    @Autowired
    private UserFacade userFacade;

    public List<Object> getUserDTOAndProfileDTO(final String request) {
        List<Object> result = new ArrayList<Object>();

        String[] twoValuesFromDeleteRequest = request.split("&");
        String currentLoggedUsername = twoValuesFromDeleteRequest[0];
        Long friendProfileId = Long.valueOf(twoValuesFromDeleteRequest[1]);

        UserDTO currentLoggedUserDTO = userFacade.getUserByUsername(currentLoggedUsername);
        ProfileDTO friendProfileDTO = profileFacade.getProfileById(friendProfileId);

        result.add(currentLoggedUserDTO);
        result.add(friendProfileDTO);

        return result;
    }
}