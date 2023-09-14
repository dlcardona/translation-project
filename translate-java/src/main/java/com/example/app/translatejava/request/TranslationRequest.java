package com.example.app.translatejava.request;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TranslationRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private String sourceLanguage;
	private String targetLanguage;
	private String textToTranslate;

}
