package com.heyrise.calendarAssessment.components.calendarComponent.core.calendarManagement.exception;


import com.heyrise.calendarAssessment.common.exception.HeyRiseBaseException;

public class InvalidBookingTimeException extends HeyRiseBaseException {
    public InvalidBookingTimeException(final String msg) {
        super(msg);
    }

    public InvalidBookingTimeException(final String msg, final Object... args) {
        super(msg, args);
    }

    public InvalidBookingTimeException(final Exception cause) {
        super(cause);
    }
}