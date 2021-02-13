package com.example.springdemo.models;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.net.URL;

@Component
public class JsonModel {

	private MultipartFile   multipartFile;
	private URL             url;
	private Camera          camera;
	private Light           light;
	private Sphere          sphere;
	private GlowLight       glowLight;
	private Plane           plane;
	private Integer         height;
	private Integer         weigh;

	public JsonModel() {
	}

	public void cameraEngine() {

		if (this.camera == null) {
			this.camera = new Camera();
		}
		if (this.camera.getOrigin().isEmpty()) {
			this.camera.setOrigin(weigh, height);
		}
		if (this.camera.getDirection().isEmpty()) {
			this.camera.setDirection(weigh, height);
		}

		if (this.glowLight == null) {
			this.glowLight = new GlowLight();
		}

		if (this.light == null) {
			this.light = new Light();
		}

		if (this.plane == null) {
			this.plane = new Plane();
		}

		if (this.sphere == null) {
			this.sphere = new Sphere();
		}
	}

	public URL getUrl() {
		return url;
	}

	public void setUrl(URL url) {
		this.url = url;
	}

	public Integer getHeight() {
		return height;
	}

	public Sphere getSphere() {
		return sphere;
	}

	public void setSphere(Sphere sphere) {
		this.sphere = sphere;
	}

	public GlowLight getGlowLight() {
		return glowLight;
	}

	public void setGlowLight(GlowLight glowLight) {
		this.glowLight = glowLight;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getWeigh() {
		return weigh;
	}

	public void setWeigh(Integer weigh) {
		this.weigh = weigh;
	}

	public MultipartFile getMultipartFile() {
		return multipartFile;
	}

	public void setMultipartFile(MultipartFile multipartFile) {
		this.multipartFile = multipartFile;
	}

	public Plane getPlane() {
		return plane;
	}

	public void setPlane(Plane plane) {
		this.plane = plane;
	}

	public Camera getCamera() {
		return camera;
	}

	public void setCamera(Camera camera) {
		this.camera = camera;
	}

	public Light getLight() {
		return light;
	}

	public void setLight(Light light) {
		this.light = light;
	}
}
