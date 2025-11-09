package com.etiya.common.events.address;

public record UpdateAddressEvent(String id,
                                 String title,
                                 String street,
                                 String houseNumber,
                                 String description,
                                 Boolean isDefault,
                                 String customerId,
                                 String cityId,
                                 String cityName) {
}
