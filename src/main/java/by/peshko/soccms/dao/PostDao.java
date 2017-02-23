package by.peshko.soccms.dao;

import by.peshko.soccms.model.PostEntity;

import java.util.List;

public interface PostDao {

    PostEntity createPost(PostEntity postEntity);

    void updatePost(PostEntity postEntity);

    void deletePost(PostEntity postEntity);

    List<PostEntity> getAllThePosts(Long wallOwnerProfileID);

    PostEntity getById(Long postId);
}