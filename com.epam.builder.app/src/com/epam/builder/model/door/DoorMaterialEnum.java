package com.epam.builder.model.door;

public enum DoorMaterialEnum {
	WODDEN_DOOR("WODDEN_DOOR"), METAL_DOOR("METAL_DOOR"), PLASTIC_DOOR("PLASTIC_DOOR"), ;

	private String typeValue;

	private DoorMaterialEnum(String typeValue) {
		this.setTypeValue(typeValue);
	}

	public String getTypeValue() {
		return typeValue;
	}

	public void setTypeValue(String typeValue) {
		this.typeValue = typeValue;
	}
}
