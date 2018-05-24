package com.samtec.location.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samtec.location.entities.Location;
import com.samtec.location.repos.LocationRepository;





@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
	LocationRepository locationrepo;
	
	
	@Override
	public Location saveLocation(Location location) {
		return	locationrepo.save(location);
	}

	@Override
	public Location updateLocation(Location location) {

		return locationrepo.save(location);
	
	}

	@Override
	public void deleteLocation(Location location) {

		locationrepo.delete(location);
	}

	@Override
	public Location getLocationById(int id) {

		return locationrepo.findById(id).get();
	
	}

	@Override
	public List<Location> getAllLocation() {
		return locationrepo.findAll();
	}

	public LocationRepository getLocationrepo() {
		return locationrepo;
	}

	public void setLocationrepo(LocationRepository locationrepo) {
		this.locationrepo = locationrepo;
	}

}
