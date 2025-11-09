package com.etiya.customerservice.service.responses.city;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetListCityResponse {

    private Integer id;
    private String name;
}
