package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.dto.StationRequest;
import com.example.demo.entity.StationEntity;
import com.example.demo.service.StationService;

@Controller
public class TestController {
	@Autowired
	StationService stationService;
	
	//home画面を表示
	@GetMapping("home")
	public String displayList(Model model) {
		List<StationEntity> stationlist = stationService.searchAll();
		model.addAttribute("stationlist", stationlist);
		return "home";
	}
	
	
	//削除
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id, StationRequest stationRequest) { //UserRequest userRequest
		int station_id= stationRequest.getId();
		stationService.delete(station_id);
		return "redirect:/home";
	}
	
	
	//編集画面を表示
	@GetMapping("/edit/{id}")
	public String displayEdit(@PathVariable Integer id, Model model) {
		StationEntity editEntity = stationService.findBy_Id(id); //編集するものを取得
		StationRequest editForm = new StationRequest();
		editForm.setId(editEntity.getId()); //IDを取得
		editForm.setStation_name(editEntity.getStation_name()); //コンテンツを取得
		model.addAttribute("editForm", editForm); //取得したものをページに渡す

		return "edit";
	}
	
	//編集ボタンが押されたら
	@GetMapping("/update/{id}")
	String update(@Validated StationRequest stationRequest) {

		stationService.update(stationRequest);
		return "redirect:/home";
	}
	
	
	//新規登録画面を表示
	@GetMapping("/add")
	public String displayAdd(Model model) {
		//入力されたものの箱を用意
		model.addAttribute("add_userRequest", new StationRequest());
		return "add";
	}
	
	//新規登録ボタンが押されたら
	@GetMapping("/add/create")
	public String create(@Validated @ModelAttribute StationRequest stationRequest,
			Model model) {

		// ユーザー情報の登録
		stationService.create(stationRequest);
		//return "redirect:/user/{id}";
		return "redirect:/home";
	}
	
}