package com.xworkz.cinexa.service.implementation;

import com.xworkz.cinexa.dto.SeatDto;
import com.xworkz.cinexa.repository.SeatRepository;
import com.xworkz.cinexa.service.interfaces.SeatService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class SeatServiceImpl implements SeatService {

    private final SeatRepository seatRepository;

    public SeatServiceImpl(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    @Override
    public List<SeatDto> getAllSeat() {
        List<SeatDto> seatDtos=new ArrayList<>();
        seatRepository.findAll().forEach(
                data->{
                    SeatDto seatDto=new SeatDto();
                    BeanUtils.copyProperties(data,seatDto);
                   seatDtos.add(seatDto);
                }
        );
        return seatDtos;
    }
}
