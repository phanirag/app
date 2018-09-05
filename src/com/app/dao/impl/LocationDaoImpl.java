package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ILocationDao;
import com.app.model.Location;

@Transactional
@Repository
public class LocationDaoImpl implements ILocationDao {

	@Autowired
	private HibernateTemplate ht;

	@Override
	public int saveLocation(Location loc) {
		return (Integer) ht.save(loc);
	}

	@Override
	public void updateLocation(Location loc) {
		ht.update(loc);
	}

	@Override
	public void deleteLocation(int locId) {
		ht.delete(new Location(locId));
	}

	@Override
	public Location getLocationById(int locId) {
		return ht.get(Location.class, locId);
	}

	@Override
	public List<Location> getAllLocations() {
		return ht.loadAll(Location.class);
	}
	
	@Override
	public List<Object[]> getLocationTypeCount() {
		String hql=" select locType,count(locType) from com.app.model.Location group by locType";
		@SuppressWarnings("unchecked")
		List<Object[]> list=ht.find(hql);
		return list;
	}
	
	
	
	
	
	
	

}