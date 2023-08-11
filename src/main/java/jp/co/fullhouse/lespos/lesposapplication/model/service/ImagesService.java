package jp.co.fullhouse.lespos.lesposapplication.model.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import jp.co.fullhouse.lespos.lesposapplication.model.entity.Image;
import jp.co.fullhouse.lespos.lesposapplication.model.dto.ImageDto;
import jp.co.fullhouse.lespos.lesposapplication.model.form.FileUploadForm;
import jp.co.fullhouse.lespos.lesposapplication.model.repository.ImagesRepository;

@Service
public class ImagesService {

  @Autowired
  ImagesRepository imageRepository;

  /**
   * 画像情報を取得する。
   * 
   * @param id
   * @return
   */
  public ImageDto getImage(String id) {
    return imageRepository.findById(id).map(image -> {
      ImageDto dto = new ImageDto();
      BeanUtils.copyProperties(image, dto);
      return dto;
    }).orElse(null);
  }

  /**
   * 画像情報を登録する。
   * 
   */
  @Transactional
  public Image createImage(FileUploadForm form) {

    Image image = new Image();
    image.setFilePath(form.getFilePath());

    image = imageRepository.save(image);

    return image;
  }

}
