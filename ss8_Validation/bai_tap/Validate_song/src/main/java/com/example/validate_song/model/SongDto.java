package com.example.validate_song.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class SongDto {
    private int id;
    @NotEmpty(message = "Không được để trống")
    @Pattern(regexp = "[a-zA-Z_ ]{2,800}", message = "Tên bài hát chưa đúng định dạng hoặc số ký tực vượt quá giới hạn")
    private String name;
    @NotEmpty(message = "Không được để trống")
    @Pattern(regexp = "[a-zA-Z_ ]{2,300}", message = "Tên nghệ sĩ chưa đúng định dạng hoặc số ký tực vượt quá giới hạn")
    private String singer;
    @NotEmpty(message = "Không được để trống")
    @Pattern(regexp = "[a-zA-Z(,)_ ]{2,1000}", message = "Loại bài hát chưa đúng định dạng hoặc số ký tực vượt quá giới hạn")
    private String type;

    public SongDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
