package com.example.springdemo.model.rt;

import java.util.ArrayList;
import java.util.List;

public class PointLight {

	private List<Integer> origin;
	private List<Integer> color;
	private Float intensity;
	private String type;

	public PointLight() {

		this.type = "point";
		this.intensity = 0.5f;
		this.setColor(0x001234);
		this.setOrigin(0, 0, 0);
	}

	@Override
	public String toString() {
		return "light {\n" +
				"\ttype: " + type + ";\n" +
				"\tintensity: " + intensity + ";\n" +
				"\tcolor: " + color + ";\n" +
				"\torigin: " + origin + ";\n" +
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

	public void setOrigin(int weigh, int height) {
		this.origin = new ArrayList<>();
		this.origin.add((weigh * 10) / 3);
		this.origin.add(-((height * 10) / 4));
		this.origin.add((height > weigh) ? height * 15 : weigh * 15);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Integer> getOrigin() {
		return origin;
	}

	public void setOrigin(List<Integer> origin) {
		this.origin = origin;
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
