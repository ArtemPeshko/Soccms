package by.peshko.soccms.model;

import javax.persistence.*;

@Entity
@Table(name = "photo")
public class PhotoEntity {
    private static final int MAX_TEXT_LENGTH = 64;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "photo_file_name", length = MAX_TEXT_LENGTH)
    private String photoFileName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profileID")
    private ProfileEntity profileEntity;

    public Long getId() {
        return id;
    }

    public String getPhotoFileName() {
        return photoFileName;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public void setPhotoFileName(final String photoFileName) {
        this.photoFileName = photoFileName;
    }

    public ProfileEntity getProfileEntity() {
        return profileEntity;
    }

    public void setProfileEntity(final ProfileEntity profileEntity) {
        this.profileEntity = profileEntity;
    }
}