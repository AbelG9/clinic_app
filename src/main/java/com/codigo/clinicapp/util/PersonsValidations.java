package com.codigo.clinicapp.util;

import com.codigo.clinicapp.aggregates.request.RequestPersons;
import com.codigo.clinicapp.constants.Constants;
import com.codigo.clinicapp.entity.DocumentsTypeEntity;
import com.codigo.clinicapp.repository.DocumentsTypeRepository;
import com.codigo.clinicapp.repository.PersonsRepository;
import org.springframework.stereotype.Component;

@Component
public class PersonsValidations {
    private final PersonsRepository personsRepository;
    private final DocumentsTypeRepository documentsTypeRepository;

    public PersonsValidations(PersonsRepository personsRepository, DocumentsTypeRepository documentsTypeRepository) {
        this.personsRepository = personsRepository;
        this.documentsTypeRepository = documentsTypeRepository;
    }

    public boolean validateInput(RequestPersons requestPersons, boolean isUpdate) {
        if (requestPersons == null) {
            return false;
        }
        DocumentsTypeEntity documentsTypeEntity = documentsTypeRepository.findByCode(Constants.COD_TYPE_DNI);
        if (requestPersons.getDocumentTypeId() != documentsTypeEntity.getIdDocumentsType() || requestPersons.getNumDocument().length() != Constants.LENGTH_DNI) {
            return false;
        }
        if (Util.isNullOrEmpty(requestPersons.getEmail()) || Util.isNullOrEmpty(requestPersons.getPhoneNumber())) {
            return false;
        }
        if (!isUpdate) {
            return !existsPerson(requestPersons.getNumDocument());
        }
        return true;
    }

    public boolean existsPerson(String numDocument) {
        return personsRepository.existsByNumDocument(numDocument);
    }
}