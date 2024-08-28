package com.UniversidadDelMagdalena.Orden.dto;

import lombok.Data;

@Data
public class OrdenDTO {
    private Long id;
    private Long userId;
    private Long productId;
    private Integer quantity;
    private String status;
}
