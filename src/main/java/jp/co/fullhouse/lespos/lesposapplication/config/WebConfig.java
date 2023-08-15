package jp.co.fullhouse.lespos.lesposapplication.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jp.co.fullhouse.lespos.lesposapplication.utils.wrapper.CompanyStatusWrapper;

@Configuration
public class WebConfig implements WebMvcConfigurer {

  @Autowired
  private CompanyStatusWrapper companyStatusWrapper;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(new HandlerInterceptor() {

      @Override
      public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
          ModelAndView modelAndView) {
        if (modelAndView != null) { // モデルが存在する場合のみ
          modelAndView.addObject("statuses", companyStatusWrapper.getStatuses());
        }
      }
    });
  }
}
