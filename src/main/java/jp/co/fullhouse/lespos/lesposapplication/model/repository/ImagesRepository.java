package jp.co.fullhouse.lespos.lesposapplication.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jp.co.fullhouse.lespos.lesposapplication.model.entity.Image;

@Repository
public interface ImagesRepository extends JpaRepository<Image, String> {
  @Query(value = "INSERT INTO images (file_path, content_type) VALUES (:filePath, :contentType)", nativeQuery = true)
  @Modifying
  void insert(@Param("filePath") String filePath, @Param("contentType") String contentType);

}
