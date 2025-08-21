package com.example.demo.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Image {

    private String imageName;
    private String imageType;
    @Lob // Large Object  or  Large Binary Object
    private byte[] imageData;
}
