
package jp.co.fullhouse.lespos.lesposapplication.model.entity;

import java.sql.Timestamp;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "invoices")
@Getter
@Setter
public class Invoice {

  @Id
  @Column(length = 36, nullable = false, updatable = false, unique = true)
  private String id = UUID.randomUUID().toString();

  @Column(name = "company_id", length = 36, nullable = false, updatable = false)
  private String companyId;

  @Column(nullable = false)
  private Integer status;

  @Column(name = "submit_method")
  private Integer submitMethod;

  @Column(name = "client_name", length = 255)
  private String clientName;

  @Column(name = "invoice_registration_number", length = 13)
  private String invoiceRegistrationNumber;

  @Column(name = "invoiced_amount")
  private Integer invoicedAmount;

  @Column(name = "consumption_tax_rate")
  private Integer consumptionTaxRate;

  @Column(name = "tax_amount")
  private Integer taxAmount;

  @Column(name = "excluding_tax_amount")
  private Integer excludingTaxAmount;

  @Column(name = "including_tax_amount")
  private Integer includingTaxAmount;

  @Column(name = "payment_due_date")
  private Timestamp paymentDueDate;

  @Column(name = "payment_method")
  private Integer paymentMethod;

  @Column(name = "invoice_type")
  private Integer invoiceType;

  @Column(name = "bank_code", length = 4)
  private String bankCode;

  @Column(name = "bank_name", length = 255)
  private String bankName;

  @Column(name = "bank_name_kana", length = 255)
  private String bankNameKana;

  @Column(name = "branch_code", length = 4)
  private String branchCode;

  @Column(name = "branch_name", length = 255)
  private String branchName;

  @Column(name = "account_type")
  private Integer accountType;

  @Column(name = "account_number", length = 7)
  private String accountNumber;

  @Column(name = "account_holder_name", length = 255)
  private String accountHolderName;

  @Column(name = "image_id", length = 36, nullable = false, updatable = false)
  private String imageId;

  @Column(name = "created_at", nullable = false, insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  @Temporal(TemporalType.TIMESTAMP)
  private Timestamp createdAt;

  @ManyToOne
  @JoinColumn(name = "company_id", insertable = false, updatable = false)
  private Company company;

  @ManyToOne
  @JoinColumn(name = "image_id", insertable = false, updatable = false)
  private Image image;

}
