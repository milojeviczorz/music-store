package com.music.store.app.utils;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("dto")
public class DTOManager<BO, DO> {

	@Autowired
	private Mapper mapper;

	public List<DO> convertToBO(List<BO> businessObjects, Class<DO> domainClass, String... mapId) {

		List<DO> list = new ArrayList<>();

		for (BO b : businessObjects) {
			list.add(convert(b, domainClass, mapId));
		}

		return list;
	}

	public DO convert(BO businessObject, Class<DO> domainClass, String... mapId) {
		return mapper.map(businessObject, domainClass, getMapId(mapId));
	}

	private String getMapId(String... mapId) {
		return (mapId != null && mapId.length > 0) ? mapId[0] : null;
	}

}
