package com.turistrazo.turistrazo.dto;

import lombok.Data;

@Data
public class DataPasswordDTO {

    private Integer id;
    private String newPassword;
    private String oldPassword;

}