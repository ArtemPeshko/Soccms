package by.peshko.soccms.dao.impl;

import by.peshko.soccms.dao.UserRoleDao;
import by.peshko.soccms.model.RoleEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("userRoleDao")
@Transactional
public class UserRoleDaoImpl extends AbstractBaseDAO implements UserRoleDao {

    public RoleEntity createUserRole(final RoleEntity userRole) {
        super.save(userRole);
        return userRole;
    }

    public void updateUserRole(final RoleEntity userRole) {
        super.udate(userRole);
    }

    public void deleteUserRole(final RoleEntity userRole) {
        super.delete(userRole);
    }

    public Object getById(final Long userRoleId) {
        return super.getById(RoleEntity.class, userRoleId);
    }
}
