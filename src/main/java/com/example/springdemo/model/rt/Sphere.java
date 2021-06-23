package com.example.springdemo.model.rt;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Sphere {
	private List<Integer> origin;
	private Float radius;
	private List<Integer> color;
	private Float shininess;
	private Float reflection;

	public Sphere() {
		this.setOrigin(0, 0, 0);
		this.radius = 3f;
		this.setColor(0x001234);
		this.reflection = 0.8f;
		this.shininess = 1f;
	}

	@Override
	public String toString() {
		return "sphere {\n" +
				"\torigin: " + origin + ";\n" +
				"\tradius: " + radius + ";\n" +
				"\tcolor: " + color + ";\n" +
				"\tshininess: " + shininess + ";\n" +
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

	public void setRadius(Float radius) {
		this.radius = radius;
	}

	public Float getReflection() {
		return reflection;
	}

	public void setReflection(Float reflection) {
		this.reflection = reflection;
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

	public Float getShininess() {
		return shininess;
	}

	public void setShininess(Float shininess) {
		this.shininess = shininess;
	}
}
