package jp.co.fullhouse.lespos.lesposapplication.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.co.fullhouse.lespos.lesposapplication.model.entity.Company;

@Repository
public interface CompaniesRepository extends JpaRepository<Company, String> {
}
