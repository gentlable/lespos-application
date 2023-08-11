
package jp.co.fullhouse.lespos.lesposapplication.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImageDto {

  private String id;
  private String filePath;
  private String contentType;
  private String createdAt;
  private String updatedAt;
}
