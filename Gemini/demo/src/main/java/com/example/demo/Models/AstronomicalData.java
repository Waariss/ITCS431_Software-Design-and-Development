package com.example.demo.Models;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AstronomicalData {
    private final List<BufferedImage> images;
    private static final int UPPER_BOUND = 6;
    private static final int ADDITION = 4;
    public AstronomicalData() {
        images = new ArrayList<>();
    }
    public AstronomicalData(List<BufferedImage> images) {
        this.images = images;
    }
    public AstronomicalData getAstronomicalData() {
        return this;
    }
    public List<BufferedImage> getAllImages() {
        return images;
    }
    public List<String> getAstronomicalDataLinks() {
        // Replace with actual image URLs
        List<String> imageUrls = new ArrayList<>();
        imageUrls.add("https://example.com/image1.jpg");
        imageUrls.add("https://example.com/image2.jpg");
        return imageUrls;
    }
    public void retrieveAllImages() {
        List<String> imageUrls = getAstronomicalDataLinks();
        for (String url : imageUrls) {
            try {
                BufferedImage img = downloadImage(url);
                if (img != null) {
                    images.add(img);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private List<String> getAllImageLinks() {
        // Retrieve the list of image URLs
        return getAstronomicalDataLinks();
    }
    private BufferedImage downloadImage(String loc) throws IOException {
        // Download the image from the given URL
        URL url = new URL(loc);
        return ImageIO.read(url);
    }
    private int ranNum(int UpperBound) {
        Random random = new Random();
        return random.nextInt(UpperBound);
    }
    private List<String> getListOfImages(String imageListFileLoc) {
        // Read image URLs from a file and return them as a list
        // This implementation is just an example, you should read the actual URLs from a file
        List<String> imageUrls = new ArrayList<>();
        imageUrls.add("https://example.com/image1.jpg");
        imageUrls.add("https://example.com/image2.jpg");
        return imageUrls;
    }
}
