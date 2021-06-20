package com.example.springdemo.service.impl;

import com.example.springdemo.model.simpl.Sphere;
import com.example.springdemo.service.RTService;
import org.imgscalr.Scalr;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class RTServiceImpl implements RTService {

	@Override
	public BufferedImage readImage(URL url) throws IOException {
		try (InputStream inputStream = url.openStream()) {
			return ImageIO.read(inputStream);
		}
	}

	@Override
	public BufferedImage resizeImage(BufferedImage original, int weight, int height) {
		return Scalr.resize(original,
				Scalr.Mode.FIT_EXACT,
				weight,
				height);
	}

	@Override
	public StringBuilder getPixels(BufferedImage bufferedImage) {
		StringBuilder pixels = new StringBuilder();
		Sphere sphere = new Sphere();

		for (int i = 0; i < bufferedImage.getHeight(); i++) {
			for (int j = 0; j < bufferedImage.getWidth(); j++) {
				int rgb = bufferedImage.getRGB(j, i);
				sphere.setColor(rgb);
				sphere.setRadius(Math.max(getZ(rgb, 0) / 50f, 1));
				sphere.setOrigin(j * 10, -(i * 10), getZ(rgb, Math.max(bufferedImage.getHeight(), bufferedImage.getWidth())));
				pixels.append(sphere.toString());
			}
		}
		return pixels;
	}

	@Override
	public void writeMap(HttpServletResponse response, StringBuilder map) throws IOException {
		try (ServletOutputStream outputStream = response.getOutputStream()) {
			outputStream.write(map.toString().getBytes());
			response.addHeader("Hello", "Hello " + SecurityContextHolder.getContext().getAuthentication().getName());
			response.setContentType("text/scene");
		}
	}

	private int getZ(int rgb, int max) {
		int r = (rgb >> 0 & 0xff);
		int g = (rgb >> 8 & 0xff);
		int b = (rgb >> 16 & 0xff);

		return (((r + g + b) / 3));
	}

	private Boolean isLight(int rgb) {
		return (rgb >> 16 & 0xff) > 245 && (rgb >> 8 & 0xff) > 245 && (rgb & 0xff) > 245;
	}

	private boolean isLight(int height, int weigh, int x, int y) {
		int stepH = height / 3;
		int stepW = weigh / 3;

		return (x == stepW || x == stepW * 2) && (y == stepH || y == stepH * 2);

	}
}