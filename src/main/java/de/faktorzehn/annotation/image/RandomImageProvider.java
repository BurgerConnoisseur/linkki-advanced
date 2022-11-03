package de.faktorzehn.annotation.image;

import java.util.List;
import java.util.Random;

public class RandomImageProvider {

    private final List<String> imgs = List.of(
            "https://www.meme-arsenal.com/memes/1d1bc0a06fca37fadf639dc28967429c.jpg",
            "https://i.redd.it/kz2xangmmsv91.jpg",
            "https://i.pinimg.com/originals/36/c5/30/36c53037160df4acb30b52347e31c698.jpg",
            "https://preview.redd.it/fgalp1orti051.jpg?auto=webp&s=5ce433ad3581204c15d4563062459b3ee582407a"
    );

    private final Random random = new Random();

    public String get() {
        return imgs.get(random.nextInt(imgs.size()));
    }
}
