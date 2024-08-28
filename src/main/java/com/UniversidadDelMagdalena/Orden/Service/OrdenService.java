package com.UniversidadDelMagdalena.Orden.Service;


import com.UniversidadDelMagdalena.Orden.dto.OrdenDTO;

public interface OrdenService {
    OrdenDTO postOrder(OrdenDTO ordenDTO);
    OrdenDTO getOrderById(Long id);
    OrdenDTO putOrder(OrdenDTO ordenDTO, Long id);
    OrdenDTO patchOrder(OrdenDTO ordenDTO, Long id);
    void deleteOrder(Long id);
}