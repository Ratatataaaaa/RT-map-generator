package com.example.springdemo.model;

import com.example.springdemo.model.simpl.Plane;
import com.example.springdemo.model.simpl.Sphere;
import com.example.springdemo.model.simpl.Torus;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.net.URL;

@Component
public class MapModel {

	private static URL url;
	private static Camera camera;
	private static Light light;
	private static PointLight pointLight;
	private static Plane plane;
	private static Integer height;
	private static Integer width;

	public StringBuilder cameraEngine() {

		StringBuilder engineResponse = new StringBuilder();

		if (camera == null) {
			camera = new Camera();
		}
		if (camera.getOrigin().size() != 3) {
			camera.setOrigin(width, height);
		}
		if (camera.getDirection().size() != 3) {
			camera.setDirection(width, height);
		}
		engineResponse.append(camera.toString());

		if (light == null) {
			light = new Light();
		}
		engineResponse.append(light.toString());

		if (plane == null || plane.getOrigin().size() != 3) {
			plane = new Plane();
			plane.setOrigin(0, 0, -15);
		}
		engineResponse.append(plane.toString());

		if (pointLight == null) {
			pointLight = new PointLight();
			pointLight.setColor(0x7b70f3);
			pointLight.setOrigin(width, height);
			pointLight.setIntensity(1f);
		}
		engineResponse.append(pointLight.toString());
		return engineResponse;
	}

	@Override
	public String toString() {
		return "URL             " + url + "\n" +
				"Camera          " + camera + "\n" +
				"Light           " + light + "\n" +
				"GlowLight       " + pointLight + "\n" +
				"Plane           " + plane + "\n" +
				"Integer         " + height + "\n" +
				"Integer         " + width + "\n";
	}

	public MapModel() {
	}

	public URL getUrl() {
		return url;
	}

	public void setUrl(URL url) {
		MapModel.url = url;
	}

	public Camera getCamera() {
		return camera;
	}

	public void setCamera(Camera camera) {
		MapModel.camera = camera;
	}

	public Light getLight() {
		return light;
	}

	public void setLight(Light light) {
		MapModel.light = light;
	}

	public PointLight getGlowLight() {
		return pointLight;
	}

	public void setGlowLight(PointLight pointLight) {
		MapModel.pointLight = pointLight;
	}

	public Plane getPlane() {
		return plane;
	}

	public void setPlane(Plane plane) {
		MapModel.plane = plane;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		MapModel.height = height;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		MapModel.width = width;
	}

	public MapModel(URL url, Camera camera,
	                Light light,
	                PointLight pointLight,
	                Plane plane,
	                Integer height,
	                Integer width) {
		MapModel.url = url;
		MapModel.camera = camera;
		MapModel.light = light;
		MapModel.pointLight = pointLight;
		MapModel.plane = plane;
		MapModel.height = height;
		MapModel.width = width;
	}

}
