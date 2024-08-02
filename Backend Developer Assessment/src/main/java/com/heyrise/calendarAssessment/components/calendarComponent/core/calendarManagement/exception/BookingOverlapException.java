package com.heyrise.calendarAssessment.components.calendarComponent.core.calendarManagement.exception;


import com.heyrise.calendarAssessment.common.exception.HeyRiseBaseException;

public class BookingOverlapException extends HeyRiseBaseException {
    public BookingOverlapException(final String msg) {
        super(msg);
    }

    public BookingOverlapException(final String msg, final Object... args) {
        super(msg, args);
    }

    public BookingOverlapException(final Exception cause) {
        super(cause);
    }
}
