package com.geo.geodesyhelpserver.model.project;

import com.geo.geodesyhelpserver.model.BaseEntity;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.Lob;

@Entity
public class ProjectFile extends BaseEntity {

    private String name;
    private Long size;
    private String type;
    @Lob
    @Type(type = "org.hibernate.type.TextType")
    private String base64;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBase64() {
        return base64;
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }
}
