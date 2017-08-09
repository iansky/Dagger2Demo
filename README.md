# Dagger 2 Demo for Toronto Android Group Lighting Talk
## How to Dependency Inject a Kitten: An Intro to Dagger 2
### Presented August 15, 2017

This is a small little app designed to show how Dagger 2 dependency 
injection is done. The app asks the user for an answer and displays 
it in a second activity. The answer is saved using a shared preference 
provided by Dagger 2.

### Import things to note in this example.

Dagger 2 dependencies added in build.gradle
```
compile 'com.google.dagger:dagger:2.9'
annotationProcessor 'com.google.dagger:dagger-compiler:2.9'
provided 'javax.annotation:jsr250-api:1.0'
```

**AppModule.java** provides all dependencies needed by all the activities. The 
dependenices are defined by the Objects they return. The class is annotated 
with *@Module*

**DemoComponent.java** is an interface that links the module dependencies to 
the activities

**DemoApplication.java** extends the android.app.Application and creates
the **DemoComponent** the activities will use. The Demo2Component object
and Demo2Component.Builder were created by the annotation processor. **After 
creating the modules and components always rebuild the project so the 
annotation processor can create the needed classes and dependency 
injections.**
```
component = DaggerDemoComponent.builder()
                    .appModule(new AppModule(this))
                    .build();
```

**GreetingActivity.java** declares the depency with the *@Inject* 
annotation
```
/**
* The SharedPReferences injected by Dagger 2
*/
@Inject
SharedPreferences preferences;
```
and then calls the appropriate inject method in **DemoComponent.java**
in the onCreate method
```
/**
 * The Dagger 2 injection happens here
 */
((DemoApplication) getApplication()).component.inject(this);
```

