package by.powerline.repzone.repository;

import by.powerline.repzone.model.db.ServicePrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServicePriceRepozitory extends JpaRepository<ServicePrice, Long> {
    List<ServicePrice> findAllByModelIdAndCategoryId(Long modelId, Long categoryId);
}
