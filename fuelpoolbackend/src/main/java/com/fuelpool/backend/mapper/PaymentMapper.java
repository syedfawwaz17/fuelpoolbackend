package com.fuelpool.backend.mapper;

import com.fuelpool.backend.dto.PaymentDto;
import com.fuelpool.backend.entity.Payment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentMapper {
    PaymentDto toDto(Payment entity);
    Payment toEntity(PaymentDto dto);
}
