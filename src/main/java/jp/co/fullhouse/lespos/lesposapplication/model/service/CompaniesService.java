package jp.co.fullhouse.lespos.lesposapplication.model.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import jp.co.fullhouse.lespos.lesposapplication.model.dto.CompanyDto;
import jp.co.fullhouse.lespos.lesposapplication.model.entity.Company;
import jp.co.fullhouse.lespos.lesposapplication.model.form.CompanyForm;
import jp.co.fullhouse.lespos.lesposapplication.model.form.CompanySearchForm;
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
  public List<CompanyDto> getCompanies(CompanySearchForm searchForm) {
    // nameがnullの場合は空文字として扱う
    String name = searchForm.getName() != null ? searchForm.getName() : "";

    // 部分一致検索を行い、結果をCompanyDtoのリストとして返す
    return companiesRepository.findByNameContaining(name).stream().map(company -> {
      CompanyDto dto = new CompanyDto();
      BeanUtils.copyProperties(company, dto);
      return dto;
    }).collect(Collectors.toList());
  }

  /**
   * 会社情報を登録する。
   * 
   * @param form
   */
  @Transactional
  public void createCompany(CompanyForm form) {

    Company company = new Company();
    BeanUtils.copyProperties(form, company);

    companiesRepository.insert(company.getName(), company.getPrefecture(), company.getCity(), company.getPostalCode(),
        company.getAddress1(), company.getAddress2(), company.getTel());
  }

  /**
   * 会社情報を更新する。
   * 
   * @param form
   */
  @Transactional
  public void updateCompany(CompanyForm form) {

    Company company = new Company();
    BeanUtils.copyProperties(form, company);

    companiesRepository.save(company);
  }

}
