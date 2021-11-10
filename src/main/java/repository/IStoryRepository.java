package repository;

import model.Story;

import java.util.List;

public interface IStoryRepository {
    List<Story> getStories();

    Story getById(int id);

    boolean exist(int id);

    void update(Story story);

    void add(Story story);

    void delete(int id);

    boolean exist(Story newStory);
}
