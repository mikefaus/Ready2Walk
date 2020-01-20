package com.capstone.ready2walk.Database;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class SessionDao_Impl implements SessionDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Sessions> __insertionAdapterOfSessions;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

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
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM sessions_table";
        return _query;
      }
    };
  }

  @Override
  public void addSession(final Sessions sessions) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfSessions.insert(sessions);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAll.release(_stmt);
    }
  }

  @Override
  public LiveData<List<Sessions>> getAllSessions() {
    final String _sql = "SELECT * from sessions_table";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"sessions_table"}, false, new Callable<List<Sessions>>() {
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
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }
}
