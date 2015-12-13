package com.epam.builder.model.window;

public class Window {
	private WindowEnum type;

	public Window(WindowEnum type) {
		this.type = type;
	}

	public WindowEnum getType() {
		return type;
	}	
}
