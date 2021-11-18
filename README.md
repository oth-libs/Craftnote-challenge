# Craftnote coding challenge

## Intro

This project is written 100% in Kotlin and following MVVM Clean Architecture principles, with Flow/LiveData/Coroutines/DataBinding, the project is thus written in a very clean and modular way, and is easily scalable as the project grows. 

It also includes Unit Test inside each module grouped inside a test suite.


## Build and run

Simply clone the project, import into Android Studio and run.

## Notes on Exercice 1: 

To have the layout fit all screens while keeping the image in full width, I wrapped the layout inside a scroll view and made the design decision to have the login form be in the middle of the remaining space, using a couple < Space/> views on top and bottom, and a weight of 1, while keeping in mind some necessary padding in between. 

## Notes on Exercice 2:

I reworked the project architecture and changed it into Clean Architecture, the app is separated into 4 modules (detail below).

Please note that this architecture is only applicable to the "task" feature, "login" remained untouched so the viewmodel and repository stayed inside the "app" module.

## Modules

It contains 4 modules in total: 

* **app**: Contains the views fragment/activity and the adapters, view helper classes, extensions and data binding adapters.
* **presentation**: Contains the ViewModel declaration 
* **domain**: Contains the Repository interface and UseCases 
* **data**: Contains the Repository implementation, the retrofit api calls.


## Testing

Each module contains a set of tests grouped in a test suite. 


## Libraries

* Coroutines
* Koin
* Jetpack (Navigation, Data Binding, Lifecycle, LiveData, ViewModel)
* Kotlinx Serialization
* Jakewharton retrofit2-kotlinx-serialization-converter
* Retrofit
* JUnit
* Mockk

## Code

### Data Source helpers 

**SourceResultHolder**

A generic class that holds a value with its loading status.


**DataSourceFlow**

**```resultFlow(networkCall)```** will call the api using ```networkCall``` function.


**RemoteDataSource**

**```getRemoteResult```** will execute the ```call``` function, generally coming from a retrofit service, and map it using the ```map``` function. This method automatically checks on network state and handles errors, and returns the right ```SourceResultHolder``` wrapper.

All of these files can be put together with Retrofit services and have a seamless Repository implementation for use cases.



