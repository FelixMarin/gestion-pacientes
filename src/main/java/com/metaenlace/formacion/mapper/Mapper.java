package com.metaenlace.formacion.mapper;

import org.modelmapper.ModelMapper;

public class Mapper {
	
	private static final ModelMapper MODEL_MAPPER = new ModelMapper();
	
	public static ModelMapper getModelMapper() {
		return MODEL_MAPPER;
	}
}
