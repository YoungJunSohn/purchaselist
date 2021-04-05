package com.james.purchaselist.repository;

import com.james.purchaselist.domain.model.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderGroupsRepository extends JpaRepository<OrderDetails, Long> {
}
