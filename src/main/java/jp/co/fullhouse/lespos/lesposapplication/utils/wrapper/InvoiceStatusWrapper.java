package jp.co.fullhouse.lespos.lesposapplication.utils.wrapper;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import jp.co.fullhouse.lespos.lesposapplication.utils.constant.InvoiceStatus;

@Component
public class InvoiceStatusWrapper {

  private final List<InvoiceStatus> statuses = Arrays.asList(InvoiceStatus.values());

  public List<InvoiceStatus> getStatuses() {
    return statuses;
  }
}
