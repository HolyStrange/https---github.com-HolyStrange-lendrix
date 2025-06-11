package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import lendrix.entity.Account;

import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, UUID>{

}
