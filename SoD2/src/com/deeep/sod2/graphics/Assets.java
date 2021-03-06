package com.deeep.sod2.graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.deeep.sod2.io.Save;
import com.deeep.sod2.utility.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: Elmar
 * Date: 9/29/13
 * Time: 10:17 AM
 * To change this template use File | Settings | File Templates.
 */
public class Assets {
    /** instance for singleton */
    private static Assets assets;
    /** Just a check to be sure that the assets aren't loaded multiple times */
    private static boolean loaded = false;
    /** The atlases containing all the images */
    private TextureAtlas textureAtlas;
    /** Logger instance */
    private Logger logger = Logger.getInstance();
    /** The texture region for the shape renderer */
    private Sprite blankSprite;
    /** Standard font */
    private BitmapFont font;
    /** Skin */
    private FileHandle skinHandle;
    private Pixmap pixmap;

    /** Find a use for this, if there is any TODO */
    public Assets() {
    }

    /**
     * Simple singleton
     *
     * @return assets instance
     */
    public static Assets getAssets() {
        if (assets == null) {
            assets = new Assets();
        }
        return assets;
    }

    public TextureAtlas getTextureAtlas() {
        return textureAtlas;
    }

    public FileHandle getSkin() {
        return skinHandle;
    }

    /** function to load everything. Nothing special. TODO add more resources here( sound music etc) */
    public void load() {
        if (!loaded) {
            pixmap = new Pixmap(64, 64, Pixmap.Format.RGBA8888);
            pixmap.setColor(Color.WHITE);
            pixmap.fillRectangle(0, 0, 64, 64);
            blankSprite = new Sprite(new Texture(pixmap));
            font = loadBitmapFont();

            textureAtlas = new TextureAtlas(Gdx.files.internal("images/TextureAtlas.txt"));
            skinHandle = Gdx.files.internal("skin.json");

            logger.system(Assets.class, "All assets have been loaded");
            loaded = true;
        }
    }

    public Sprite getBlankSprite() {
        return blankSprite;
    }

    /** Dispose function. should ALWAYS be called. This will get rid of the texture atlas */
    public void dispose() {
        if (pixmap != null)
            pixmap.dispose();
        if (textureAtlas != null)
            textureAtlas.dispose();
        logger.system(Assets.class, "All assets have been disposed");
    }

    /**
     * Returns an texture region based on the name given. Get images using this function!
     *
     * @param name see TextureAtlas.txt
     * @return the texture region connected to the name
     */
    public TextureRegion getRegion(String name) {

        TextureRegion textureRegion = textureAtlas.findRegion(name);
        if (textureRegion == null) {
            logger.error(Assets.class, "Unkown texture requested: " + name);
        }
        return textureAtlas.findRegion(name);
    }

    /**
     * Returns a planet texture
     *
     * @param planetId id of desired planet
     * @return the planet texture connected to the id
     */
    public TextureRegion getPlanetTexture(int planetId) {
        return textureAtlas.findRegion("planets/planet" + planetId);
    }

    /**
     * Loads the bitmap font as BitmapFont object
     *
     * @return null or the font
     */
    public BitmapFont loadBitmapFont() {
        Texture texture = null;
        texture = new Texture(Gdx.files.internal("font/font.png"));

        BitmapFont font = new BitmapFont(Gdx.files.internal("font/font.fnt"), new TextureRegion(texture), false);
        if (font != null) return font;
        Logger.getInstance().error(this.getClass(), "Couldn't find specified font!");
        return null;
    }

    /**
     * Returns the bitmap font as BitmapFont object
     *
     * @return null or the font
     */
    public BitmapFont getBitmapFont() {
        return font;
    }
}
