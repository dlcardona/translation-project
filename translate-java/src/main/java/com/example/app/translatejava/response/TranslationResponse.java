package com.example.app.translatejava.response;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TranslationResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String sourceLanguage;
	private String targetLanguage;
	private String textToTranslate;
	private String responseText;
	private String dateTime;

}
