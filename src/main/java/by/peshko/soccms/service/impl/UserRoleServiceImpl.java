package by.peshko.soccms.service.impl;

import by.peshko.soccms.dao.UserRoleDao;
import by.peshko.soccms.model.RoleEntity;
import by.peshko.soccms.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userRoleService")
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private UserRoleDao userRoleDao;
    @Autowired
    private ReloadableResourceBundleMessageSource messageSource;

    @Transactional
    public RoleEntity createUserRole(final RoleEntity userRole) {
        userRoleDao.createUserRole(userRole);
        return userRole;
    }

    @Transactional
    public void updateUserRole(final RoleEntity userRole) {
        userRoleDao.updateUserRole(userRole);
    }

    @Transactional
    public void deleteUserRole(final RoleEntity userRole) {
        userRoleDao.deleteUserRole(userRole);
    }
}
