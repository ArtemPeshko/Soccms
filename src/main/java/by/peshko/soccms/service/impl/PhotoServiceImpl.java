package by.peshko.soccms.service.impl;

import by.peshko.soccms.dao.PhotoDao;
import by.peshko.soccms.model.PhotoEntity;
import by.peshko.soccms.service.PhotoService;
import by.peshko.soccms.component.PhotoCreationOnHDD;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@Service("photoService")
public class PhotoServiceImpl implements PhotoService {
    private static final Logger LOGGER = Logger.getLogger(PhotoServiceImpl.class);

    @Autowired
    private PhotoDao photoDao;
    @Autowired
    private PhotoCreationOnHDD photoCreationOnHDD;

    @Transactional
    public PhotoEntity createPhoto(final PhotoEntity photoEntity, final MultipartFile photo) {
        UUID namePicture = photoCreationOnHDD.createPhotoOnHDD(photo);
        photoEntity.setPhotoFileName("photo/" + namePicture + ".jpg");
        LOGGER.info("Saved photo for profileID " + photoEntity.getProfileEntity());

        return photoDao.createPhoto(photoEntity);
    }

    @Transactional
    public void updatePhoto(final PhotoEntity photoEntity) {
        LOGGER.info("Updated photo with ID " + photoEntity.getId());
        photoDao.updatePhoto(photoEntity);
    }

    @Transactional
    public void deletePhoto(final PhotoEntity photoEntity) {
        LOGGER.info("Deleted photo with ID " + photoEntity.getId());
        photoDao.deletePhoto(photoEntity);
    }

    @Transactional(readOnly = true)
    public List<PhotoEntity> getAllThePhotos(final Long profileID) {
        LOGGER.info("Got list of photos for profileID " + profileID);
        return photoDao.getAllThePhotos(profileID);
    }

    @Transactional(readOnly = true)
    public PhotoEntity getById(final Long photoId) {
        LOGGER.info("Got photo with ID " + photoId);
        return photoDao.getById(photoId);
    }

}