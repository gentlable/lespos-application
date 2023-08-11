package jp.co.fullhouse.lespos.lesposapplication.model.service;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import jp.co.fullhouse.lespos.lesposapplication.model.form.FileUploadForm;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.core.ResponseBytes;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.core.sync.ResponseTransformer;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.S3Exception;

@Service
public class S3Service {

  private S3Client s3Client;

  @PostConstruct
  public void init() {
    this.s3Client = S3Client.builder()
        .region(Region.US_EAST_2)
        .credentialsProvider(StaticCredentialsProvider.create(AwsBasicCredentials.create(accessKey, secretKey)))
        .build();
  }

  @Value("${aws.credentials.accessKey}")
  private String accessKey;

  @Value("${aws.credentials.secretKey}")
  private String secretKey;

  @Value("${aws.s3.bucket}")
  private String bucket;

  public String fileUpload(FileUploadForm fileUploadForm, String s3PathName) {
    DateTimeFormatter fm = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
    String extension = FilenameUtils.getExtension(fileUploadForm.getMultipartFile().getOriginalFilename())
        .toLowerCase();
    String fileName = fileUploadForm.getCreateAt().format(fm) + "." + extension;

    try {
      byte[] bytes = fileUploadForm.getMultipartFile().getBytes();

      s3Client.putObject(PutObjectRequest.builder()
          .bucket(bucket)
          .key(s3PathName + fileName)
          .build(),
          RequestBody.fromBytes(bytes));

      return s3PathName + fileName;
    } catch (S3Exception e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    } catch (IOException e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }

  public String fileDownload(String s3PathName) {
    try {

      // Path destPath = Files.createTempFile("s3-object-", "");

      GetObjectRequest getObjectRequest = GetObjectRequest.builder()
          .bucket(bucket)
          .key(s3PathName)
          .build();

      // s3Client.getObject(getObjectRequest, ResponseTransformer.toFile(destPath));
      ResponseBytes<GetObjectResponse> objectBytes = s3Client.getObject(getObjectRequest,
          ResponseTransformer.toBytes());
      byte[] bytes = objectBytes.asByteArray();
      // byte[] bytes = Files.readAllBytes(destPath);
      String base64Image = Base64.getEncoder().encodeToString(bytes);

      System.out.println("File downloaded successfully");
      return base64Image;

    } catch (S3Exception e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }
}
