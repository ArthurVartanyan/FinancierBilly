package com.financier.billy.service;

import com.financier.billy.dto.IncomeDTO;
import com.financier.billy.exception.runtime.NotFoundException;
import com.financier.billy.mapper.IncomeMapper;
import com.financier.billy.model.Income;
import com.financier.billy.repository.IncomeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IncomeService {

    private final UserService userService;
    private final IncomeMapper incomeMapper;
    private final IncomeRepository incomeRepository;

    /**
     * Add new income.
     *
     * @param incomeDTO - income data transfer object.
     * @return - new income ID.
     */
    public IncomeDTO addNewIncome(IncomeDTO incomeDTO) {
        if (!userService.userExistsById(incomeDTO.getUserId())) {
            throw new NotFoundException("User with id " + incomeDTO.getUserId() + " is not found!");
        }
        Income income = Income.builder()
                .amount(incomeDTO.getAmount())
                .dateTime(incomeDTO.getDateTime())
                .userId(incomeDTO.getUserId())
                .build();
        return incomeMapper.map(incomeRepository.save(income), IncomeDTO.class);
    }

    /**
     * Find all incomes.
     *
     * @return - all incomes data transfer objects.
     */
    public List<IncomeDTO> findAllIncomes() {
        return incomeMapper.mapAsList(incomeRepository.findAllByDeletedIsFalse(), IncomeDTO.class);
    }

    /**
     * Delete income by income ID.
     *
     * @param incomeId - income ID.
     */
    public void deleteIncome(Long incomeId) {
        Income income = incomeRepository
                .findById(incomeId)
                .orElseThrow(() -> new NotFoundException("Income with id " + incomeId + " is not found!"));
        income.setDeleted(true);
        incomeRepository.save(income);
    }

    public IncomeDTO findIncomeById(Long incomeId) {
        return incomeMapper.map(incomeRepository
                        .findById(incomeId)
                        .orElseThrow(() ->
                                new NotFoundException("Income with id " + incomeId + " is not found!")),
                IncomeDTO.class);
    }
}