package com.hjh.movie.model;

public enum UserRole
{
    NORMAL("일반 관람객", 3),
    CRITIC("전문 평론가", 2),
    ADMIN("관리자", 1);

    private final String label;
    private final int value;

    UserRole(String label, int value)
    {
        this.label = label;
        this.value = value;
    }

    public String getLabel()
    {
        return label;
    }

    public int getValue()
    {
        return value;
    }
}
