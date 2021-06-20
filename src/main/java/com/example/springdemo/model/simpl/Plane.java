package com.example.springdemo.model.simpl;

import java.util.ArrayList;
import java.util.List;

public class Plane {
	private List<Integer> origin;
	private List<Integer> normal;
	private List<Integer> color;
	private Float shininess;
	private Float reflective;

	public Plane() {
		this.setOrigin(0, 0, -15);
		this.setNormal(0, 0, 1);
		this.setColor(0x000000);
		this.shininess = 100f;
		this.reflective = 0f;
	}

	@Override
	public String toString() {
		return "plane {\n" +
				"\torigin: " + origin + ";\n" +
				"\tnormal: " + normal + ";\n" +
				"\tcolor: " + color + ";\n" +
				"\tshininess: " + shininess + ";\n" +
				"\treflective: " + reflective + ";\n" +
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

	public void setNormal(Integer x, Integer y, Integer z) {

		this.normal = new ArrayList<>();
		this.normal.add(x);
		this.normal.add(y);
		this.normal.add(z);
	}

	public Float getReflective() {
		return reflective;
	}

	public void setReflective(Float reflective) {
		this.reflective = reflective;
	}

	public List<Integer> getOrigin() {
		return origin;
	}

	public void setOrigin(List<Integer> origin) {
		this.origin = origin;
	}

	public List<Integer> getNormal() {
		return normal;
	}

	public void setNormal(List<Integer> normal) {
		this.normal = normal;
	}

	public List<Integer> getColor() {
		return color;
	}

	public void setColor(List<Integer> color) {
		this.color = color;
	}

	public Float getShininess() {
		return shininess;
	}

	public void setShininess(Float shininess) {
		this.shininess = shininess;
	}
}
