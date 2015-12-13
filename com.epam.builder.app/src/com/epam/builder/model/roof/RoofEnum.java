package com.epam.builder.model.roof;

public enum RoofEnum {
	FLAT_ROOF("FLAT_ROOF"), COMPLEX_ROOF("COMPLEX_ROOF");
	private String typeValue;

	private RoofEnum(String typeValue) {
		this.setTypeValue(typeValue);
	}

	public String getTypeValue() {
		return typeValue;
	}

	public void setTypeValue(String typeValue) {
		this.typeValue = typeValue;
	}
}
