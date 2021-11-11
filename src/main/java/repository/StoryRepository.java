package repository;

import model.Story;

import services.JacksonParser;

import utils.TextFile;


import java.util.List;


public class StoryRepository implements IStoryRepository {
    public final static String filePath = "data/story.json";

    @Override
    public List<Story> getStories() {
        return JacksonParser.INSTANCE.toList(TextFile.read(filePath), Story.class);
    }

    @Override
    public Story getById(int id) {
        for (Story story : getStories()) {
            if (story.getId() == id)
                return story;
        }
        return null;
    }

    @Override
    public boolean exist(int id) {
        return getById(id) != null;
    }

    @Override
    public void update(Story story) {
        //return getById(id) != null;
    }

    @Override
    public void add(Story newStory) {
        List<Story> stories = getStories();
        stories.add(newStory);
        String json = JacksonParser.INSTANCE.toJson(stories);
        TextFile.write(filePath, json);
    }
    @Override
    public void edit(int id) {
        List<Story> stories = getStories();
        for (Story story : getStories()) {
            if (story.getId() == id) {

                String json = JacksonParser.INSTANCE.toJson(stories);
                TextFile.write(filePath, json);
                break;
            }
        }
    }
    @Override
    public void delete(int id) {
        List<Story> stories = getStories();
        for (Story story: getStories()) {
          if(story.getId()==id) {
              stories.remove(story);
              String json = JacksonParser.INSTANCE.toJson(stories);
              TextFile.write(filePath, json);
              break;
          }

        }
    }


    @Override
    public boolean exist(Story newStory) {
        for (Story story : getStories()) {
            if (story.equals(newStory))
                return true;
        }
        return false;
    }

}