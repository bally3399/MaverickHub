package com.mavericktube.maverickHub.dto.request;

import com.mavericktube.maverickHub.models.Category;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
@Getter
@Setter
public class UpdateMediaRequest {
    private MultipartFile mediaFile;
    private String description;
    private Category category;
    private Long userId;
}
