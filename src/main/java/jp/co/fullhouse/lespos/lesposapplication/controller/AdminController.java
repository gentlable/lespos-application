package jp.co.fullhouse.lespos.lesposapplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.fullhouse.lespos.lesposapplication.model.dto.CompanyDto;
import jp.co.fullhouse.lespos.lesposapplication.model.service.CompaniesService;
import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminController {

  private final CompaniesService companiesService;

  @GetMapping("/companies")
  public String companies() {
    CompanyDto companyDto = companiesService.getCompany("239872a6-35e0-11ee-a14c-0242ac170002");
    return "admin/companies";
  }
}
