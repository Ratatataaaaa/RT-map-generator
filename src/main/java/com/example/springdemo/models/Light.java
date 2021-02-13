package com.example.springdemo.models;

import org.springframework.stereotype.Component;

@Component
public class Light {
	String  type;
	Float   intensity;

	public Light() {
		this.type = "ambient";
		this.intensity = 1f;
	}

	public Light(String type, Float intensity) {
		this.type = type;
		this.intensity = intensity;
	}

	@Override
	public String toString() {
		return "light {\n" +
				"\ttype: " + type +
				"; intensity: " + intensity +
				";\n" +
				"}\n";
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Float getIntensity() {
		return intensity;
	}

	public void setIntensity(Float intensity) {
		this.intensity = intensity;
	}
}
