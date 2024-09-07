package com.example.salestracking.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "menus")
@Data
public class Menu extends BaseEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long menuId;

    @Column(name = "menu_name")
    private String menuName;

    @Column(name = "menu_url")
    private String menuUrl;

    @Column(name = "menu_icon")
    private String menuIcon;

    @Column(name = "menu_parent_id")
    private Long menuParentId;

    @Column(name = "menu_type")
    private Integer menuType;

    @Column(name = "menu_visible")
    private Boolean menuVisible;

    @Column(name = "menu_order")
    private Integer menuOrder;

    @Column(name = "menu_status")
    private Boolean menuStatus;
}
