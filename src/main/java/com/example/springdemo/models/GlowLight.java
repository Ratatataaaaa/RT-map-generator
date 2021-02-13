package com.example.springdemo.models;

import java.util.ArrayList;
import java.util.List;

public class GlowLight {

	private List<Integer>   origin;
	private Float           radius;
	private List<Integer>   color;
	private Float           intensity;

	public GlowLight() {
		this.setOrigin(0,0,0);
		this.radius = 1f;
		this.setColor(0x001234);
		this.intensity = 0.5f;
	}



	public List<Integer> getColorFromInt() {

		return origin;
	}

	@Override
	public String toString() {
		return "glowlight {\n" +
				"\torigin: " + origin + ";\n" +
				"\tradius: " + radius + ";\n" +
				"\tcolor: " + color + ";\n" +
				"\tintensity: "+ intensity +";\n" +
				"}\n";
	}

	public void setColor(int color) {

		this.color = new ArrayList<>();
		this.color.add(color >> 16 & 0xff);
		this.color.add(color >> 8 & 0xff);
		this.color.add(color & 0xff);
	}

	public void setOrigin(Integer x, Integer y, Integer z) {

		this.origin = new ArrayList<>();
		this.origin.add(x);
		this.origin.add(y);
		this.origin.add(z);
	}

	public List<Integer> getOrigin() {
		return origin;
	}

	public void setOrigin(List<Integer> origin) {
		this.origin = origin;
	}

	public Float getRadius() {
		return radius;
	}

	public void setRadius(Float radius) {
		this.radius = radius;
	}

	public List<Integer> getColor() {
		return color;
	}

	public void setColor(List<Integer> color) {
		this.color = color;
	}

	public Float getIntensity() {
		return intensity;
	}

	public void setIntensity(Float intensity) {
		this.intensity = intensity;
	}
}
