package com.fuelpool.backend.service;

import com.fuelpool.backend.dto.FuelPriceRecordDto;
import com.fuelpool.backend.entity.FuelPriceRecord;
import com.fuelpool.backend.mapper.FuelPriceRecordMapper;
import com.fuelpool.backend.repository.FuelPriceRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FuelPriceService {
    private final FuelPriceRecordRepository fuelPriceRepo;
    private final FuelPriceRecordMapper fuelPriceMapper;

    public List<FuelPriceRecordDto> getLatestByCityAndType(String city, String fuelType) {
        return fuelPriceRepo.findByCityAndFuelTypeOrderByTimestampDesc(city, fuelType)
                .stream().map(fuelPriceMapper::toDto).collect(Collectors.toList());
    }

    public FuelPriceRecordDto add(FuelPriceRecordDto dto) {
        FuelPriceRecord rec = fuelPriceMapper.toEntity(dto);
        rec.setTimestamp(Instant.now());
        return fuelPriceMapper.toDto(fuelPriceRepo.save(rec));
    }
}
