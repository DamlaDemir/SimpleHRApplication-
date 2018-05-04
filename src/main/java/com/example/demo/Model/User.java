package com.example.demo.Model;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private long id;

    @NotEmpty
    @NotBlank
    @Column(name = "name", nullable = false)
    private String name;

    @NotEmpty
    @NotBlank
    @Column(name = "lastname", nullable = false)
    private String lastname;

    @NotEmpty
    @NotBlank
    @Size(min=3, max=20)
    @Column(name = "username", nullable = false,unique = true)
    private String username;

    @NotEmpty
    @NotBlank
    @Size(min=6, max=10)
    @Column(name = "password", nullable = false)
    private String password;

    public User(String username,String password)
    {
        this.username=username;
        this.password=password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getName() {
        return name;
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("USER");
        List<SimpleGrantedAuthority> list = new ArrayList<SimpleGrantedAuthority>();
        list.add(simpleGrantedAuthority);
        return list;
    }
    @Override
    public String toString() {
        return username;
    }

}
