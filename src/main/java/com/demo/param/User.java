package com.demo.param;

import lombok.Data;

/**
 * Create by lw on @date 2024/4/26.
 */
@Data
public class User {
    private String userId;
    private String role;
    private String[] endpoint;
}
