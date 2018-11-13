package org.library.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="No such Reader")  // 404
public class ReaderNotAvailableException extends RuntimeException {
}
