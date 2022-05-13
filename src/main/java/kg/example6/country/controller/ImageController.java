package kg.example6.country.controller;

import kg.example6.country.entity.Image;
import kg.example6.country.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class ImageController {
    @Autowired
    ImageService imageService;

    @PostMapping
    public Image saveImage(@RequestParam("image") MultipartFile image) {
        return imageService.save(image);
    }

    @GetMapping
    public List<Image> getAll() {
        return imageService.getAll();
    }
}
