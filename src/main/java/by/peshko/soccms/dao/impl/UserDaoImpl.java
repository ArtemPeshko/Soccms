package by.peshko.soccms.dao.impl;

import by.peshko.soccms.dao.UserDao;
import by.peshko.soccms.model.UserEntity;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository("userDao")
public class UserDaoImpl extends AbstractBaseDAO implements UserDao {
    private static final String GET_USER_BY_USERNAME_QUERY = "FROM UserEntity WHERE username = :username";
    private static final String GET_USER_BY_USERNAME_OR_EMAIL_QUERY = "FROM UserEntity WHERE username = :username OR email = " +
            ":email";
    private static final String GET_ALL_USERS_QUERY = "SELECT * FROM user";

    public UserEntity createUser(final UserEntity user) {
        super.save(user);
        return user;
    }

    public UserEntity updateUser(final UserEntity user) {
        super.udate(user);
        return user;
    }

    public void deleteUser(final UserEntity user) {
        super.delete(user);
    }

    public UserEntity getUserByUsername(final String username) {
        Query query = super.getCurrentSession().createQuery(GET_USER_BY_USERNAME_QUERY);
        query.setParameter("username", username);

        List objects = query.list();
        if (objects.size() > 0) {
            return (UserEntity) objects.get(0);
        }
        return null;
    }

    public List<UserEntity> getAllTheUsers() {
        Query query = super.getCurrentSession().createNativeQuery(GET_ALL_USERS_QUERY, UserEntity.class);
        return query.list();
    }

    public List<UserEntity> getUserByUsernameOrEmail(final String username, final String email) {
        Query query = super.getCurrentSession().createQuery(GET_USER_BY_USERNAME_OR_EMAIL_QUERY);
        query.setParameter("username", username);
        query.setParameter("email", email);

        return query.list();
    }

    public UserEntity getById(final Long userId) {
        return (UserEntity) super.getById(UserEntity.class, userId);
    }
}
