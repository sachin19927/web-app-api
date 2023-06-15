package com.service.developersjourneysource.webclient;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;
import org.springframework.web.service.annotation.PutExchange;

import com.service.developersjourneysource.model.idp.AuthorizationToLoginMappingReponse;
import com.service.developersjourneysource.model.idp.LicenseRenewalRequest;
import com.service.developersjourneysource.model.idp.UpdateUserDetails;
import com.service.developersjourneysource.model.idp.UserDetails;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@HttpExchange
public interface IdpHttpClient {

	@PostExchange(url="/oauth2-authorizedapp/accesstoken")
	void renewLicense(@RequestBody LicenseRenewalRequest licenseRenewalRequest);
	
	@GetExchange(url="/oauth2-authorizedapp?crit=loginName+eq+'{loginName}'")
	AuthorizationToLoginMappingReponse getAuthorizationToLoginMappingsWithPagination(@PathVariable String loginName,
															@RequestParam int limit,
															@RequestParam int offset,
															@RequestParam boolean shared,
															@RequestParam String viewName);
	
	@GetExchange(url="/oauth2-authorizedapp")
	AuthorizationToLoginMappingReponse getAuthorizationToLoginMappingsWithOutCriteria(@RequestParam int limit,
															@RequestParam int offset);
	
	@GetExchange(url="/users?crit=loginName+eq+'{loginName}'")
	UserDetails getUserDetails(@PathVariable String loginName,@RequestParam int limit,@RequestParam int offset);
	
	@PutExchange(url="/users/{loginId}")
	void enableRenewalNotifications(@PathVariable String loginId,@RequestBody UpdateUserDetails updateUserDetails);
	
	
	@GetExchange(url="/users?crit=substringof('{searchValue}',{searchKey})+eq+true")
	UserDetails getUserDetailsBasedOnSearchKey(@PathVariable String searchValue,
															@PathVariable String searchKey,
															@RequestParam int limit,
															@RequestParam int offset);
}
