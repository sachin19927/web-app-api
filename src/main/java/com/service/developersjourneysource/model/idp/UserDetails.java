package com.service.developersjourneysource.model.idp;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UserDetails(int total, List<Data> data) {

	public record Data(Long id,
			           String firstName,
			           String lastName,
			           String loginName,
			           String emailAddress,
			           Integer role,
			           Integer providerConfigurationID,
			           String type,
			           String typeCode,
			           Integer adminSuspended,
			           @JsonProperty("authorizationRegToLogins")
			           List<Entitlement> entitlements,
			           CustomInfo customInfos,
			           List<Departments> departments
			) {
		
		public record Entitlement(String name,String parameter) {
			
		}
		
		public record CustomInfo(
							@JsonProperty("_OperationalContact")
							String operationalContacts,
							@JsonProperty("_ApplicationName")
							String applicationName,
							@JsonProperty("_NotificationContact")
							String notificationContact,
							@JsonProperty("_RenewalNotificationAck")
							String renewalNotificationAck,
							@JsonProperty("_ApplicationVersion")
							String applicationVersion,
							@JsonProperty("_EntityName")
							String entityName,
							@JsonProperty("_APIUniqueId")
							String apiUniqueId,
							@JsonProperty("_DeveloperAppID")
							String developerAppId,
							@JsonProperty("_EntityID")
							String entityId,
							@JsonProperty("_RestrictedDataAccess")
							String restrictedDataAccess,
							@JsonProperty("_Consumer_Internal47External")
							String consumerInternalOrExternal,
							@JsonProperty("_permissions")
							String permission,
							@JsonProperty("_ExternalID")
							String externalId
							) {
			
		}
		
		public record Departments(Long departmentId,
				String departmentName,
				Integer primaryDept) {
			
		}
		
	}
}
