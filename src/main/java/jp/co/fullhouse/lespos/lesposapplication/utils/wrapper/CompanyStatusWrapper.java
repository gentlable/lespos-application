package jp.co.fullhouse.lespos.lesposapplication.utils.wrapper;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import jp.co.fullhouse.lespos.lesposapplication.utils.constant.CompanyStatus;

@Component
public class CompanyStatusWrapper {

  private final List<CompanyStatus> statuses = Arrays.asList(CompanyStatus.values());

  public List<CompanyStatus> getStatuses() {
    return statuses;
  }
}
