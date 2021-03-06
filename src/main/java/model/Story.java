package model;

import java.util.Objects;

public class Story {
    private int id;
    private String name;
    private String category;
    private String path;
    private String author;


    public Story() {

    }

    public Story(int id, String name, String category, String path, String author) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.path = path;
        this.author = author;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Story story = (Story) o;
        return id == story.id && Objects.equals(name, story.name) && Objects.equals(category, story.category) && Objects.equals(path, story.path) && Objects.equals(author, story.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, category, path, author);
    }
}
