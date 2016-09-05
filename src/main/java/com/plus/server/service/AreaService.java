package com.plus.server.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plus.server.dal.AirportDAO;
import com.plus.server.dal.CityDAO;
import com.plus.server.dal.CountryDAO;
import com.plus.server.model.Airport;
import com.plus.server.model.City;
import com.plus.server.model.Country;

@Service
public class AreaService {
	private static final Logger log = LoggerFactory.getLogger(AreaService.class);
	@Autowired
	private CountryDAO countryDAO;
	@Autowired
	private CityDAO cityDAO;
	@Autowired
	private AirportDAO airportDAO;

	public List<Country> selectCountryByModel(Country c) {
		return this.countryDAO.selectByModel(c);
	}
	public List<City> selectCityByModel(City c) {
		return this.cityDAO.selectByModel(c);
	}
	public List<Airport> selectAirportByModel(Airport c) {
		return this.airportDAO.selectByModel(c);
	}

}
