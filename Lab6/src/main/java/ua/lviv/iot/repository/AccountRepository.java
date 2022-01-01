package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
}
