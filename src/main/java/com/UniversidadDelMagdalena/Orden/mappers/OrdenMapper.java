package com.UniversidadDelMagdalena.Orden.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.UniversidadDelMagdalena.Orden.Entities.Orden;
import com.UniversidadDelMagdalena.Orden.dto.OrdenDTO;

@Mapper
public interface OrdenMapper {
    OrdenMapper INSTANCE = Mappers.getMapper(OrdenMapper.class);

    public OrdenDTO ordenToOrdendto(Orden orden);

    public Orden ordendtoToOrden(OrdenDTO ordenDTO);
}
