package com.example.app.translatejava.service.impl;

import java.io.IOException;

import com.example.app.translatejava.request.TranslationRequest;
import com.example.app.translatejava.response.TranslationResponse;

public interface ITranslationService {
	
	TranslationResponse translateText(TranslationRequest request) throws IOException;

}
