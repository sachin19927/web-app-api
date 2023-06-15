package com.service.developersjourneysource.model.idp;

import java.time.Instant;

public record LicenseRenewalRequest(User user,Instant expiresOn,Long clientId,Long loginId) {

	public record User(String LoginName){
	}
}
