package by.peshko.soccms.service.impl;

import by.peshko.soccms.dao.PostDao;
import by.peshko.soccms.model.PostEntity;
import by.peshko.soccms.service.PostService;
import by.peshko.soccms.component.PhotoCreationOnHDD;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@Service("postService")
public class PostServiceImpl implements PostService {
    private static final Logger LOGGER = Logger.getLogger(PostServiceImpl.class);

    @Autowired
    private PostDao postDao;
    @Autowired
    private PhotoCreationOnHDD photoCreationOnHDD;

    @Transactional
    public PostEntity createPost(final PostEntity postEntity, final MultipartFile photo) {
        if (photo.getSize() > 0) {
            UUID namePicture = photoCreationOnHDD.createPhotoOnHDD(photo);
            postEntity.setPhotoFileName("photo/" + namePicture + ".jpg");
        }
        LOGGER.info("Added post for profileID " + postEntity.getWallOwnerProfile().getId());
        return postDao.createPost(postEntity);
    }

    @Transactional
    public void updatePost(final PostEntity postEntity) {
        LOGGER.info("Updated post with ID " + postEntity.getPostID());
        postDao.updatePost(postEntity);
    }

    @Transactional
    public void deletePost(final PostEntity postEntity) {
        LOGGER.info("Deleted post with ID " + postEntity.getPostID());
        postDao.deletePost(postEntity);
    }

    @Transactional(readOnly = true)
    public List<PostEntity> getAllThePosts(final Long wallOwnerProfileID) {
        LOGGER.info("Got list of posts for profileID " + wallOwnerProfileID);
        return postDao.getAllThePosts(wallOwnerProfileID);
    }

    @Transactional(readOnly = true)
    public PostEntity getById(final Long postId) {
        LOGGER.info("Got posts with ID " + postId);
        return postDao.getById(postId);
    }
}