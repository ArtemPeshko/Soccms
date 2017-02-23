package by.peshko.soccms.component.facade;

import by.peshko.soccms.dto.PhotoDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PhotoFacade {

    void createPhoto(PhotoDTO photoDTO, MultipartFile photo);

    void updatePhoto(PhotoDTO photoDTO);

    void deletePhoto(PhotoDTO photoDTO);

    List<PhotoDTO> getAllThePhotos(Long profileID);

    PhotoDTO getById(Long photoId);
}