package com.capstone.ready2walk.Database;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\b\u0010\u0006\u001a\u00020\u0003H\'J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\bH\'\u00a8\u0006\n"}, d2 = {"Lcom/capstone/ready2walk/Database/SessionDao;", "", "addSession", "", "sessions", "Lcom/capstone/ready2walk/Database/Sessions;", "deleteAll", "getAllSessions", "Landroidx/lifecycle/LiveData;", "", "app_debug"})
public abstract interface SessionDao {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * from sessions_table")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.capstone.ready2walk.Database.Sessions>> getAllSessions();
    
    @androidx.room.Insert()
    public abstract void addSession(@org.jetbrains.annotations.NotNull()
    com.capstone.ready2walk.Database.Sessions sessions);
    
    @androidx.room.Query(value = "DELETE FROM sessions_table")
    public abstract void deleteAll();
}