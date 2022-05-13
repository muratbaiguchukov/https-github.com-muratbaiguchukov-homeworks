package kg.example6.country.service;

import kg.example6.country.entity.Image;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface ImageService {
    Image save(MultipartFile image);

    List<Image> getAll();


}
