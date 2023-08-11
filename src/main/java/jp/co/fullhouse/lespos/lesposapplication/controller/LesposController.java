package jp.co.fullhouse.lespos.lesposapplication.controller;

import java.time.LocalDateTime;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.api.client.auth.oauth2.Credential;

import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jp.co.fullhouse.lespos.lesposapplication.model.form.FileUploadForm;
import jp.co.fullhouse.lespos.lesposapplication.model.service.GmailSender;
import jp.co.fullhouse.lespos.lesposapplication.model.service.S3Service;
import jp.co.fullhouse.lespos.lesposapplication.utils.GoogleApiUtils;
import lombok.AllArgsConstructor;

/**
 * 各機能への画面遷移を管理するコントローラー
 */
@Controller
public class LesposController {
  private final GmailSender gmailSender;
  private final S3Service s3Service;

  public LesposController(GmailSender gmailSender, S3Service s3Service) {
    this.gmailSender = gmailSender;
    this.s3Service = s3Service;
  }

  private String callbackUrl = "http://localhost:8080/callback";

  @Value("${aws.cognito.user-pool.id}")
  private String userPoolId;

  @Value("${aws.cognito.identity-pool.id}")
  private String identityPoolId;

  @Value("${spring.security.oauth2.client.provider.cognito.name}")
  private String providerName;

  @Value("${spring.security.oauth2.client.registration.test.client-id}")
  private String clientId;

  @Value("${spring.security.oauth2.client.registration.test.client-secret}")
  private String clientSecret;

  /**
   * メール送信（TODO 削除）
   * 
   * @param model
   * @return
   */
  @GetMapping("/sendmail")
  public String sendmail(Model model) {
    System.out.println("/sendmail");
    try {
      // Google OAutn
      Credential credential = GoogleApiUtils.loadCredential();
      if (credential == null) {
        return "redirect:" + GoogleApiUtils.newAuthorizationUrl(callbackUrl);
      }
      // Send Gmail
      MimeMessage email = createEmail("shingo.gt.1115@gmail.com", "TEST", "Hello, world!");
      gmailSender.send(email);

      model.addAttribute("message", "sent!");
      return "index";
    } catch (Exception e) {
      e.printStackTrace();
    }
    model.addAttribute("message", "error!");
    return "index";
  }

  /**
   * Google OAuth認証コールバック
   * 
   * @param code
   * @return
   * @throws Exception
   */
  @GetMapping("/callback")
  public String callback(@RequestParam String code) throws Exception {
    System.out.println("/callback");
    Credential credential = GoogleApiUtils.createAndStoreCredential(code, callbackUrl);
    if (credential == null) {
      return "error";
    }
    return "redirect:/sendmail";
  }

  private MimeMessage createEmail(
      String to,
      String subject,
      String bodyText)
      throws MessagingException {
    Properties props = new Properties();
    Session session = Session.getDefaultInstance(props, null);
    MimeMessage email = new MimeMessage(session);
    email.addRecipient(jakarta.mail.Message.RecipientType.TO, new InternetAddress(to));
    email.setSubject(subject);
    email.setText(bodyText);
    return email;
  }

  /**
   * ホーム画面へ遷移する
   * 
   * @return
   */
  @GetMapping("/")
  public String index() {
    return "index";
  }

  /**
   * 請求書アップロード画面へ遷移する
   */
  @GetMapping("/invoice/upload")
  public String invoiceUploadView(Model model) {
    FileUploadForm fileUploadForm = new FileUploadForm();
    model.addAttribute("fileUploadForm", fileUploadForm);
    return "invoice/upload";
  }

  /**
   * 請求書アップロード画面へ遷移する
   */
  @PostMapping("/invoice/upload")
  public String invoiceUpload(Model model, @ModelAttribute("fileUploadForm") FileUploadForm fileUploadForm) {
    fileUploadForm.setCreateAt(LocalDateTime.now());
    // S3にファイルをアップロードする
    s3Service.fileUpload(fileUploadForm, "/invoice/");
    model.addAttribute("fileUploadForm", new FileUploadForm());
    model.addAttribute("message", "アップロードが完了しました。");
    return "invoice/upload";
  }

  /**
   * 請求書情報一覧画面へ遷移する
   */
  @GetMapping("/invoiceList")
  public String invoiceList() {
    return "invoiceList";
  }

  /**
   * 請求書情報詳細画面へ遷移する
   */
  @GetMapping("/invoiceDetail")
  public String invoiceDetail() {
    return "invoiceDetail";
  }

}
