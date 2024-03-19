package com.codigo.clinicapp.service;

import com.codigo.clinicapp.aggregates.request.RequestPersons;
import com.codigo.clinicapp.aggregates.response.ResponseBase;

public interface PersonsService {
    ResponseBase getInfoReniec(String numero);
    ResponseBase createPersons(RequestPersons requestPersons);
    ResponseBase findOnePersonById(int id);
    ResponseBase findOnePersonByDocument(String doc);
    ResponseBase findAllPersons();
    ResponseBase updatePerson(int id, RequestPersons requestPersons);
    ResponseBase deletePerson(int id);
}
