package com.example.kms.entity;

import jakarta.persistence.*;

public class Key {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer key_id;
    @OneToMany(fetch = FetchType.EAGER)
    @MapsId
    @JoinColumn(name = "audience_id")
    private Audience audience;
    @Enumerated(EnumType.STRING)
    private KeyState keyState;
    private boolean main;

    public Audience getAudience() {
        return audience;
    }

    public void setAudience(Audience audience) {
        this.audience = audience;
    }

    public KeyState getKeyState() {
        return keyState;
    }

    public void setKeyState(KeyState keyState) {
        this.keyState = keyState;
    }

    public boolean isMain() {
        return main;
    }

    public void setMain(boolean main) {
        this.main = main;
    }

    public Integer getKey_id() {
        return key_id;
    }
}
