package com.example.savedatasqlite;

import android.os.AsyncTask;

import com.example.savedatasqlite.DaoClass.UserDao;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;

/**
 *
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class MainActivityUnitTest {
    private MainActivity mainActivity;

    /**
     * Check if the input field is empty
     * @Expected: String message "Input field is empty"
     */
    @Test
    public void testValidateInputFieldIsEmpty() {
        mainActivity = new MainActivity();
        Assert.assertEquals("Input field is empty", mainActivity.validateInputField(""));
    }

    /**
     * Check if the input field is valid
     * @Expected: null
     */
    @Test
    public void testValidateInputFieldIsValid() {
        mainActivity = new MainActivity();
        Assert.assertNull(mainActivity.validateInputField("John Doe"));
    }
}