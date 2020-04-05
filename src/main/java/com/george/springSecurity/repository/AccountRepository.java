package com.george.springSecurity.repository;

import com.george.springSecurity.model.UserAccount;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<UserAccount, Long> {
}
