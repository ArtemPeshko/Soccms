package by.peshko.soccms.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "post")
public class PostEntity implements Serializable {
    private static final int MAX_TEXT_LENGTH = 1024;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postID;

    @Column(name = "date")
    private Date postDate;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_sender_id")
    private ProfileEntity profileSender;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "wall_owner_profile_id")
    private ProfileEntity wallOwnerProfile;

    @Column(name = "text", length = MAX_TEXT_LENGTH)
    private String text;

    @Column(name = "photo_file_name")
    private String photoFileName;

    public Date getPostDate() {
        return postDate;
    }

    public Long getPostID() {
        return postID;
    }

    public void setText(final String text) {
        this.text = text;
    }

    public void setPostID(final Long postID) {
        this.postID = postID;
    }

    public String getText() {
        return text;
    }

    public void setPostDate(final Date postDate) {
        this.postDate = postDate;
    }

    public void setProfileSender(final ProfileEntity profileSender) {
        this.profileSender = profileSender;
    }

    public ProfileEntity getProfileSender() {
        return profileSender;
    }

    public ProfileEntity getWallOwnerProfile() {
        return wallOwnerProfile;
    }

    public void setWallOwnerProfile(final ProfileEntity wallOwnerProfile) {
        this.wallOwnerProfile = wallOwnerProfile;
    }

    public void setPhotoFileName(final String photoFileName) {
        this.photoFileName = photoFileName;
    }

    public String getPhotoFileName() {
        return photoFileName;
    }
}