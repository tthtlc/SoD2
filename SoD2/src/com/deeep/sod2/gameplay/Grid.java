package com.deeep.sod2.gameplay;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.deeep.sod2.graphics.ShapeRenderer;

/**
 * Created with IntelliJ IDEA.
 * User: Elmar
 * Date: 9/30/13
 * Time: 7:42 PM
 */
public class Grid {
    private float size = 0;
    private int width = 0;
    private int height = 0;
    private Color color;

    public Grid(float size, int width, int height, Color color) {
        this.size = size;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public void draw(SpriteBatch spriteBatch) {
        ShapeRenderer.setColor(color);
        for (int x = 0; x < width + 1; x++) {
            for (int y = 0; y < height + 1; y++) {
                ShapeRenderer.drawLine(spriteBatch, x, 0, x, y, 0.025f);
                ShapeRenderer.drawLine(spriteBatch, 0, y, x, y, 0.025f);
            }
        }
        ShapeRenderer.setColor(new Color(0.1f, 0.4f, 0.5f, 0.3f));
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                ShapeRenderer.drawRectangle(spriteBatch, x, y, 1f, 1f, true);
            }
        }
    }
}
