package com.service.developersjourneysource.email;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum EmailTemplates {
	
	ONBOARD_TEMPLATE("New Book is Onboarded"),
	DATA_UPDATED_TEMPLATE("Book details modified");
	
	private final String description;

	@Override
	public String toString() {
		return this.description;
	}
}
