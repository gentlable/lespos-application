package jp.co.fullhouse.lespos.lesposapplication.model.form;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FileUploadForm {

  private MultipartFile multipartFile;

  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime createAt;

  private String id;
  @NotBlank
  private String filePath;
  @NotBlank
  private String contentType;

}