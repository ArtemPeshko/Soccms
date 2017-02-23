package by.peshko.soccms.component.facade.impl;

import by.peshko.soccms.component.facade.UserRoleFacade;
import by.peshko.soccms.model.RoleEntity;
import by.peshko.soccms.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("userRoleFacade")
public class UserRoleFacadeImpl implements UserRoleFacade {
    @Autowired
    private UserRoleService userRoleService;

    public RoleEntity createUserRole(final RoleEntity userRole) {
        return userRoleService.createUserRole(userRole);
    }

    public void updateUserRole(final RoleEntity userRole) {
        userRoleService.updateUserRole(userRole);
    }

    public void deleteUserRole(final RoleEntity userRole) {
        userRoleService.deleteUserRole(userRole);
    }
}
