package com.greenuniv.greenuniv.service.login;


import com.greenuniv.greenuniv.dto.terms.TermsDTO;
import com.greenuniv.greenuniv.entity.terms.TermsEntity;
import com.greenuniv.greenuniv.repository.login.TermsRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class TermsService {

    private final TermsRepository termsRepository;
    private final ModelMapper modelMapper;


    public TermsDTO term(){

        Optional<TermsEntity> term = termsRepository.findById(1);


        if(term.isPresent()){

            TermsEntity termsEntity = term.get();

            TermsDTO termDTO = modelMapper.map(termsEntity, TermsDTO.class);

            return termDTO;
        }

        return null;
    }

    public TermsDTO privacy(){

        Optional<TermsEntity> privacy = termsRepository.findById(2);

        if(privacy.isPresent()){

            TermsEntity termEntity = privacy.get();

            TermsDTO privacyDTO = modelMapper.map(termEntity, TermsDTO.class);

            return privacyDTO;
        }


        return null;

    }




}
