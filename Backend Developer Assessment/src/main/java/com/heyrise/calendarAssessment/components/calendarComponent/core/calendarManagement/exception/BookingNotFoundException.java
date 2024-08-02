package com.heyrise.calendarAssessment.components.calendarComponent.core.calendarManagement.exception;

import com.heyrise.calendarAssessment.common.exception.HeyRiseBaseException;

public class BookingNotFoundException extends HeyRiseBaseException {
    public BookingNotFoundException(final String msg) {
        super(msg);
    }

    public BookingNotFoundException(final String msg, final Object... args) {
        super(msg, args);
    }

    public BookingNotFoundException(final Exception cause) {
        super(cause);
    }
}
