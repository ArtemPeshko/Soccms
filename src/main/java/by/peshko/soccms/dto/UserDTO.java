package by.peshko.soccms.dto;

import java.io.Serializable;


public class UserDTO implements Serializable {
    private static final int HASH_NUMBER = 31;
    private Long id;
    private String email;
    private String username;
    private String password;
    private String newPassword;
    private boolean enabled;
    private String confirmPassword;
    private ProfileDTO profileDTO;
    private RoleDTO roleDTO;

    public void setConfirmPassword(final String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public Long getId() {
        return id;
    }

    public ProfileDTO getProfileDTO() {
        return profileDTO;
    }

    public void setRoleDTO(final RoleDTO roleDTO) {
        this.roleDTO = roleDTO;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public RoleDTO getRoleDTO() {
        return roleDTO;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public void setProfileDTO(final ProfileDTO profileDTO) {
        this.profileDTO = profileDTO;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public void setEnabled(final boolean enabled) {
        this.enabled = enabled;
    }

    public void setNewPassword(final String newPassword) {
        this.newPassword = newPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UserDTO)) {
            return false;
        }

        UserDTO userDTO = (UserDTO) o;

        if (isEnabled() != userDTO.isEnabled()) {
            return false;
        }
        if (!getId().equals(userDTO.getId())) {
            return false;
        }
        if (!getEmail().equals(userDTO.getEmail())) {
            return false;
        }
        if (!getUsername().equals(userDTO.getUsername())) {
            return false;
        }
        if (!getPassword().equals(userDTO.getPassword())) {
            return false;
        }
        if (getNewPassword() != null ? !getNewPassword().equals(userDTO.getNewPassword()) : userDTO.getNewPassword() != null) {
            return false;
        }
        if (getConfirmPassword() != null ? !getConfirmPassword().equals(userDTO.getConfirmPassword()) :
                userDTO.getConfirmPassword() != null) {
            return false;
        }
        if (!getProfileDTO().equals(userDTO.getProfileDTO())) {
            return false;
        }
        return getRoleDTO().equals(userDTO.getRoleDTO());

    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = HASH_NUMBER * result + getEmail().hashCode();
        result = HASH_NUMBER * result + getUsername().hashCode();
        result = HASH_NUMBER * result + getPassword().hashCode();
        result = HASH_NUMBER * result + (getNewPassword() != null ? getNewPassword().hashCode() : 0);
        result = HASH_NUMBER * result + (isEnabled() ? 1 : 0);
        result = HASH_NUMBER * result + (getConfirmPassword() != null ? getConfirmPassword().hashCode() : 0);
        result = HASH_NUMBER * result + getProfileDTO().hashCode();
        result = HASH_NUMBER * result + getRoleDTO().hashCode();
        return result;
    }
}