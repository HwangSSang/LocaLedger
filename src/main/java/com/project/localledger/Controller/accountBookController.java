package com.project.localledger.Controller;

import com.project.localledger.dto.AddExpenseForm;
import com.project.localledger.dto.AddIncomeForm;
import com.project.localledger.entity.AddExpense;
import com.project.localledger.entity.AddIncome;
import com.project.localledger.repository.ExpenseRepository;
import com.project.localledger.repository.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class accountBookController {

    @Autowired
    private IncomeRepository incomeRepository;
    @Autowired
    private ExpenseRepository expenseRepository;

    @GetMapping("/account")
    public String incomeAccount(Model model,
                                @ModelAttribute AddIncomeForm incomeForm,
                                @ModelAttribute AddExpenseForm expenseForm,
                                @RequestParam(value = "message", required = false ) String message) {
        if (expenseForm.getExpenseType() == null || expenseForm.getExpenseType().isEmpty()) {
            expenseForm.setExpenseType("온라인"); // 기본값 설정
        }

        model.addAttribute("incomeForm", incomeForm);
        model.addAttribute("expenseForm", expenseForm);
        model.addAttribute("isOnlineExpense", "온라인".equals(expenseForm.getExpenseType()));
        model.addAttribute("isOffLineExpense", "오프라인".equals(expenseForm.getExpenseType()));

        if (message != null && !message.isEmpty()) {
            model.addAttribute("message", message);
        }

        return"accountBook/accountMain";
    }

    @PostMapping("/income/add")
    public String addIncome(@ModelAttribute AddIncomeForm incomeForm, RedirectAttributes redirectAttributes) {
        //1. dto를 엔티티로 변환
        AddIncome addIncome = incomeForm.toEntity();
        System.out.println(addIncome.toString());
        //2. 리포지토리를 통해 엔티티를 디비에 저장
        AddIncome saved = incomeRepository.save(addIncome);
        System.out.println(saved.toString());
        redirectAttributes.addFlashAttribute("message", "수입이 저장되었습니다.");

        return "redirect:/account";
    }

    @PostMapping("/expense/add")
    public String addExpense(@ModelAttribute AddExpenseForm expenseForm, RedirectAttributes redirectAttributes) {
        //1. dto를 엔티티로 변환
        AddExpense addExpense = expenseForm.toEntity();
        System.out.println(addExpense.toString());
        //2. 리포지토리를 통해 엔티티를 디비에 저장
        AddExpense saved = expenseRepository.save(addExpense);
        System.out.println(saved.toString());

        redirectAttributes.addFlashAttribute("message", "지출이 저장되었습니다.");
        return"redirect:/account";
    }
}
