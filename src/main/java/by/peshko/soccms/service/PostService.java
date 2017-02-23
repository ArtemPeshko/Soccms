package by.peshko.soccms.service;

import by.peshko.soccms.model.PostEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PostService {

    PostEntity createPost(PostEntity postEntity, MultipartFile photo);

    void updatePost(PostEntity postEntity);

    void deletePost(PostEntity postEntity);

    List<PostEntity> getAllThePosts(Long wallOwnerProfileID);

    PostEntity getById(Long postId);
}