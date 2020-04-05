package com.george.springSecurity.service;

import com.george.springSecurity.model.UserAccount;
import com.george.springSecurity.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserAccountService {

    @Autowired
    AccountRepository accountRepository;

    public void save(UserAccount user) {
        accountRepository.save(user);
    }

    public List<UserAccount> getAll(){
        List<UserAccount> userList = new ArrayList<>();
        Iterable<UserAccount> userAccounts = accountRepository.findAll();
        userAccounts.forEach(userList::add);
        return userList;
    }
}
