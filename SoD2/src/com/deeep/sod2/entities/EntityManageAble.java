package com.deeep.sod2.entities;

import com.deeep.sod2.entities.Entity;

/**
 * Created with IntelliJ IDEA.
 * User: Elmar
 * Date: 10/28/13
 * Time: 3:09 PM
 * To change this template use File | Settings | File Templates.
 */
public interface EntityManageAble {
    public int addEntity(Entity entity);

    public void addEntity(int id, Entity entity);

    public boolean removeEntity(int id);

    public boolean removeEntity(Entity entity);
}
