package kg.example6.country.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import kg.example6.country.entity.Image;
import kg.example6.country.repository.ImageRepository;
import kg.example6.country.service.ImageService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.util.List;
import java.util.Map;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ImageServiceImpl implements ImageService {

    @Autowired
    ImageRepository imageRepository;
    //CLOUDINARY_URL=cloudinary://CLOUDINARY_URL=cloudinary://769289587958335:QPwT8da4DxsYO5eaDIuH2fdNAwI@dkl6iptd6
    static final String CLOUDINARY_URL = "cloudinary://769289587958335:QPwT8da4DxsYO5eaDIuH2fdNAwI@dkl6iptd6";

    @Override
    public Image save(MultipartFile image) {
        File file;

        try {
            file = Files.createTempFile(System.currentTimeMillis() + "", image.getOriginalFilename().substring(image
                    .getOriginalFilename()
                    .length() - 4)).toFile();
            image.transferTo(file);

            Cloudinary cloudinary = new Cloudinary(CLOUDINARY_URL);
            Map uploadResult = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());

            Image imageTemp = Image.builder()
                    .imageName(image.getName())
                    .imageUrl((String) uploadResult.get("url"))
                    .build();
            return imageRepository.save(imageTemp);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Image> getAll() {
        return imageRepository.findAll();

    }
}
