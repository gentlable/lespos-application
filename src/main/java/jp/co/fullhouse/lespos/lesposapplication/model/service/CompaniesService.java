package jp.co.fullhouse.lespos.lesposapplication.model.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import jp.co.fullhouse.lespos.lesposapplication.model.dto.CompanyDto;
import jp.co.fullhouse.lespos.lesposapplication.model.repository.CompaniesRepository;

@Service
@Transactional
public class CompaniesService {

  @Autowired
  CompaniesRepository companiesRepository;

  /**
   * 会社情報を取得する。
   * 
   * @param id
   * @return
   */
  public CompanyDto getCompany(String id) {
    return companiesRepository.findById(id).map(company -> {
      CompanyDto dto = new CompanyDto();
      dto.setId(company.getId());
      dto.setName(company.getName());
      return dto;
    }).orElse(null);
  }

  /**
   * 会社情報リストを取得する。
   * 
   * @return
   */
  public List<CompanyDto> getCompanies() {
    return companiesRepository.findAll().stream().map(company -> {
      CompanyDto dto = new CompanyDto();
      dto.setId(company.getId());
      dto.setName(company.getName());
      return dto;
    }).collect(Collectors.toList());
  }

}
