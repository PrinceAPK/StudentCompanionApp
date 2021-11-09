package com.example.studentcompanionapp.ui.faculty;

public class TeacherData {
    private String name, email, post, image, key;

    public TeacherData(){
    }

    public TeacherData(String name, String email, String post, String image, String key){
        this.name = name;
        this.email = email;
        this.post = post;
        this.image = image;
        this.key = key;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPost() { return post; }
    public String getImage() { return image; }
    public String getKey() { return key; }

    public void setName(String name) {this.name = name; }
    public void setEmail(String email) {this.name = email; }
    public void setPost(String post) {this.name = post; }
    public void setImage(String image) {this.name = image; }
    public void setKey(String key) {this.name = key; }
}
