package com.service.developersjourneysource.model.idp;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.service.developersjourneysource.model.idp.UserDetails.Data.CustomInfo;
import com.service.developersjourneysource.model.idp.UserDetails.Data.Departments;

public record UpdateUserDetails(Long id,
        String firstName,
        String lastName,
        String loginName,
        String emailAddress,
        Integer role,
        Integer providerConfigurationID,
        String type,
        String typeCode,
        Integer adminSuspended,
        @JsonProperty("customInfos")
        CustomInfo customInfos,
        List<Departments> departments) {

}
