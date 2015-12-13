package com.epam.builder.model.wall;

public enum WallEnum {
	WODDEN_WALL("WODDEN"), METAL_WALL("METAL"), BRICK_WALL("BRICK"), CONCRETE_BLOCK_WALL(
			"CONCRETE_BLOCK");

	private String typeValue;

	private WallEnum(String typeValue) {
		this.setTypeValue(typeValue);
	}

	public String getTypeValue() {
		return typeValue;
	}

	public void setTypeValue(String typeValue) {
		this.typeValue = typeValue;
	}
}
