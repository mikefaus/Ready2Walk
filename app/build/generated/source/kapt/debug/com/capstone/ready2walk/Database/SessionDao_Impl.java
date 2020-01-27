package com.capstone.ready2walk.Database;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class SessionDao_Impl implements SessionDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Sessions> __insertionAdapterOfSessions;

  private final EntityDeletionOrUpdateAdapter<Sessions> __deletionAdapterOfSessions;

  private final EntityDeletionOrUpdateAdapter<Sessions> __updateAdapterOfSessions;

  public SessionDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfSessions = new EntityInsertionAdapter<Sessions>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `sessions_table` (`id`,`sessionDate`) VALUES (nullif(?, 0),?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Sessions value) {
        stmt.bindLong(1, value.getId());
        if (value.getSessionDate() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getSessionDate());
        }
      }
    };
    this.__deletionAdapterOfSessions = new EntityDeletionOrUpdateAdapter<Sessions>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `sessions_table` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Sessions value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfSessions = new EntityDeletionOrUpdateAdapter<Sessions>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `sessions_table` SET `id` = ?,`sessionDate` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Sessions value) {
        stmt.bindLong(1, value.getId());
        if (value.getSessionDate() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getSessionDate());
        }
        stmt.bindLong(3, value.getId());
      }
    };
  }

  @Override
  public Object addSession(final Sessions sessions, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfSessions.insert(sessions);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object deleteSession(final Sessions sessions, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfSessions.handle(sessions);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object updateSession(final Sessions sessions, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfSessions.handle(sessions);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object getAllSessions(final Continuation<? super List<Sessions>> p0) {
    final String _sql = "SELECT * from sessions_table ORDER By id DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.execute(__db, false, new Callable<List<Sessions>>() {
      @Override
      public List<Sessions> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfSessionDate = CursorUtil.getColumnIndexOrThrow(_cursor, "sessionDate");
          final List<Sessions> _result = new ArrayList<Sessions>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Sessions _item;
            final String _tmpSessionDate;
            _tmpSessionDate = _cursor.getString(_cursorIndexOfSessionDate);
            _item = new Sessions(_tmpSessionDate);
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _item.setId(_tmpId);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, p0);
  }
}
