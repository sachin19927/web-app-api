package com.service.developersjourneysource.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.service.developersjourneysource.model.LibraryRecord;
import com.service.developersjourneysource.model.idp.AuthorizationToLoginMappingReponse;
import com.service.developersjourneysource.model.idp.UserDetails;
import com.service.developersjourneysource.webclient.IdpHttpClient;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/v2/api_uat")
@Tag(name = "IDP API", description = "IDP Management APIs")
@RequiredArgsConstructor
public class IdpApiController {

	private final IdpHttpClient idpHttpClient;
	
	@GetMapping("/oauth2-authorizedapps")
	public ResponseEntity<AuthorizationToLoginMappingReponse> getOauthDetailsWithPagination(@RequestParam(required = false) int limit,@RequestParam(required = false) int offset) {
		try {
			var authorizationToLoginResponse = idpHttpClient.getAuthorizationToLoginMappingsWithOutCriteria(limit, offset);
			
			return new ResponseEntity<>(authorizationToLoginResponse, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/oauth2-authorizedapps/{loginName}")
	public ResponseEntity<AuthorizationToLoginMappingReponse> getOauthDetailsWithPaginationAndLoginName(@PathVariable String loginName,@RequestParam(required = false) int limit,@RequestParam(required = false) int offset) {
		try {
			var authorizationToLoginResponse = idpHttpClient.getAuthorizationToLoginMappingsWithPagination(loginName,limit, offset,true,"View+with+Token");
			
			return new ResponseEntity<>(authorizationToLoginResponse, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/userData/{loginName}")
	public ResponseEntity<UserDetails> getUserDetailsBasedOnLoginName(@PathVariable String loginName,@RequestParam(required = false) int limit,@RequestParam(required = false) int offset) {
		try {
			var userDetail = idpHttpClient.getUserDetails(loginName,limit, offset);
			
			return new ResponseEntity<>(userDetail, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/userData/{searchKey}/{searchValue}")
	public ResponseEntity<UserDetails> getUserDetailsBasedOnSearchKey(@PathVariable String searchKey,@PathVariable String searchValue,@RequestParam(required = false) int limit,@RequestParam(required = false) int offset) {
		try {
			var userDetails = idpHttpClient.getUserDetailsBasedOnSearchKey(searchValue,searchKey,limit, offset);
			
			return new ResponseEntity<>(userDetails, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
