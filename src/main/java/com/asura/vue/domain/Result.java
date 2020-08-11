package com.asura.vue.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author asura
 * @version 1.0.0
 * @date 2020/8/7/007 21:56
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result implements Serializable {
    private Boolean success;
    private String message;
}
