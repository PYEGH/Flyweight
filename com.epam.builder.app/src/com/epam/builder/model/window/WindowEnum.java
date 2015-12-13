package com.epam.builder.model.window;

public enum WindowEnum {
	WODDEN_WINDOW("WODDEN_WINDOW"), GLAZING_WINDOW("GLAZING_WINDOW");

	private String typeValue;

	private WindowEnum(String typeValue) {
		this.setTypeValue(typeValue);
	}

	public String getTypeValue() {
		return typeValue;
	}

	public void setTypeValue(String typeValue) {
		this.typeValue = typeValue;
	}
}
