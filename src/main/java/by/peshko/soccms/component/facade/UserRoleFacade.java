package by.peshko.soccms.component.facade;

import by.peshko.soccms.model.RoleEntity;

public interface UserRoleFacade {

    RoleEntity createUserRole(RoleEntity userRole);

    void updateUserRole(RoleEntity userRole);

    void deleteUserRole(RoleEntity userRole);
}
