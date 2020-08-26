package project.pages.homepage.impl;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

/*
A concrete implementation of HomePage in landscape mode.
 */
public class HomePageLandscape extends HomePagePortrait {

    public HomePageLandscape(AndroidDriver<MobileElement> driver) {
        super(driver);
    }
}
