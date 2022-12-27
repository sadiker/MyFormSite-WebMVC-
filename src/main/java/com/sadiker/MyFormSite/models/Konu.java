package com.sadiker.MyFormSite.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name="konular")
public class Konu {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 100)
    private String name;

    @OneToMany(mappedBy = "konu",fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    private List<Yorum> yorumlar;

    @ManyToOne()
    private User user ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Yorum> getYorumlar() {
        return yorumlar;
    }

    public void setYorumlar(List<Yorum> yorumlar) {
        this.yorumlar = yorumlar;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    

    
}
