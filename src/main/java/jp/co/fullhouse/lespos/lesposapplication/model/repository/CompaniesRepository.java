package jp.co.fullhouse.lespos.lesposapplication.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jp.co.fullhouse.lespos.lesposapplication.model.entity.Company;

@Repository
public interface CompaniesRepository extends JpaRepository<Company, String> {
  @Query(value = "INSERT INTO companies (name, prefecture, city, postal_code, address1, address2, tel) VALUES (:name, :prefecture, :city, :postalCode, :address1, :address2, :tel)", nativeQuery = true)
  @Modifying
  void insert(@Param("name") String name, @Param("prefecture") String prefecture, @Param("city") String city,
      @Param("postalCode") String postalCode, @Param("address1") String address1, @Param("address2") String address2,
      @Param("tel") String tel);

  List<Company> findByNameContaining(String name);
}
