package com.example.salestracking.dto.request.menu;

import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Data
public class CreateMenuRequest
{
    @NotBlank(message = "Menu Name is mandatory")
    private String menuName;
    private String menuUrl;
    private String menuIcon;
    private Boolean menuVisible;
    private Long menuParentId;
    private Integer menuType;
    private Integer menuOrder;
    private Boolean menuStatus;
}
