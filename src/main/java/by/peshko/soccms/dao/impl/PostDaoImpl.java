package by.peshko.soccms.dao.impl;

import by.peshko.soccms.dao.PostDao;
import by.peshko.soccms.model.PostEntity;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("postDao")
@Transactional
public class PostDaoImpl extends AbstractBaseDAO implements PostDao {

    private static final String GET_ALL_POSTS_QUERY
            = "FROM PostEntity WHERE wall_owner_profile_id = :wallOwnerProfileID ORDER BY postDate DESC";

    @Override
    public PostEntity createPost(final PostEntity postEntity) {
        super.save(postEntity);
        return postEntity;
    }

    @Override
    public void updatePost(final PostEntity postEntity) {
        super.udate(postEntity);
    }

    @Override
    public void deletePost(final PostEntity postEntity) {
        super.delete(postEntity);
    }

    @Override
    public List<PostEntity> getAllThePosts(final Long wallOwnerProfileID) {
        Query query = super.getCurrentSession().createQuery(GET_ALL_POSTS_QUERY);
        query.setParameter("wallOwnerProfileID", wallOwnerProfileID);

        return query.list();
    }

    @Override
    public PostEntity getById(final Long postId) {
        return (PostEntity) super.getById(PostEntity.class, postId);
    }
}