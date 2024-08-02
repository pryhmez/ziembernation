package com.heyrise.calendarAssessment.components.calendarComponent.core.calendarManagement.exception;

import com.heyrise.calendarAssessment.common.exception.HeyRiseBaseException;

public class BookingConflictException extends HeyRiseBaseException {
    public BookingConflictException(final String msg) {
        super(msg);
    }

    public BookingConflictException(final String msg, final Object... args) {
        super(msg, args);
    }

    public BookingConflictException(final Exception cause) {
        super(cause);
    }
}