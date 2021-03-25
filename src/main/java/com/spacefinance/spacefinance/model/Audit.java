package com.spacefinance.spacefinance.model;

import lombok.Getter;

import javax.persistence.Embeddable;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDate;
import java.util.Objects;

@Embeddable
@Getter
public class Audit {
    private LocalDate create;
    private LocalDate update;

    @PrePersist
    public void prePersist() {
        create = LocalDate.now();
    }

    @PreUpdate
    public void preUpdate() {
        update = LocalDate.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Audit)) return false;
        Audit audit = (Audit) o;
        return create.equals(audit.create);
    }

    @Override
    public int hashCode() {
        return Objects.hash(create);
    }
}
