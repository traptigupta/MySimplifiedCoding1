package com.example.autotest.simplifiedcoding;

import android.app.Activity;
import android.app.Instrumentation;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;
import android.view.View;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasErrorText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule=new ActivityTestRule<MainActivity>(MainActivity.class);
    private MainActivity mActivity=null;
    public Instrumentation instr= InstrumentationRegistry.getInstrumentation();

     Instrumentation.ActivityMonitor monitor= instr.addMonitor(ProfileActivity.class.getName(),null,false);
    @Before
    public void setUp() throws Exception {
        mActivity=mActivityTestRule.getActivity();
    }
    @Test
    public void testLaunch() {
        //String name="admin";
        //String password="12341";
        //Espresso.onView(withId(R.id.textViewLogin)).perform(click());
//        Activity secondActivity= instr.waitForMonitorWithTimeout(monitor,5000);
  //      assertNotNull(secondActivity);
        /*Espresso.onView(withId(R.id.editTextUsername)).perform(typeText(name));
        Espresso.onView(withId(R.id.editTextPassword)).perform(typeText(password));
        Espresso.closeSoftKeyboard();
        Espresso.onView(withId(R.id.buttonLogin)).perform(click());
        Espresso.onView(withId(R.id.textViewUsername)).check(matches(withText(name)));
        Espresso.onView(withId(R.id.buttonLogout)).perform(click());*/

        Espresso.onView(withId(R.id.buttonRegister)).perform(click());
        Espresso.onView(withId(R.id.editTextUsername)).check(matches(hasErrorText("Please enter username")));
        Espresso.onView(withId(R.id.editTextUsername)).perform(typeText("test"));
        Espresso.closeSoftKeyboard();
        Espresso.onView(withId(R.id.buttonRegister)).perform(click());
        Espresso.onView(withId(R.id.editTextEmail)).check(matches(hasErrorText("Please enter your email")));
        Espresso.onView(withId(R.id.editTextEmail)).perform(typeText("test"));
        Espresso.closeSoftKeyboard();
        Espresso.closeSoftKeyboard();
        Espresso.onView(withId(R.id.buttonRegister)).perform(click());
        Espresso.onView(withId(R.id.editTextEmail)).check(matches(hasErrorText("Enter a valid email")));
        Espresso.onView(withId(R.id.editTextEmail)).perform(typeText("@gmail.com"));
        Espresso.closeSoftKeyboard();
        Espresso.onView(withId(R.id.buttonRegister)).perform(click());
        Espresso.onView(withId(R.id.editTextPassword1)).check(matches(hasErrorText("Enter a password")));
        Espresso.onView(withId(R.id.editTextPassword1)).perform(typeText("12341"));
        Espresso.closeSoftKeyboard();
        Espresso.onView(withId(R.id.buttonRegister)).perform(click());
        Activity secondActivity= instr.waitForMonitorWithTimeout(monitor,5000);
          assertNotNull(secondActivity);



    }
    @After
    public void tearDown() throws Exception {
        mActivity=null;
    }
}