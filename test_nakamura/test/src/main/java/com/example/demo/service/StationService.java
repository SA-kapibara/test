package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.StationRequest;
import com.example.demo.entity.StationEntity;
import com.example.demo.repository.StationRepository;


@Service
@Transactional(rollbackFor = Exception.class)
public class StationService {
	
	@Autowired
	private StationRepository stationRepository;
	
	
	//全検索
	public List<StationEntity> searchAll() {
		return stationRepository.findAll();
	}
	
	//ID検索
	public StationEntity findBy_Id(Integer id) {
		return stationRepository.findById(id).get();
	}
	
	//削除
	public void delete(Integer id) {
		stationRepository.deleteById(id);
	}
	
	//更新
	public void update(StationRequest stationRequest) {
		StationEntity content = findBy_Id(stationRequest.getId());
		content.setId(stationRequest.getId());
		content.setStation_name(stationRequest.getStation_name());
		stationRepository.save(content);
	}
	
	//新規登録
	public void create(StationRequest stationRequest) {
		StationEntity data = new StationEntity();
		data.setStation_name(stationRequest.getStation_name());
		data.setId(stationRequest.getId());
		data.setRoute_id(stationRequest.getRoute_id());

		stationRepository.save(data);
	}
	

}