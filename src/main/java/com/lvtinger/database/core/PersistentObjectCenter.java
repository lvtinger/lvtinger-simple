package com.lvtinger.database.core;

import com.lvtinger.value.PersistentObject;

import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

public class PersistentObjectCenter {
    private Set<Class<? extends PersistentObject>> holder = new ConcurrentSkipListSet<>();
    public void register(Class<? extends PersistentObject> clazz){
        holder.add(clazz);
    }




}
