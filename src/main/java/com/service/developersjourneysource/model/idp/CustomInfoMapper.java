package com.service.developersjourneysource.model.idp;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.service.developersjourneysource.model.idp.UserDetails.Data;

@Mapper
public interface CustomInfoMapper {

	@Mapping(source = "customInfos.operationalContacts" , target = "customInfo.operationalContacts")
	@Mapping(source = "customInfos.applicationName" , target = "customInfo.applicationName")
	@Mapping(source = "customInfos.notificationContact" , target = "customInfo.notificationContact")
	@Mapping(target = "customInfos.renewalNotificationAck" , constant = "1")
	@Mapping(source = "customInfos.applicationVersion" , target = "customInfo.applicationVersion")
	@Mapping(source = "customInfos.entityName" , target = "customInfo.entityName")
	@Mapping(source = "customInfos.apiUniqueId" , target = "customInfo.apiUniqueId")
	@Mapping(source = "customInfos.developerAppId" , target = "customInfo.developerAppId")
	@Mapping(source = "customInfos.entityId" , target = "customInfo.entityId")
	@Mapping(source = "customInfos.restrictedDataAccess" , target = "customInfo.restrictedDataAccess")
	@Mapping(source = "customInfos.consumerInternalOrExternal" , target = "customInfo.consumerInternalOrExternal")
	@Mapping(source = "customInfos.permission" , target = "customInfo.permission")
	@Mapping(source = "customInfos.externalId" , target = "customInfo.externalId")
	UpdateUserDetails updateUserDetailsForNotificaionAck(Data useDataDetails);
}

