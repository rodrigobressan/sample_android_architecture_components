Sample Architecture Components
----------
[![Build Status](https://travis-ci.org/bresan/sample_android_architecture_components.svg?branch=master)](https://travis-ci.org/bresan/android_tmdb_clean_architecture)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/6e921f05223141b1985cfdf1671c3d32)](https://www.codacy.com/app/bresan/android_tmdb_clean_architecture?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=bresan/android_tmdb_clean_architecture&amp;utm_campaign=Badge_Grade)


#### What is this?

Just a simple application showcasing the usage of Android Architecture Components. It does not make any usage of Dependency Injection (such as Dagger), since the purpose of it is to keep it simple :-)

### Project contents

- **ViewModel**, in order to show the basic behavior of keeping the state of the screen after configuration changes
- **AndroidViewModel**, same as ViewModel, but using the application context
- **LiveData**, in order to show how we can use the Observable pattern in order to check for new changes
- **Lifecycle**, being able to track the lifecycle of our Activity/Fragment
- **Transformation**, in order to perform any change (map/switchMap) in our data before returning it

### Requirements

Android Studio

JDK 1.8

Android SDK

#### License

All code licensed under the [MIT License](http://www.opensource.org/licenses/mit-license.php). You are free to do whatever you want with this piece of code. Check it out the LICENSE.md file for more info.