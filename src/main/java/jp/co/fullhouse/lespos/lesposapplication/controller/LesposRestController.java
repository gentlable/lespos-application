package jp.co.fullhouse.lespos.lesposapplication.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import jp.co.fullhouse.lespos.lesposapplication.model.dto.InvoiceDto;
import jp.co.fullhouse.lespos.lesposapplication.model.service.InvoicesService;

@RestController
public class LesposRestController {

  private final InvoicesService invoicesService;

  public LesposRestController(InvoicesService invoicesService) {
    this.invoicesService = invoicesService;
  }

  @GetMapping("/invoices/export-csv")
  public ResponseEntity<byte[]> exportCsv(@RequestParam String invoiceId) throws Exception {

    // IDに基づいてデータベースからインボイスを取得する
    InvoiceDto invoiceDto = invoicesService.fetchInvoiceById(invoiceId);

    CsvMapper csvMapper = new CsvMapper();
    csvMapper.registerModule(new com.fasterxml.jackson.datatype.jsr310.JavaTimeModule());
    CsvSchema schema = csvMapper.schemaFor(InvoiceDto.class).withHeader();
    byte[] csvData = csvMapper.writer(schema).writeValueAsBytes(invoiceDto);

    HttpHeaders headers = new HttpHeaders();
    headers.add(HttpHeaders.CONTENT_TYPE, "text/csv");
    headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=invoice.csv");

    return ResponseEntity.ok()
        .headers(headers)
        .body(csvData);
  }
}
