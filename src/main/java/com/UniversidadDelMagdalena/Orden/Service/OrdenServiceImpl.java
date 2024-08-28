package com.UniversidadDelMagdalena.Orden.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.UniversidadDelMagdalena.Orden.Entities.Orden;
import com.UniversidadDelMagdalena.Orden.Repository.OrdenRepository;
import com.UniversidadDelMagdalena.Orden.dto.OrdenDTO;
import com.UniversidadDelMagdalena.Orden.mappers.OrdenMapper;

import jakarta.persistence.EntityNotFoundException;

@Service
public class OrdenServiceImpl implements OrdenService {
    @Autowired
    private OrdenRepository ordenRepository;

    @Override
    public OrdenDTO postOrder(OrdenDTO ordenDTO) {
        if (ordenDTO == null) {
            throw new IllegalArgumentException("El objeto OrdenDTO no puede ser null.");
        }
        try {
            Orden order = OrdenMapper.INSTANCE.ordendtoToOrden(ordenDTO);
            order = ordenRepository.save(order);
            return OrdenMapper.INSTANCE.ordenToOrdendto(order);
        } catch (Exception e) {
            throw new IllegalStateException("Se ha producido un error creando la orden.", e);
        }
    }

    @Override
    public OrdenDTO getOrderById(Long id) {
        try {
            if (!ordenRepository.existsById(id)) {
                throw new IllegalArgumentException("La orden no ha sido encontrada.");
            }
            Orden order = ordenRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("La orden no ha sido encontrada."));
            return OrdenMapper.INSTANCE.ordenToOrdendto(order);
        } catch (Exception e) {
            throw new UnsupportedOperationException("Se ha producido un error obteniendo la orden.");
        }
    }

    @Override
    public OrdenDTO putOrder(OrdenDTO ordenDTO, Long id) {
        try {
            if (id == null) {
                throw new IllegalArgumentException("El ID de la orden no puede ser nulo.");
            }
            Orden orderFromDB = ordenRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Order not found"));
            orderFromDB.setProductId(ordenDTO.getProductId());
            orderFromDB.setQuantity(ordenDTO.getQuantity());
            orderFromDB.setStatus(ordenDTO.getStatus());
            orderFromDB.setUserId(ordenDTO.getUserId());
            Orden savedOrder = ordenRepository.save(orderFromDB);
            return OrdenMapper.INSTANCE.ordenToOrdendto(savedOrder);
        } catch (Exception e) {
            throw new UnsupportedOperationException("Se ha producido un error creando la orden.");
        }
    }

    @Override
    public OrdenDTO patchOrder(OrdenDTO ordenDTO, Long id) {
        try {

            Orden orden = ordenRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("La orden con ID " + id + " no existe."));
            if (ordenDTO.getProductId() != null) {
                orden.setProductId(ordenDTO.getProductId());
            }
            if (ordenDTO.getQuantity() != null) {
                orden.setQuantity(ordenDTO.getQuantity());
            }
            if (ordenDTO.getStatus() != null) {
                orden.setStatus(ordenDTO.getStatus());
            }
            if (ordenDTO.getUserId() != null) {
                orden.setUserId(ordenDTO.getUserId());
            }
            orden = ordenRepository.save(orden);
            return OrdenMapper.INSTANCE.ordenToOrdendto(orden);
        } catch (Exception e) {
            throw new EntityNotFoundException("La orden con ID " + id + " no existe.");
        }

    }

    @Override
    public void deleteOrder(Long id) {
        try {
            if (ordenRepository.existsById(id)) {
                ordenRepository.deleteById(id);
            } else {
                throw new EntityNotFoundException("La orden con ID " + id + " no existe.");
            }
        } catch (Exception e) {
            throw new UnsupportedOperationException("Se ha producido un error eliminando la orden.");
        }
    }

}
