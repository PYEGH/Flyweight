package com.epam.builder.model.roof;


public class Roof {
	private RoofEnum type;

	public Roof(RoofEnum type) {
		this.type = type;
	}

	public RoofEnum getType() {
		return type;
	}
}
