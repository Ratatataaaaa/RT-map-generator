package com.example.springdemo.service;

import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public interface RTService {

	/**
	 * @param url
	 * @return
	 */
	BufferedImage readImage(final URL url) throws IOException;

	/**
	 * @param original
	 * @param weight
	 * @param height
	 * @return
	 */
	BufferedImage resizeImage(BufferedImage original, final int weight, final int height);

	/**
	 * @param bufferedImage
	 * @return
	 */
	StringBuilder getPixels(final BufferedImage bufferedImage);

	/**
	 * @param response
	 * @param map
	 */
	void writeMap(HttpServletResponse response, StringBuilder map) throws IOException;

}
