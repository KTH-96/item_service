package com.app.itemservice.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorMessage {

	//400 ~
	ITEM_ID_NOT_FOUND(HttpStatus.BAD_REQUEST, "해당 아이템의 아이디를 찾을 수 없습니다.");

	private final HttpStatus httpStatus;
	private final String message;
}
