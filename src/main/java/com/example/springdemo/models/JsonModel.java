package com.example.springdemo.models;

import org.springframework.web.multipart.MultipartFile;

import java.net.URL;

public class JsonModel {

	private MultipartFile   multipartFile;
	private URL             url;
	private Camera          camera;
	private Light           light;
	private Sphere          sphere;
	private GlowLight       glowLight;
	private Plane           plane;
	private Torus           torus;
	private Integer         height;
	private Integer         weigh;

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

		if (this.torus == null) {
			this.torus = new Torus();
		}
	}

	@Override
	public String toString() {
		return "MultipartFile   " + multipartFile + "\n" +
				"URL             " + url + "\n" +
				"Camera          " + camera + "\n" +
				"Light           " + light + "\n" +
				"Sphere          " + sphere + "\n" +
				"GlowLight       " + glowLight +"\n" +
				"Plane           " + plane + "\n" +
				"Integer         " + height + "\n" +
				"Integer         " + weigh + "\n";
	}

	public JsonModel() {
	}

	public MultipartFile getMultipartFile() {
		return multipartFile;
	}

	public void setMultipartFile(MultipartFile multipartFile) {
		this.multipartFile = multipartFile;
	}

	public URL getUrl() {
		return url;
	}

	public void setUrl(URL url) {
		this.url = url;
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

	public Plane getPlane() {
		return plane;
	}

	public void setPlane(Plane plane) {
		this.plane = plane;
	}

	public Torus getTorus() {
		return torus;
	}

	public void setTorus(Torus torus) {
		this.torus = torus;
	}

	public Integer getHeight() {
		return height;
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

	public JsonModel(MultipartFile multipartFile,
	                 URL url, Camera camera,
	                 Light light,
	                 Sphere sphere,
	                 GlowLight glowLight,
	                 Plane plane,
	                 Torus torus,
	                 Integer height,
	                 Integer weigh) {
		this.multipartFile = multipartFile;
		this.url = url;
		this.camera = camera;
		this.light = light;
		this.sphere = sphere;
		this.glowLight = glowLight;
		this.plane = plane;
		this.torus = torus;
		this.height = height;
		this.weigh = weigh;
	}


}
