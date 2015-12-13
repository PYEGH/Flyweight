package com.epam.builder.model;

public enum BuildingEnum {
	VILLAGE_HOUSE("VILLAGE_HOUSE"), TOWN_HOUSE("TOWN_HOUSE"),
	VILLAGE_STORE("VILLAGE_STORE"), INDUSTRIAL_STORE("INDUSTRIAL_STORE");

	private String buildingTypeValue;

	private BuildingEnum(String buildingTypeValue) {
		this.setBuildingTypeValue(buildingTypeValue);
	}

	public String getBuildingTypeValue() {
		return buildingTypeValue;
	}

	public void setBuildingTypeValue(String buildingTypeValue) {
		this.buildingTypeValue = buildingTypeValue;
	}

}
