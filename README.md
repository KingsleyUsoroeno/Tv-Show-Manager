# Tv-Show-Manager
TV show manager helps movie fanatics to keep track of movies and series they have watched over time.


## Architecture
The architecture of this application relies on and complies with the following points below:
* A single-activity architecture, using the [Navigation Components](https://developer.android.com/guide/navigation) to manage fragment operations.
* Pattern [Model-View-ViewModel](https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93viewmodel)(MVVM) which facilitates separation of concerns and ensuring single responsibility between the different layers of the application
* [Android architecture components](https://developer.android.com/topic/libraries/architecture/) which help to keep the application robust, testable, and maintainable


## Libraries Used
* [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) to store and manage UI-related data in a lifecycle conscious way.
* [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) observable data holder that is lifecycle-aware.
* [Navigation Component](https://developer.android.com/guide/navigation) handle fragment navigations and passing of data between destinations.
* [Material Design](https://material.io/develop/android/docs/getting-started/)
* [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) `Managing threads efficiently and reducing the need for callbacks`. 
* [Room](https://developer.android.com/topic/libraries/architecture/room) abstraction layer over SQLite which allows for more robust database access while harnessing the full power of SQLite.
* [Android KTX](https://developer.android.com/kotlin/ktx) which helps to write more concise, idiomatic Kotlin code.

