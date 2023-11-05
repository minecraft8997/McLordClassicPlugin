package ru.mclord.classic.plugin;

import java.util.Objects;

public class CPE {
    /* package-private */ final String name;
    /* package-private */ final int version;
    /* package-private */ boolean active;

    public CPE(String name, int version) {
        this.name = name;
        this.version = version;
    }

    public final String getName() {
        return name;
    }

    public final int getVersion() {
        return version;
    }

    public final boolean isActive() {
        return active;
    }

    public void activate() {
        active = true;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CPE cpe = (CPE) o;

        return version == cpe.version && name.equals(cpe.name);
    }

    @Override
    public final int hashCode() {
        return Objects.hash(name, version);
    }

    @Override
    public String toString() {
        return "CPE{" +
                "name='" + name + '\'' +
                ", version=" + version +
                '}';
    }
}
