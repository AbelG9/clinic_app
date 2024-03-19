package com.codigo.clinicapp.service;

import com.codigo.clinicapp.aggregates.request.RequestUsers;
import com.codigo.clinicapp.aggregates.response.ResponseBase;
import com.codigo.clinicapp.entity.UsersEntity;

import java.util.List;

public interface UsersService {
    ResponseBase signUp(RequestUsers requestUsers);
    ResponseBase login(RequestUsers requestUsers);
    List<UsersEntity> findAllUsers();
    ResponseBase updateUser(int id, RequestUsers requestUsers);
    ResponseBase deleteUser(int id);
}

