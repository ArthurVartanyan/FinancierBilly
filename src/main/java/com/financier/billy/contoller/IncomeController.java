package com.financier.billy.contoller;

import com.financier.billy.dto.IncomeDTO;
import com.financier.billy.service.IncomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/income")
public class IncomeController {

    private final IncomeService incomeService;

    @GetMapping(value = "/{incomeId}")
    public ResponseEntity<IncomeDTO> findIncomeById(@PathVariable Long incomeId) {
        return new ResponseEntity<>(incomeService.findIncomeById(incomeId), HttpStatusCode.valueOf(200));
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<IncomeDTO>> findAllIncomes() {
        return new ResponseEntity<>(incomeService.findAllIncomes(), HttpStatusCode.valueOf(200));
    }

    @PostMapping(value = "/")
    public ResponseEntity<IncomeDTO> addNewIncome(@RequestBody IncomeDTO incomeDTO) {
        return new ResponseEntity<>(incomeService.addNewIncome(incomeDTO), HttpStatusCode.valueOf(201));
    }

    @DeleteMapping(value = "/{incomeId}")
    public ResponseEntity<Void> deleteIncomeById(@PathVariable Long incomeId) {
        incomeService.deleteIncome(incomeId);
        return new ResponseEntity<>(HttpStatusCode.valueOf(200));
    }
}