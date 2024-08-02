package com.heyrise.calendarAssessment.components.calendarComponent.core.calendarManagement.exception;

import com.heyrise.calendarAssessment.common.exception.HeyRiseBaseException;

public class CalendarNotFoundException extends HeyRiseBaseException {
    public CalendarNotFoundException(final String msg) {
        super(msg);
    }

    public CalendarNotFoundException(final String msg, final Object... args) {
        super(msg, args);
    }

    public CalendarNotFoundException(final Exception cause) {
        super(cause);
    }
}
