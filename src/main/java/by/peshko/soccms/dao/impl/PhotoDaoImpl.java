package by.peshko.soccms.dao.impl;

import by.peshko.soccms.dao.PhotoDao;
import by.peshko.soccms.model.PhotoEntity;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("photoDao")
@Transactional
public class PhotoDaoImpl extends AbstractBaseDAO implements PhotoDao {
    private static final String GET_ALL_PHOTOS_QUERY = "FROM PhotoEntity WHERE profileID = :profileID";

    @Override
    public PhotoEntity createPhoto(final PhotoEntity photoEntity) {
        super.save(photoEntity);
        return photoEntity;
    }

    @Override
    public void updatePhoto(final PhotoEntity photoEntity) {
        super.udate(photoEntity);
    }

    @Override
    public void deletePhoto(final PhotoEntity photoEntity) {
        super.delete(photoEntity);
    }

    @Override
    public List<PhotoEntity> getAllThePhotos(final Long profileID) {
        Query query = super.getCurrentSession().createQuery(GET_ALL_PHOTOS_QUERY);
        query.setParameter("profileID", profileID);
        return query.list();
    }

    @Override
    public PhotoEntity getById(final Long photoId) {
        return (PhotoEntity) super.getById(PhotoEntity.class, photoId);
    }
}