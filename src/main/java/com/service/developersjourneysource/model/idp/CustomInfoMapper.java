package com.service.developersjourneysource.model.idp;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.service.developersjourneysource.model.idp.UserDetails.Data;

@Mapper
public interface CustomInfoMapper {

	@Mapping(source = "customInfos.operationalContacts" , target = "customInfos.operationalContacts")
	@Mapping(source = "customInfos.applicationName" , target = "customInfos.applicationName")
	@Mapping(source = "customInfos.notificationContact" , target = "customInfos.notificationContact")
	@Mapping(target = "customInfos.renewalNotificationAck" , constant = "1")
	@Mapping(source = "customInfos.applicationVersion" , target = "customInfos.applicationVersion")
	@Mapping(source = "customInfos.entityName" , target = "customInfos.entityName")
	@Mapping(source = "customInfos.apiUniqueId" , target = "customInfos.apiUniqueId")
	@Mapping(source = "customInfos.developerAppId" , target = "customInfos.developerAppId")
	@Mapping(source = "customInfos.entityId" , target = "customInfos.entityId")
	@Mapping(source = "customInfos.restrictedDataAccess" , target = "customInfos.restrictedDataAccess")
	@Mapping(source = "customInfos.consumerInternalOrExternal" , target = "customInfos.consumerInternalOrExternal")
	@Mapping(source = "customInfos.permission" , target = "customInfos.permission")
	@Mapping(source = "customInfos.externalId" , target = "customInfos.externalId")
	UpdateUserDetails updateUserDetailsForNotificaionAck(Data useDataDetails);
}

