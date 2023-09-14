package com.example.app.translatejava.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.app.translatejava.request.TranslationRequest;
import com.example.app.translatejava.response.TranslationResponse;
import com.example.app.translatejava.service.impl.ITranslationService;
import com.google.cloud.translate.v3.LocationName;
import com.google.cloud.translate.v3.TranslateTextRequest;
import com.google.cloud.translate.v3.TranslateTextResponse;
import com.google.cloud.translate.v3.TranslationServiceClient;

@Service
public class TranslationService implements ITranslationService {
	
	@Value("${proyect.id}")
	private String proyectId;
	
	public TranslationResponse translateText(TranslationRequest translationRequest) throws IOException {
		TranslationResponse translationResponse = new TranslationResponse();
		
		translationResponse.setSourceLanguage(translationRequest.getSourceLanguage());
        translationResponse.setTargetLanguage(translationRequest.getTargetLanguage());
        translationResponse.setTextToTranslate(translationRequest.getTextToTranslate());
        translationResponse.setDateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss a")));

		try (TranslationServiceClient client = TranslationServiceClient.create()) {
            LocationName parent = LocationName.of(proyectId, "global");

            TranslateTextRequest request =
                TranslateTextRequest.newBuilder()
                    .setParent(parent.toString())
                    .setMimeType("text/plain")
                    .setSourceLanguageCode(translationRequest.getSourceLanguage())
                    .setTargetLanguageCode(translationRequest.getTargetLanguage())
                    .addContents(translationRequest.getTextToTranslate())
                    .build();

            TranslateTextResponse response = client.translateText(request);
            translationResponse.setResponseText(response.getTranslations(0).getTranslatedText());            
            
            return translationResponse;
        } catch (Exception e) {
            translationResponse.setResponseText(e.getMessage());
            return translationResponse;
		}
	}

}
