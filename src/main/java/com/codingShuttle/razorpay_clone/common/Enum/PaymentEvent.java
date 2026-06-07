package com.codingShuttle.razorpay_clone.common.Enum;

public enum PaymentEvent {
    AUTHORIZE_ATTEMPT,
    AUTHORIZE_SUCCESS,
    AUTHORIZE_FAIL,
    CAPTURE_REQUEST,
    CAPTURE_FAIL,
    CAPTURE_SUCCESS,
    REFUND_INIT,
    REFUND_COMPLETE,
    SETTLE,
    CANCEL,
    CAPTURE_TIMEOUT,
}
