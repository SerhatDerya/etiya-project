package com.etiya.common.events;



public record CreateAddressEvent(String id,
                                 String title,
                                 String street,
                                 String houseNumber,
                                 String description,
                                 Boolean isDefault,
                                 String customerId,
                                 String cityId,
                                 String cityName) {
}
