package com.example.springdemo.model.simpl;

import java.util.ArrayList;
import java.util.List;

public class Torus {
	private List<Integer> origin;
	private Float radius_out;
	private Float radius_in;
	private List<Integer> axis;
	private List<Integer> color;
	private Float shininess;
	private Float transparency;

	public Torus() {
		this.setOrigin(0, 0, 0);
		this.setAxis(0, 0, 0);
		this.setColor(0x001234);
		this.radius_out = 1f;
		this.radius_in = 1f;
		this.transparency = 0.5f;
		this.shininess = 1f;
	}


	@Override
	public String toString() {
		return "torus {\n" +
				"\torigin: " + origin + ";\n" +
				"\tradius-out: " + radius_out + ";\n" +
				"\tradius-in: " + radius_out + ";\n" +
				"\taxis: " + axis + ";\n" +
				"\tcolor: " + color + ";\n" +
				"\tshininess: " + shininess + ";\n" +
				"\ttransparency: " + transparency + ";\n" +
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

	public void setAxis(Integer x, Integer y, Integer z) {

		this.axis = new ArrayList<>();
		this.axis.add(x);
		this.axis.add(y);
		this.axis.add(z);
	}

	public Torus(List<Integer> origin, Float radius_out, Float radius_in, List<Integer> axis, List<Integer> color, Float shininess, Float transparency) {
		this.origin = origin;
		this.radius_out = radius_out;
		this.radius_in = radius_in;
		this.axis = axis;
		this.color = color;
		this.shininess = shininess;
		this.transparency = transparency;
	}

	public List<Integer> getOrigin() {
		return origin;
	}

	public void setOrigin(List<Integer> origin) {
		this.origin = origin;
	}

	public Float getRadius_out() {
		return radius_out;
	}

	public void setRadius_out(Float radius_out) {
		this.radius_out = radius_out;
	}

	public Float getRadius_in() {
		return radius_in;
	}

	public void setRadius_in(Float radius_in) {
		this.radius_in = radius_in;
	}

	public List<Integer> getAxis() {
		return axis;
	}

	public void setAxis(List<Integer> axis) {
		this.axis = axis;
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

	public Float getTransparency() {
		return transparency;
	}

	public void setTransparency(Float transparency) {
		this.transparency = transparency;
	}
}
