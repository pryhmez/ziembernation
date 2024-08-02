package com.heyrise.calendarAssessment.components.calendarComponent.core.calendarManagement.exception;

import com.heyrise.calendarAssessment.common.exception.HeyRiseBaseException;

public class ResourceNotFoundException extends HeyRiseBaseException {
    public ResourceNotFoundException(final String msg) {
        super(msg);
    }

    public ResourceNotFoundException(final String msg, final Object... args) {
        super(msg, args);
    }

    public ResourceNotFoundException(final Exception cause) {
        super(cause);
    }
}
