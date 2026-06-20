package com.Hotel_Reservation_System.validation;

import java.util.List;

public interface Validator<T> {
    List<String> validate(T target);
}
