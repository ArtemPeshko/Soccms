package by.peshko.soccms.service;

import by.peshko.soccms.model.PhotoEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PhotoService {

    PhotoEntity createPhoto(PhotoEntity photoEntity, MultipartFile photo);

    void updatePhoto(PhotoEntity photoEntity);

    void deletePhoto(PhotoEntity photoEntity);

    List<PhotoEntity> getAllThePhotos(Long profileID);

    PhotoEntity getById(Long photoId);
}
