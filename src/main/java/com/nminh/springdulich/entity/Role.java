package com.nminh.springdulich.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.nminh.springdulich.enums.RoleCode;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "roles")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Enumerated(EnumType.STRING) // lưu db ở dạng chuỗi
    @Column(nullable = false)
    private RoleCode roleCode;

    @OneToMany(mappedBy = "role" , cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<User> users;
    public Role() {

    }
    public Role(RoleCode roleCode) {
        this.roleCode = roleCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoleCode getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(RoleCode roleCode) {
        this.roleCode = roleCode;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
