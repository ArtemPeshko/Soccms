package by.peshko.soccms.dto;

import java.io.Serializable;

public class RoleDTO implements Serializable {
    private Long id;
    private String role;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(final String role) {
        this.role = role;
    }
}