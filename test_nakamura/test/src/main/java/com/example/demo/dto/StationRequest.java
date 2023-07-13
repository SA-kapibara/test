package com.example.demo.dto;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "station", schema = "public")
public class StationRequest implements Serializable {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY) //登録する際に連番をつける
	@Column(name = "id")
	private Integer id;

	@Column(name = "station_name")
	private String station_name;

	
	@Column(name = "route_id")
	private Integer route_id;

}