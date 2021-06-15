package com.example.springdemo.controllers;

import com.example.springdemo.models.JsonModel;
import org.imgscalr.Scalr;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@RestController
@RequestMapping("/rt")
public class RTController {

	@PostMapping
	public void getModel(@ModelAttribute JsonModel jsonModel,
	                     BindingResult bindingResult,
	                     HttpServletResponse response) throws IOException {


		String resp;
		BufferedImage bufferedImage;
		BufferedImage newImage;
		Integer z = 0;

		System.out.println("Свет, камера, сцена!\n" + jsonModel.toString());
		jsonModel.cameraEngine();
		resp = jsonModel.getCamera().toString() + jsonModel.getLight().toString() + jsonModel.getPlane().toString();

		System.out.println("Изображение: " + jsonModel.getUrl());
		bufferedImage = ImageIO.read(jsonModel.getUrl().openStream());

		System.out.println("Меняем рзмер Ширина х Высота: " + jsonModel.getWeigh() + " x " + jsonModel.getHeight());
		newImage = Scalr.resize(bufferedImage,
				Scalr.Mode.FIT_EXACT,
				jsonModel.getWeigh(),
				jsonModel.getHeight());
		System.out.println("Пишем пиксели.");
		for (int i = 0; i < jsonModel.getHeight(); i++) {
			for (int j = 0; j < jsonModel.getWeigh(); j++) {
				Random random = new Random();
				Integer rgb = newImage.getRGB(j, i);
				if (false) {
					jsonModel.getGlowLight().setColor(rgb);
					jsonModel.getGlowLight().setOrigin(i * 5, -(j * 5), 500);
					resp = resp + jsonModel.getGlowLight().toString();
				} else {
					jsonModel.getSphere().setColor(rgb);
					jsonModel.getSphere().setRadius(Math.max(getZ(rgb, 0) / 50f, 1));
					jsonModel.getSphere().setOrigin(j * 10, -(i * 10), getZ(rgb, Math.max(jsonModel.getHeight(), jsonModel.getWeigh())));
					resp = resp + jsonModel.getSphere().toString();
				}

			}
		}
		System.out.println("Ставим подпись. Готово!");
		response.addHeader("Hello", "hello pidor");
		response.setContentType("text/scene");
		response.getOutputStream().print(resp);
	}

	private Boolean isLight(int rgb) {
		if ((rgb >> 16 & 0xff) > 245 && (rgb >> 8 & 0xff) > 245 && (rgb & 0xff) > 245) {
			return true;
		}
		return false;
	}

	@ModelAttribute(value = "jsonmodel")
	public JsonModel getJsonModel() {
		return new JsonModel();
	}

	private Integer getZ(int rgb, int max) {
		int r = (rgb >> 0 & 0xff);
		int g = (rgb >> 8 & 0xff);
		int b = (rgb >> 16 & 0xff);
		return (((r + g + b) / 3) );
	}

	private boolean isLight(int height, int weigh, int x, int y) {

		int stepH = height / 3;
		int stepW = weigh / 3;

		if ((x == stepW || x == stepW * 2) && (y == stepH || y == stepH * 2)) {
			return true;
		}
		return false;

	}
}
