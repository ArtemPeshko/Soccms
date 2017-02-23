package by.peshko.soccms.dao;

import by.peshko.soccms.model.PhotoEntity;

import java.util.List;

public interface PhotoDao {

    PhotoEntity createPhoto(PhotoEntity photoEntity);

    void updatePhoto(PhotoEntity photoEntity);

    void deletePhoto(PhotoEntity photoEntity);

    List<PhotoEntity> getAllThePhotos(Long profileID);

    PhotoEntity getById(Long photoId);
}