package com.codingdojo.SaveTravel.Travelservice;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.SaveTravel.TravelRepositories.TravelRepositories;
import com.codingdojo.SaveTravel.model.Travel;

import net.bytebuddy.asm.Advice.Return;

@Service
public class travelService {
	
	private final  TravelRepositories travelRepo;

	public travelService(TravelRepositories travelRepo) {
		this.travelRepo = travelRepo;
	}
	
	public List<Travel> allExpense(){
		return travelRepo.findAll();
	}
	 
	public Travel findExpense(Long id) {
		Optional<Travel> optionalExpense = travelRepo.findById(id);
		if (optionalExpense.isPresent()) {
			return optionalExpense.get();
		}
		else {
			return null;
		}
	}
	public Travel newExpense(Travel expense) {
		return travelRepo.save(expense);
	}
	
	public Travel editExpense(Travel expense,Long id) {
		Optional<Travel> expense1 = travelRepo.findById(id);
		if (expense1.isPresent()) {
			Travel expenses= expense1.get();
			expenses.setAmount(expense.getAmount());
			expenses.setDescription(expense.getDescription());
			expenses.setExpenseName(expense.getExpenseName());
			expenses.setVendor(expense.getVendor());
			return travelRepo.save(expenses);
			}
		else {
			return null;
		}
	}
	public void deleteExpense(Long id) {
			travelRepo.deleteById(id);
	}
}
