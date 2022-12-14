package com.etiya.ecommerscedemopair5.core.util.mapping;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ModelMapperManager implements ModelMapperService{

            // !!
    // response => ambiguity true, strategy loose
    //request => ambiguity true, strategty standart
    private ModelMapper modelMapper;

    public ModelMapper getMapper(){

        this.modelMapper.getConfiguration()
                .setAmbiguityIgnored(true)
                .setMatchingStrategy(MatchingStrategies.STANDARD);
        return this.modelMapper;
    }

    @Override
    public ModelMapper forResponse() {
        this.modelMapper.getConfiguration().
                setAmbiguityIgnored(true).
                setMatchingStrategy(MatchingStrategies.LOOSE);
        return this.modelMapper;
    }
    @Override
    public ModelMapper forRequest() {
        this.modelMapper.getConfiguration().
                setAmbiguityIgnored(true).
                setMatchingStrategy(MatchingStrategies.STANDARD);
        return this.modelMapper;
    }
}
