package com.hlkj.pojo.model;

import lombok.Data;

@Data
public class File {
    private Long id;
    private String name;
    private String groupname;
    private String path;

    public File(String name, String groupname, String path) {
        this.name = name;
        this.groupname = groupname;
        this.path = path;
    }
}
