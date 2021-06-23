package com.example.springdemo.controller;

import com.example.springdemo.model.rt.MapModel;
import com.example.springdemo.service.RTService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

@RestController
@RequestMapping("/rtMap")
public class RTController {
	private static final Logger log = LoggerFactory.getLogger(RTController.class);

	@Autowired
	private RTService rtService;

	@PostMapping
	public String getModel(@ModelAttribute MapModel mapModel,
	                       BindingResult bindingResult,
	                       HttpServletResponse response) throws IOException {
		StringBuilder rtMap;
		BufferedImage bufferedImage;
		BufferedImage newImage;

		log.info("Свет, камера, сцена!\n" + mapModel.toString());
		rtMap = mapModel.cameraEngine();

		log.info("Изображение: " + mapModel.getUrl());
		bufferedImage = rtService.readImage(mapModel.getUrl());

		log.info("Меняем рзмер Ширина х Высота: " + mapModel.getWidth() + " x " + mapModel.getHeight());
		newImage = rtService.resizeImage(bufferedImage, mapModel.getWidth(), mapModel.getHeight());

		log.info("Пишем пиксели.");
		rtMap.append(rtService.getPixels(newImage));
		rtService.writeMap(response, rtMap);
		log.info("Ставим подпись. Готово!");
		return "rt";
	}
}
