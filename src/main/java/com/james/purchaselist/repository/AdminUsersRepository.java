package com.james.purchaselist.repository;

import com.james.purchaselist.domain.model.entity.AdminUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminUsersRepository extends JpaRepository<AdminUsers, Long> {
}
