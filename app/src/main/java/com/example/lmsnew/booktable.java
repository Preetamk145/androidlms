package com.example.lmsnew;

public class booktable {
    String authorname,name,id;

    public void setAuthorname(String authorname) {
        this.authorname = authorname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthorname() {
        return authorname;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public booktable(String authorname, String name, String id) {
        this.authorname = authorname;
        this.name = name;
        this.id = id;
    }
}
