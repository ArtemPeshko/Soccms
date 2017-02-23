package by.peshko.soccms.dao.impl;

import by.peshko.soccms.dao.ProfileDao;
import by.peshko.soccms.model.ProfileEntity;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("profileDao")
@Transactional
public class ProfileDaoImpl extends AbstractBaseDAO implements ProfileDao {
    private static final String GET_ALL_USER_PROFILES_QUERY = "SELECT * FROM profile";

    private static final String GET_ALL_USER_PROFILES_QUERY_TWO_PARAMETERS =
            "FROM ProfileEntity WHERE firstname LIKE :firstname OR " + "lastname LIKE :lastname";
    private static final String GET_ALL_USER_PROFILES_QUERY_ONE_PARAMETER =
            "FROM ProfileEntity WHERE firstname LIKE :parametr OR " + "lastname LIKE :parametr";

    public ProfileEntity createProfile(final ProfileEntity profile) {
        super.save(profile);
        return profile;
    }

    public ProfileEntity getById(final Long profileId) {
        return (ProfileEntity) super.getById(ProfileEntity.class, profileId);
    }

    public void updateProfile(final ProfileEntity profile) {
        super.udate(profile);
    }

    public void deleteProfile(final ProfileEntity profile) {
        super.delete(profile);
    }

    public List<ProfileEntity> getAllTheProfiles() {
        Query query = super.getCurrentSession().createNativeQuery(GET_ALL_USER_PROFILES_QUERY, ProfileEntity.class);
        return query.list();
    }

    @Override
    public List<ProfileEntity> getAllTheProfilesTwoParametres(final String firstname, final String lastname) {
        Query query = super.getCurrentSession().createQuery(GET_ALL_USER_PROFILES_QUERY_TWO_PARAMETERS);
        query.setParameter("firstname", "%" + firstname + "%");
        query.setParameter("lastname", "%" + lastname + "%");
        return query.list();
    }

    public List<ProfileEntity> getAllTheProfilesOneParameter(final String parametr) {
        Query query = super.getCurrentSession().createQuery(GET_ALL_USER_PROFILES_QUERY_ONE_PARAMETER);
        query.setParameter("parametr", "%" + parametr + "%");
        return query.list();
    }

}
