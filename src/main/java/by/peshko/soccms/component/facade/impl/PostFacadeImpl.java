package by.peshko.soccms.component.facade.impl;

import by.peshko.soccms.dto.PostDTO;
import by.peshko.soccms.component.facade.PostFacade;
import by.peshko.soccms.model.PostEntity;
import by.peshko.soccms.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Component("postFacade")

public class PostFacadeImpl implements PostFacade {
    @Autowired
    private PostService postService;
    @Autowired
    private ConversionService conversionService;

    @Override
    public void createPost(final PostDTO postDTO, final MultipartFile file) {
        postService.createPost(conversionService.convert(postDTO, PostEntity.class), file);
    }

    @Override
    public void updatePost(final PostDTO postDTO) {
        postService.updatePost(conversionService.convert(postDTO, PostEntity.class));
    }

    @Override
    public void deletePost(final PostDTO postDTO) {
        postService.deletePost(conversionService.convert(postDTO, PostEntity.class));

    }

    @Override
    public List<PostDTO> getAllThePosts(final Long wallOwnerProfileID) {
        List<PostDTO> allThePostsDTO = new ArrayList<>();

        postService.getAllThePosts(wallOwnerProfileID)
                .forEach(element -> allThePostsDTO.add(conversionService.convert(element, PostDTO.class)));

        return allThePostsDTO;
    }

    @Override
    public PostDTO getById(final Long postId) {
        return conversionService.convert(postService.getById(postId), PostDTO.class);
    }
}