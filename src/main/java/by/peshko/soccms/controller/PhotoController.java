package by.peshko.soccms.controller;

import by.peshko.soccms.dto.PhotoDTO;
import by.peshko.soccms.dto.ProfileDTO;
import by.peshko.soccms.dto.UserDTO;
import by.peshko.soccms.component.facade.PhotoFacade;
import by.peshko.soccms.component.facade.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class PhotoController {
    @Autowired
    private PhotoFacade photoFacade;

    @Autowired
    private UserFacade userFacade;

    @RequestMapping(value = "/photos", method = RequestMethod.GET)
    public String visitPhotoMenuItem(final Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetail = (UserDetails) auth.getPrincipal();

        UserDTO userDTO = userFacade.getUserByUsername(userDetail.getUsername());
        ProfileDTO profileDTO = userDTO.getProfileDTO();

        model.addAttribute("photoDTO", new PhotoDTO());
        model.addAttribute("allThePhotos", photoFacade.getAllThePhotos(profileDTO.getProfileID()));
        model.addAttribute("homedir", System.getProperty("user.home").replaceAll("\\\\", "/"));

        return "/photos";
    }

    @RequestMapping(value = "/photos/photoupload/{currenLoggedUserName}", method = RequestMethod.POST)
    public String uploadPhoto(@ModelAttribute("photoDTO") final PhotoDTO photoDTO, @RequestParam("photo") final MultipartFile file,
                              @PathVariable(value = "currenLoggedUserName") final String currenLoggedUserName) {
        UserDTO userDTO = userFacade.getUserByUsername(currenLoggedUserName);
        ProfileDTO profileDTO = userDTO.getProfileDTO();

        photoDTO.setProfileDTO(profileDTO);

        photoFacade.createPhoto(photoDTO, file);
        return "redirect:/photos";
    }

    @RequestMapping(value = "/photos/delete/{photoID}", method = RequestMethod.GET)
    public String deletePhoto(@PathVariable(value = "photoID") final String photoID) {
        PhotoDTO photoDTO = photoFacade.getById(Long.valueOf(photoID));
        photoFacade.deletePhoto(photoDTO);
        return "redirect:/photos";
    }

}