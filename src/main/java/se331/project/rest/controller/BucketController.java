package se331.project.rest.controller;

import jakarta.servlet.ServletException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import se331.project.rest.util.CloudStorageHelper;
import se331.project.rest.util.LabMapper;

import java.io.IOException;
@Controller
@RequiredArgsConstructor
public class BucketController {
    final CloudStorageHelper cloudStorageHelper;

    @PostMapping("/uploadFile")
    public ResponseEntity<?> uploadFile(@RequestPart(value = "file")
                                        MultipartFile file) throws IOException, ServletException {
        return
                ResponseEntity.ok(this.cloudStorageHelper.getImageUrl(file,"uploadimagepro-5d83e.appspot.com"));

    }

    @PostMapping("/uploadsFile2")
    public ResponseEntity<?> uploadFile2(@RequestPart(value = "file2")
                                        MultipartFile file) throws IOException, ServletException {

        return
                ResponseEntity.ok(this.cloudStorageHelper.getFileUrl(file,"uploadimagepro-5d83e.appspot.com"));
    }
    @PostMapping("/uploadImage")
    public ResponseEntity<?> uploadFileComponent(@RequestPart(value = "image" )
                                                 MultipartFile file) throws IOException, ServletException{
        return
                ResponseEntity.ok((this.cloudStorageHelper.getStorageFileDto(file,"uploadimagepro-5d83e.appspot.com")));
    }

    @PostMapping("/uploadImage2")
    public ResponseEntity<?> uploadFileComponent2(@RequestPart(value = "image2" )
                                                 MultipartFile file) throws IOException, ServletException{
        return
                ResponseEntity.ok((this.cloudStorageHelper.getStorageFileDto2(file,"uploadimagepro-5d83e.appspot.com")));
    }
}
