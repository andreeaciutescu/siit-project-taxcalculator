package com.java.siit.taxcalculator.service.business;



import com.java.siit.taxcalculator.domain.entity.business.PfaEntity;

import com.java.siit.taxcalculator.domain.entity.business.SrlEntity;
import com.java.siit.taxcalculator.domain.model.business.PfaDTO;
import com.java.siit.taxcalculator.domain.model.business.SrlDTO;
import com.java.siit.taxcalculator.repository.business.SrlRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class SrlService {

    private final SrlRepository srlRepository;

    @Autowired
    private ModelMapper modelMapper;

    public void createSRL(SrlEntity dto) {
        srlRepository.save(SrlEntity.builder()
                .id(dto.getId())
                .loginId(dto.getLoginId())
                .fiscalYear(dto.getFiscalYear())
                .income(dto.getIncome())
                .CAS((dto.getIncome() * 0))
                .CASS((dto.getIncome() * 10 / 100))
                .incomeTaxes((dto.getIncome() * 0))
                .incomeTaxesPerMonth((dto.getIncome() * 3 / 100))
                .dividendTaxesPerMonth((dto.getIncome() * 5 / 100))


                .build());
    }
//    public void createSrl(SrlDTO dto) {
//        srlRepository.save(SrlEntity.builder()
//                .id(dto.getId())
//                .loginId(dto.getLoginId())
//                .income(dto.getIncome())
//                .fiscalYear(dto.getFiscalYear())
//                .CAS((dto.getIncome() * 0))
//                .CASS((dto.getIncome() * 10 / 100))
//                .incomeTaxes((dto.getIncome() * 0))
//                .incomeTaxesPerMonth(dto.getIncome() * 3 / 100))
//                .dividendTaxesPerMonth((dto.getIncome() * 5 / 100))
//                .build());
//    }
    public void updatePfa(SrlDTO dto) {
        srlRepository.save(SrlEntity.builder()
                .id(dto.getId())
                .loginId(dto.getLoginId())
                .income(dto.getIncome())
                .fiscalYear(dto.getFiscalYear())
                .CAS((dto.getIncome() * 25 / 100))
                .CASS((dto.getIncome() * 10 / 100))
                .incomeTaxes((dto.getIncome() * 10 / 100))
                .incomeTaxesPerMonth((dto.getIncome() * 0))
                .dividendTaxesPerMonth((dto.getIncome() * 0))
                .build());
    }

    public SrlDTO toDto(SrlEntity srlEntity) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        SrlDTO srlDTO = new SrlDTO();
        srlDTO = modelMapper.map(srlEntity, SrlDTO.class);
        return srlDTO;
    }

    public List<SrlEntity> findAll(SrlEntity srlEntity) {
        return srlRepository.findAll();
    }


    public void save(SrlEntity srlEntity) {
        srlRepository.save(srlEntity);
    }

    public SrlEntity get(Long id) {
        return srlRepository.findById(id).get();
    }

    public void delete(Long id) {
        srlRepository.deleteById(id);
    }
    public List<SrlEntity> findAllByLoginId(long loginId) {
        return srlRepository.findAllByLoginId(loginId);
    }
    public List<SrlEntity> findAllByFiscalYearAndLoginId (long fiscalYear, long loginId){
        return  srlRepository.findAllByFiscalYearAndLoginId(fiscalYear,loginId);
    }
    public List<SrlEntity> findAll(PfaEntity pfaEntity) {
        return srlRepository.findAll();
    }
}
