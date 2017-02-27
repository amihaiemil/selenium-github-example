# selenium-github-example

This repo holds the code from [this](http://www.amihaiemil.com/2017/01/24/selenium-and-junit-the-right-way.html) blog post

+ Fork and clone the repo
+ Run the command ``mvn clean install -DskipTests`` so the project  is built and dependencies are fetched.
+ Open the project in Eclipse so you can play with and run the tests

Note that the framework is using ``FirefoxDriver`` you're going to have to set the ``webdriver.gecko.driver`` to point to the [geckodriver](https://github.com/mozilla/geckodriver/releases) executable. If you're on Linux x64 just modify the tests accordingly (the executable is inside the repo); otherwise, you will also have to download the apropriate executable for your OS.