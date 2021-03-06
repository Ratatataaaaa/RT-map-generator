package com.example.springdemo.model.rt;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Camera {

	private List<Integer> origin;
	private List<Integer> direction;
	private Integer fov;

	@Override
	public String toString() {
		return "camera {\n" +
				"\torigin: " + origin + ";\n" +
				"\tdirection: " + direction + ";\n" +
				"\tfov: " + fov + ";\n" +
				"}\n";
	}

	public Camera() {
		this.origin = new ArrayList<>();
		this.direction = new ArrayList<>();
		this.fov = 60;
	}

	public void setOrigin(int weigh, int height) {
		this.origin.add((weigh * 10) / 3);
		this.origin.add(-((height * 10) / 4));
		this.origin.add((height > weigh) ? height * 15 : weigh * 15);
	}

	public void setDirection(int weigh, int height) {
		this.direction.add((weigh * 10) / 2);
		this.direction.add(-((height * 10) / 2));
		this.direction.add(-((height * 10) / 3));
	}

	public List<Integer> getOrigin() {
		return origin;
	}

	public void setOrigin(List<Integer> origin) {
		this.origin = origin;
	}

	public List<Integer> getDirection() {
		return direction;
	}

	public void setDirection(List<Integer> direction) {
		this.direction = direction;
	}

	public Integer getFov() {
		return fov;
	}

	public void setFov(Integer fov) {
		this.fov = fov;
	}
}
