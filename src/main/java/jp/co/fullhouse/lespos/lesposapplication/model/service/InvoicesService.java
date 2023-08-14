package jp.co.fullhouse.lespos.lesposapplication.model.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.fullhouse.lespos.lesposapplication.model.dto.CompanyDto;
import jp.co.fullhouse.lespos.lesposapplication.model.dto.ImageDto;
import jp.co.fullhouse.lespos.lesposapplication.model.dto.InvoiceDto;
import jp.co.fullhouse.lespos.lesposapplication.model.entity.Invoice;
import jp.co.fullhouse.lespos.lesposapplication.model.form.FileUploadForm;
import jp.co.fullhouse.lespos.lesposapplication.model.form.InvoiceForm;
import jp.co.fullhouse.lespos.lesposapplication.model.repository.InvoicesRepository;

@Service
public class InvoicesService {

  @Autowired
  InvoicesRepository invoiceRepository;

  /**
   * 請求書情報を登録する。
   * 
   */
  public Invoice createInvoice(FileUploadForm form) {

    Invoice invoice = new Invoice();
    invoice.setImageId(form.getId());
    invoice.setCompanyId("a56c611b-374e-11ee-b30d-0242ac170002");
    invoice.setStatus(0);

    invoice = invoiceRepository.save(invoice);

    return invoice;
  }

  /**
   * 請求書情報を更新する。
   * 
   */
  public Invoice updateInvoice(InvoiceForm invoiceForm) {

    Invoice invoice = new Invoice();
    BeanUtils.copyProperties(invoiceForm, invoice);
    invoice.setCompanyId("a56c611b-374e-11ee-b30d-0242ac170002");

    invoice = invoiceRepository.save(invoice);

    return invoice;
  }

  /**
   * 請求書情報を取得する。
   * 
   */
  public Invoice getInvoice(String id) {

    Invoice invoice = invoiceRepository.findById(id).orElse(null);

    return invoice;
  }

  /**
   * 請求書情報を削除する。
   * 
   */
  public void deleteInvoice(String id) {

    invoiceRepository.deleteById(id);

  }

  /**
   * 請求書情報を取得する。
   * 
   */
  public List<InvoiceDto> getInvoices() {

    // 部分一致検索を行い、結果をCompanyDtoのリストとして返す
    return invoiceRepository.findAll().stream().map(invoice -> {
      InvoiceDto invoiceDto = new InvoiceDto();
      BeanUtils.copyProperties(invoice, invoiceDto);
      ImageDto imageDto = new ImageDto();
      BeanUtils.copyProperties(invoice.getImage(), imageDto);
      invoiceDto.setImage(imageDto);
      CompanyDto companyDto = new CompanyDto();
      BeanUtils.copyProperties(invoice.getCompany(), companyDto);

      return invoiceDto;
    }).collect(Collectors.toList());
  }

}
