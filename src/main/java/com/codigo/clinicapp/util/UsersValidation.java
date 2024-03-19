package com.codigo.clinicapp.util;

import com.codigo.clinicapp.aggregates.request.RequestUsers;
import com.codigo.clinicapp.repository.UsersRepository;
import org.springframework.stereotype.Component;

@Component
public class UsersValidation {
    private final UsersRepository usersRepository;

    public UsersValidation(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public boolean validateInput(RequestUsers requestUsers, boolean isUpdate) {
        if (requestUsers == null) {
            return false;
        }
        if (Util.isNullOrEmpty(requestUsers.getUsername()) || Util.isNullOrEmpty(requestUsers.getPassword())) {
            return false;
        }
        if (!isUpdate) {
            if (existsUser(requestUsers.getUsername())) {
                return false;
            }
        }
        return true;
    }

    public boolean existsUser(String username) {
        return usersRepository.existsByUsername(username);
    }
}
