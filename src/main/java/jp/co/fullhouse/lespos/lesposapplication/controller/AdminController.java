package jp.co.fullhouse.lespos.lesposapplication.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jp.co.fullhouse.lespos.lesposapplication.model.dto.CompanyDto;
import jp.co.fullhouse.lespos.lesposapplication.model.form.CompanyForm;
import jp.co.fullhouse.lespos.lesposapplication.model.form.CompanySearchForm;
import jp.co.fullhouse.lespos.lesposapplication.model.service.CompaniesService;
import jp.co.fullhouse.lespos.lesposapplication.utils.constant.CompanyStatus;
import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminController {

  private final CompaniesService companiesService;

  /**
   * 会社一覧画面を表示する
   * 
   * @return
   */
  @GetMapping("/companies")
  public String companies(Model model) {
    CompanySearchForm companySearchForm = new CompanySearchForm();
    List<CompanyDto> companies = companiesService.getCompanies(companySearchForm);
    model.addAttribute("companyForm", new CompanyForm());
    model.addAttribute("companySearchForm", companySearchForm);
    model.addAttribute("companies", companies);
    return "admin/companies";
  }

  /**
   * 会社情報の検索を行う。
   */
  @GetMapping("/companies/search")
  public String searchCompany(@ModelAttribute CompanySearchForm companySearchForm, Model model) {
    List<CompanyDto> companies = companiesService.getCompanies(companySearchForm);
    model.addAttribute("companyForm", new CompanyForm());
    model.addAttribute("companySearchForm", companySearchForm);
    model.addAttribute("companies", companies);
    return "admin/companies";
  }

  /**
   * 会社情報の登録を行う。
   * 
   * @param companyForm
   * @param redirectAttributes
   * @return
   */
  @PostMapping("/companies/add")
  public String addCompany(@ModelAttribute CompanyForm companyForm, RedirectAttributes redirectAttributes) {
    CompanyStatus statusEnum = CompanyStatus.fromCode(1);
    companyForm.setStatus(statusEnum);
    companiesService.createCompany(companyForm);
    redirectAttributes.addFlashAttribute("message", "会社登録が完了しました。");
    return "redirect:/admin/companies";
  }

  /**
   * 会社情報の編集を行う。
   * 
   * @param companyForm
   * @param redirectAttributes
   * @return
   */
  @PostMapping("/companies/edit")
  public String editCompany(@ModelAttribute CompanyForm companyForm, RedirectAttributes redirectAttributes) {
    CompanyStatus statusEnum = CompanyStatus.fromCode(companyForm.getStatusCode());
    companyForm.setStatus(statusEnum);
    companiesService.updateCompany(companyForm);
    redirectAttributes.addFlashAttribute("message", "会社登録が完了しました。");
    return "redirect:/admin/companies";
  }
}
