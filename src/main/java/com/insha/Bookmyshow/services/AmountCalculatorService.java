package com.insha.Bookmyshow.services;

import com.insha.Bookmyshow.Model.Show;
import com.insha.Bookmyshow.Model.ShowSeat;
import com.insha.Bookmyshow.Model.ShowSeatType;
import com.insha.Bookmyshow.Repositories.ShowSeatTypeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AmountCalculatorService {
    private ShowSeatTypeRepository showSeattypeRepository;
    @Autowired
    public AmountCalculatorService(ShowSeatTypeRepository showSeattypeRepository) {
        this.showSeattypeRepository = showSeattypeRepository;
    }

    public int calculateAmount(List<ShowSeat> showsSeats, Show show){
        List<ShowSeatType> showSeatTypes = showSeattypeRepository.findAllByShow(show);
        int amount = 0;
        for(ShowSeat showSeat:showsSeats){
            for(ShowSeatType showSeatType:showSeatTypes){
                if(showSeat.getSeat().getSeatType().equals(showSeatType.getSeatType())){
                    amount+=showSeatType.getPrice();
                    break;
                }
            }
        }
        return amount;
    }
}
