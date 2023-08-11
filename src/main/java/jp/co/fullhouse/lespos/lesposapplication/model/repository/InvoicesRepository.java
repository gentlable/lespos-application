package jp.co.fullhouse.lespos.lesposapplication.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jp.co.fullhouse.lespos.lesposapplication.model.entity.Invoice;

@Repository
public interface InvoicesRepository extends JpaRepository<Invoice, String> {
  @Query(value = "INSERT INTO invoices (company_id, status, image_id) VALUES (:companyId, :status, :imageId)", nativeQuery = true)
  @Modifying
  void insert(@Param("companyId") String companyId, @Param("status") String status, @Param("imageId") String imageId);

}
