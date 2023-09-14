package com.example.app.translatejava.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.translatejava.request.TranslationRequest;
import com.example.app.translatejava.response.TranslationResponse;
import com.example.app.translatejava.service.TranslationService;

@RestController
@RequestMapping("/api/translator")
public class TranslationController {

	@Autowired
	private TranslationService translationService;

	@PostMapping
	public TranslationResponse translateText(@RequestBody TranslationRequest request) throws IOException {
		return translationService.translateText(request);
	}

}
