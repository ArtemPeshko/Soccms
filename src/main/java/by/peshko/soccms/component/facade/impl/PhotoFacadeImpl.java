package by.peshko.soccms.component.facade.impl;

import by.peshko.soccms.dto.PhotoDTO;
import by.peshko.soccms.component.facade.PhotoFacade;
import by.peshko.soccms.model.PhotoEntity;
import by.peshko.soccms.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Component("photoFacade")
public class PhotoFacadeImpl implements PhotoFacade {
    @Autowired
    private PhotoService photoService;
    @Autowired
    private ConversionService conversionService;

    public void createPhoto(final PhotoDTO photoDTO, final MultipartFile photo) {
        photoService.createPhoto(conversionService.convert(photoDTO, PhotoEntity.class), photo);
    }

    public void updatePhoto(final PhotoDTO photoDTO) {
        photoService.updatePhoto(conversionService.convert(photoDTO, PhotoEntity.class));
    }

    public void deletePhoto(final PhotoDTO photoDTO) {
        PhotoEntity photoEntity = conversionService.convert(photoDTO, PhotoEntity.class);
        photoService.deletePhoto(photoEntity);
    }

    public List<PhotoDTO> getAllThePhotos(final Long profileID) {
        List<PhotoDTO> allThePhotoDTOs = new ArrayList<>();

        photoService.getAllThePhotos(profileID).forEach(elem -> allThePhotoDTOs.add(conversionService.convert(elem, PhotoDTO
                .class)));

        return allThePhotoDTOs;
    }

    public PhotoDTO getById(final Long photoId) {
        return conversionService.convert(photoService.getById(photoId), PhotoDTO.class);
    }
}