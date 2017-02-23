package by.peshko.soccms.dto;

import java.io.Serializable;
import java.util.Date;

public class ProfileDTO implements Serializable {
    private static final int HASH_NUMBER = 31;
    private Long profileID;
    private String firstname;
    private String lastname;
    private String email;
    private Date birthDate;
    private Integer age;
    private String sex;
    private String city;
    private String phoneNumber;
    private UserDTO userDTO;

    public Date getBirthDate() {
        return birthDate;
    }

    public String getFirstname() {
        return firstname;
    }

    public Long getProfileID() {
        return profileID;
    }

    public String getLastname() {
        return lastname;
    }

    public void setSex(final String sex) {
        this.sex = sex;
    }

    public void setPhoneNumber(final String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setCity(final String city) {
        this.city = city;
    }

    public String getSex() {
        return sex;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public void setLastname(final String lastname) {
        this.lastname = lastname;
    }

    public void setAge(final Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public String getCity() {
        return city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setProfileID(final Long profileID) {
        this.profileID = profileID;
    }

    public void setBirthDate(final Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setFirstname(final String firstname) {
        this.firstname = firstname;
    }

    public Integer getAge() {
        return age;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(final UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ProfileDTO)) {
            return false;
        }

        ProfileDTO that = (ProfileDTO) o;

        if (getProfileID() != null ? !getProfileID().equals(that.getProfileID()) : that.getProfileID() != null) {
            return false;
        }
        if (getFirstname() != null ? !getFirstname().equals(that.getFirstname()) : that.getFirstname() != null) {
            return false;
        }
        if (getLastname() != null ? !getLastname().equals(that.getLastname()) : that.getLastname() != null) {
            return false;
        }
        if (getEmail() != null ? !getEmail().equals(that.getEmail()) : that.getEmail() != null) {
            return false;
        }
        if (getBirthDate() != null ? !getBirthDate().equals(that.getBirthDate()) : that.getBirthDate() != null) {
            return false;
        }
        if (getAge() != null ? !getAge().equals(that.getAge()) : that.getAge() != null) {
            return false;
        }
        if (getSex() != null ? !getSex().equals(that.getSex()) : that.getSex() != null) {
            return false;
        }
        if (getCity() != null ? !getCity().equals(that.getCity()) : that.getCity() != null) {
            return false;
        }
        return getPhoneNumber() != null ? getPhoneNumber().equals(that.getPhoneNumber()) : that.getPhoneNumber() == null;
    }

    @Override
    public int hashCode() {
        int result = getProfileID() != null ? getProfileID().hashCode() : 0;
        result = HASH_NUMBER * result + (getFirstname() != null ? getFirstname().hashCode() : 0);
        result = HASH_NUMBER * result + (getLastname() != null ? getLastname().hashCode() : 0);
        result = HASH_NUMBER * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = HASH_NUMBER * result + (getBirthDate() != null ? getBirthDate().hashCode() : 0);
        result = HASH_NUMBER * result + (getAge() != null ? getAge().hashCode() : 0);
        result = HASH_NUMBER * result + (getSex() != null ? getSex().hashCode() : 0);
        result = HASH_NUMBER * result + (getCity() != null ? getCity().hashCode() : 0);
        result = HASH_NUMBER * result + (getPhoneNumber() != null ? getPhoneNumber().hashCode() : 0);
        return result;
    }
}
