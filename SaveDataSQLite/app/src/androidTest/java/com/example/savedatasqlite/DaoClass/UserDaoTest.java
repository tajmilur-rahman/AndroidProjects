package com.example.savedatasqlite.DaoClass;


import androidx.lifecycle.LiveData;
import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.SmallTest;

import com.example.savedatasqlite.AbstractDatabase;
import com.example.savedatasqlite.EntityClass.User;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">This class will test User DAO</a>
 */
@RunWith(AndroidJUnit4.class)
@SmallTest
public class UserDaoTest {

    private AbstractDatabase database;
    private UserDao userDao;

    @Before
    public void setup() {
        database = Room.inMemoryDatabaseBuilder(
                ApplicationProvider.getApplicationContext(),
                AbstractDatabase.class
        ).build();
        userDao = database.getUserDao();
    }

    @After
    public void teardown() {
        database.close();
    }

    @Test
    public void insertUserSuccessfully() {
        User user = new User();
        user.setName("Any Name");
        userDao.insert(user);

        LiveData<List<User>> allUsers = userDao.getAll();
        assertNotNull(allUsers.getValue());
        assertEquals(allUsers.getValue().size(), 1);
        User actualUser = (User) allUsers.getValue().get(0);
        assertEquals(actualUser.getName(), "Any Name");
    }
}