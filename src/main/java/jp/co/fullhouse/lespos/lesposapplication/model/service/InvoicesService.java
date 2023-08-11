package jp.co.fullhouse.lespos.lesposapplication.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.fullhouse.lespos.lesposapplication.model.entity.Invoice;
import jp.co.fullhouse.lespos.lesposapplication.model.form.FileUploadForm;
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

}
