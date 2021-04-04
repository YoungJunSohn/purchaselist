package com.james.purchaselist.domain.adminuser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminUsersRepository extends JpaRepository<AdminUsers, Long> {
}
