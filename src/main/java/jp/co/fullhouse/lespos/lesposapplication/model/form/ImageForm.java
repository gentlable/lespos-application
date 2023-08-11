package jp.co.fullhouse.lespos.lesposapplication.model.form;

import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotBlank;

@Getter
@Setter
public class ImageForm {
  private String id;
  @NotBlank
  private String filePath;
  @NotBlank
  private String contentType;

}
