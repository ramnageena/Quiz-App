package com.quiz.app.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ResultResponse {
	private Integer id;
	private String response;

}
