package com.codingShuttle.razorpay_clone.common.Entity;


import jakarta.persistence.Embeddable;

@Embeddable
public class Money {

    private int amountUnits;

    private String currency;

    private Money(int amountUnits, String currency) {
        this.amountUnits = amountUnits;
        this.currency = currency;
    }

    public static Money of(int anoutnUnits, String currency) {
        return new Money(anoutnUnits, currency);
    }

    public Money add(Money money) {
        if (!this.currency.equals(money.currency)) {
            throw new IllegalArgumentException("Currency mismatch");
        }
        return new Money(this.amountUnits + money.amountUnits, this.currency);
    }
    public Money subtract(Money money) {
        if (!this.currency.equals(money.currency)) {
            throw new IllegalArgumentException("Currency mismatch");
        }
        return new Money(this.amountUnits - money.amountUnits, this.currency);
    }

}
