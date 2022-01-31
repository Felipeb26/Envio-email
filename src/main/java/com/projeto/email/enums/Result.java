package com.projeto.email.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Result {
	funcionando(1), erro(0);

	private int code;
}
