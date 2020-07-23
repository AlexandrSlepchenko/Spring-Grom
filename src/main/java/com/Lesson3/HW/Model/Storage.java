package com.Lesson3.HW.Model;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "STORAGE")
public class Storage {
    public long id;
    private String[] formatsSupported;
    private String storageCountry;
    private long storageMaxSize;

    public Storage() {
    }

    @Id
    @SequenceGenerator(name = "S_SEQ" , sequenceName = "STORAGE_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_SEQ")
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    @Column(name = "FORMAT_SUPPORTED")
    public String[] getFormatsSupported() {
        return formatsSupported;
    }

    @Column(name = "STORAGE_COUNTRY")
    public String getStorageCountry() {
        return storageCountry;
    }

    @Column(name = "MAX_SIZE")
    public long getStorageMaxSize() {
        return storageMaxSize;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFormatsSupported(String[] formatsSupported) {
        this.formatsSupported = formatsSupported;
    }

    public void setStorageCountry(String storageCountry) {
        this.storageCountry = storageCountry;
    }

    public void setStorageMaxSize(long storageMaxSize) {
        this.storageMaxSize = storageMaxSize;
    }

    public String formatsSupportedToString() {
        String formats = Arrays.toString(formatsSupported);
        return formats.substring(1, formats.length() - 2);
    }

    public boolean isFormatSupported(String format) {
        for (String f : formatsSupported) {
            if (f.equals(format))
                return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return "Storage{" +
                "id=" + id +
                ", formatsSupported=" + Arrays.toString(formatsSupported) +
                ", storageCountry='" + storageCountry + '\'' +
                ", storageMaxSize='" + storageMaxSize + '\'' +
                '}';
    }
}