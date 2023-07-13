package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "station", schema = "public")
public class StationEntity  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //登録する際に連番をつける
	@Column(name = "id")
	private Integer id;

	@Column(name = "station_name")
	private String station_name;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "route_id")
	private Integer route_id;
}