# MobileSiteWalmartHW

Test Problem

Automate an end-to-end user e-commerce transaction flow using any open source tool for mobile.walmart.com<http://mobile.walmart.com> with an existing customer on chrome or safari browser.

Scenario to automate

1. Perform a search on home page from a pool of key words given below
2. Identify an item from the result set that you can add to cart
3. Add the item to cart and then login using existing account, which is set up with at least one shipping address
4. Validate that item added is present in the cart and is the only item in the cart

Tools and Technologies used

Appium, Eclipse IDE, Android SDK, Junit 4, Java 1.8, Xpath, CSS, Chrome browser


Automation framework setup:

•	Download and install Eclipse IDE, java jdk, Android SDK, install node.js,
•	Download Appium and install librariesusing npm 
•	Download and add junit 4, Selenium Standalone Server, Selenium Client & WebDriver for java and java client jar files to the build path

Execution Steps:

Import the WalmartMobileSiteHomework project into Eclipse and also make sure to import all the related jar file.

Run the SearchAndAddToCart.java as Junit test 

Reasoning behind technical choices:

Appium:
1.	Support for both platforms iOS and android.
2.	Support for continuous integration
3.	Doesn't require access to your source code. You are testing with which you will actually ship.
4.	Supports most of the programming languages like java, ruby
5.	Supports automation of hybris, native and webapps
6.	cross-platform

Junit:
1.	JUnit has become a standard for testing in Java programming language and is supported by almost all IDE’s e.g Netbeans, Eclipse etc.
2.	 You can also integrate Ant with JUnit to allow executing test suites (all unit test cases) as part of the build process, capturing their output, and generating rich color enhanced reports. 

Improvements:

•	We can store the constants and also build a resource layer which contains all the ids of the UI elements in common package.
•	Using ids over xpath is better, as the code can be reused across different browsers and devices such as android and ios. Ids remain constant even if the layout of the website is change whereas the xpath will be completely different.
•	We can group the tests based on the test cases and suites.



