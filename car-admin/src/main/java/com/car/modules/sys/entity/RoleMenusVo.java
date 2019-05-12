package com.car.modules.sys.entity;

import java.util.List;

public class RoleMenusVo {
    private Long roleId;
    private String roleName;
    private List<Long>menuIds;

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public void setMenuIds(List<Long> menuIds) {
        this.menuIds = menuIds;
    }

    public Long getRoleId() {
        return roleId;
    }

    public List<Long> getMenuIds() {
        return menuIds;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
