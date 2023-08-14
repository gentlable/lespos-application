
package jp.co.fullhouse.lespos.lesposapplication.model.entity;

import java.sql.Timestamp;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "images")
@Getter
@Setter
public class Image {

  @Id
  @Column(length = 36, nullable = false, unique = true)
  private String id = UUID.randomUUID().toString();

  @Column(name = "file_path", nullable = false, length = 255)
  private String filePath;

  @Column(name = "content_type", nullable = false, length = 50)
  private String contentType = "application/pdf";

  @Column(name = "created_at", nullable = false, insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  @Temporal(TemporalType.TIMESTAMP)
  private Timestamp createdAt;

  @Column(name = "updated_at", nullable = false, insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  @Temporal(TemporalType.TIMESTAMP)
  private Timestamp updatedAt;
}
