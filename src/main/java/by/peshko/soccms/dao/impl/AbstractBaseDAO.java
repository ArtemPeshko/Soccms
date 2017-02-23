package by.peshko.soccms.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository("abstractDao")
public abstract class AbstractBaseDAO {
    @Autowired
    private SessionFactory sessionFactory;

    void save(final Object object) {
        sessionFactory.getCurrentSession().save(object);
    }

    public Object getById(final Class<?> clazz, final Long id) {
        return getCurrentSession().get(clazz, id);
    }

    void udate(final Object object) {
        sessionFactory.getCurrentSession().update(object);
    }

    void delete(final Object object) {
        sessionFactory.getCurrentSession().delete(object);
    }

    Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}