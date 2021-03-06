package com.deeep.sod2.tiles;

/*
 * Class : RegularTile
 * Package : com.deeep.sod2.tiles
 * Author : Andreas
 * Date : 05-10-13
 */

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.deeep.sod2.graphics.Assets;
import com.deeep.sod2.entities.Entity;
import com.deeep.sod2.graphics.ShapeRenderer;
import com.deeep.sod2.utility.Camera;

public class RegularTile extends AbstractTile {

    public RegularTile(int x, int y) {
        setColor(new Color(0.1f, 0.4f, 0.5f, 0.2f));
        setX(x);
        setY(y);
        textureRegion = Assets.getAssets().getRegion("Tiles/glass");
    }

    @Override
    public void implementDraw(SpriteBatch spriteBatch) {
        spriteBatch.draw(textureRegion, x, y, 1, 1, 1, 1, 1, 1, 0);
        ShapeRenderer.setColor(color);
        ShapeRenderer.drawRectangle(spriteBatch, x, y, 1, 1, true);
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void onStep(Entity stepper) {
    }
}
