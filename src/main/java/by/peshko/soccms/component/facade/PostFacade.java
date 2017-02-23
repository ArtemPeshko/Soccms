package by.peshko.soccms.component.facade;

import by.peshko.soccms.dto.PostDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PostFacade {

    void createPost(PostDTO postDTO, MultipartFile file);

    void updatePost(PostDTO postDTO);

    void deletePost(PostDTO postDTO);

    List<PostDTO> getAllThePosts(Long wallOwnerProfileID);

    PostDTO getById(Long postId);
}