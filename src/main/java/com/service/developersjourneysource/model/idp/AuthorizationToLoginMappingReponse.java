package com.service.developersjourneysource.model.idp;

import java.time.Instant;
import java.util.List;


public record AuthorizationToLoginMappingReponse(int total, List<Data> data) {

	public record Data (String accessToken,
						Instant expiresOn,
						String loginName,
						String applicationName,
						Long loginId) {
	}
}
