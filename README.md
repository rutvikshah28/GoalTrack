# 

<p align = "center"><a href = ""https://github.com/rutvikshah28/GoalTrack"><img src="./img/logo%20round.png" width = "200" height = "200" alt = "GoalTrack" /></a></p> <br />
<h2 align = "center"> <strong>GoalTrack</strong> </h2> <br />

<details open="open">
  <summary><h2 style="display: inline-block">Table of Contents</h2></summary>
  <ol>
    <li>
      <a href="#About">About GoalTrack</a>
      <ul>
        <li><a href="#FeatureList">Feature List</a></li>
        <li><a href="#Built">Built With</a></li>
      </ul>
    </li>
    <li>
    <a href = "#Developers"> For the Developers </a>
        <ul>
            <li><a href="#dPre">Prerequisites</a></li>
            <li><a href="#dIns">Installation</a></li>
         </ul>
    <a href="#Manifest">Manifest Information</a>
        <ul>
            <li><a href="#MainActivity">MainActivity.kt</a></li>
            <li><a href="#ftFragment">FirstTimeSetup.kt</a></li>
            <li><a href="#homeFragment">HomePage.kt</a></li>
            <li><a href="#addGoalFragment">AddGoal.kt</a></li>
            <li><a href="#updateGoalFragment">UpdateGoalFragment.kt</a></li>
            <li><a href="#rvListAdapter">RVListAdapter.kt</a></li>
            <li><a href="#GoalData">GoalData.kt</a></li>
            <li><a href="#UserData">UserData.kt</a></li>
            <li><a href="#UserRepository">UserRepository.kt</a></li>
            <li><a href="#UserViewModel">UserViewModel.kt</a></li>
            <li><a href="#UserDatabase">UserDatabase.kt</a></li>
            <li><a href="#UserDao">UserDao.kt</a></li>
            <li><a href="#stringsXML">strings.xml</a></li>
            <li><a href="#gtNavXML">goaltrack_nav.xml</a></li>
            <li><a href="#activityMainXML">activity_main.xml</a></li>
            <li><a href="#fragmentAddGoalXML">fragment_add_goal.xml</a></li>
            <li><a href="#fragmentFtSetupXML">fragment_first_time_setup.xml</a></li>
            <li><a href="#fragmentHomePageXML">fragment_home_page.xml</a></li>
            <li><a href="#fragmentUpdateGoalXML">fragment_update_goal.xml</a></li>
            <li><a href="#goalRowXML">goal_row.xml</a></li>
        </ul>
    </li>
    <li> <a href = "#Users"> For the Users </a>
      <ul>
        <li><a href="#uPre">Prerequisites</a></li>
        <li><a href="#uIns">Installation</a></li>
      </ul>
    </li>
    </ul>
    </li>
    <li><a href="#Op">Operating Instructions</a></li>
    <li><a href="#BugList">Bug List</a></li>
    <li><a href="#Troubleshooting">Troubleshooting</a></li>
    <li><a href="#License">License</a></li>
    <li><a href="#Contact">Contact</a></li>
    <li><a href="#Ack">Acknowledgements</a></li>
  </ol>
</details>

<h2 id = "About" />

## __About GoalTrack__
___
GoalTrack is an _android_ application meant to keep track of personal tasks and goals. The idea for GoalTrack generated from my personal desire to keep track of things. I am very bad at managing my tasks and keeping a track on them. There are numerous applications out there to do this for me but since I am taking a course for Mobile Computing and development in Android, I wanted to create this application so I can use it on a day-to-day basis. This provides me with the comfort of customizing the application in the future and make it an even greater experience. I hope to be able to learn and improvise this so I can share it with people all around to give them one more option of countless similar applications to choose from. As of this moment, GoalTrack is Android only but I hope to develop for iOS in the near future. 


___

<h3 id="FeatureList" />

### __Feature List__
1. __Profile Creation__ : Goal Track, during its first time setup allows the user to create their profile. Simple information like Name, Age, Birth Date, Gender is asked. This allows GoalTrack to expand future opportunities by adding Machine Learning capabilites to customize the application around the user.
2. __Randomized Motivational Quotes__ : GoalTrack currently has a set of 20 random motivational quotes that is displayed to the user on the home screen of GoalTrack. It changes every time the user opens/travels to the home page.
3. __Adding New Goals__ : GoalTrack allows the user to create new goals and asks for information like Title, Description and the Date when the goal is to be completed. GoalTrack stores this information in a local device database only.
4. __Viewing/Updating existing goals__ : GoalTrack allows users to click on a goal from the home page and provides the ability to view it or make changes to the goal.
5. __Deleting existing goals__ : GoalTrack also provides users the ability to delete a goal in addition to updating/viewing it. The user must click on a goal and then press the delete button to do so.
   
___
<h3 id="Built" />

### __Built With__

#### __Integrated Development Environment (IDE)__
Android Studio was chosen as the IDE for GoalTrack since it provides great features while developing like intelligent autocomplete functionalities. It takes care of initial file setup. The Logcat and gradle functionalies are a great plus to debug and explore how the application works and responds.

#### __Programming Language__
Kotlin was used as the main language for programming due to its modernness and easy usage. It also provides null safety and other important features. The other option was using java, but kotlin was easily the best choice for this.

>*Learn further about [Android Studio](https://developer.android.com/studio, "Android Studio") and [Kotlin.](https://kotlinlang.org/, "Kotlin")*
___

<h2 id="Developers" />

## __For the Developers__
This section provides the configuration, installation and operating details for GoalTrack project for the developers who are interested in it.

<h3 id="dPre" />

### __Prerequisites__
* An IDE of your choice is needed to analyze and test the project. *[Android Studio](https://developer.android.com/studio, "Android Studio Download")* is highly recommended but other options include *[Visual Studio Code](https://code.visualstudio.com/, "Visual Studio Code Download")* if that is more familiar. Although Visual Studio Code won't be a proper IDE, it is light weight and handy. If you feel comfortable with other tools, those can be used as well.

* Knowledge about Kotlin is a must. You can learn about Kotlin from its *[documentation.](https://kotlinlang.org/docs/home.html, "Kotlin Documentation")*
<h3 id="dIns" />

* Knowledge about *[Java](https://docs.oracle.com/javase/7/docs/api/, "Java Documentation")* is always a plus since the underlying mechanisms of android work with java.

* Knowledge about *[XML](https://www.w3.org/XML/, "XML Documentation")* is also required since Android deals with xml files a lot.
* Conceptual knowledge about MVC architecture, Object-Oriented Programming and other android development fundamentals is a plus.
* Knowledge about Github and Git is strongly recommended. There are numerous videos on youtube to explain the basics, a personal suggestion is *[this](https://youtu.be/SWYqp7iY_Tc, "Git and Github Crash Course")* one.
* Android SDK minimum version of 26 is required. An android device to run the application on is a plus with Android version 8.0 or higher.

### __Installation Instructions__

Once the prerequisites are fulfilled, you can install the project and run it in your IDE. I prefer Android Studio and will refer to it as the default IDE for this project.

To get started, follow the instructions below:
1. Use github to clone this repository to your local repository. 
   * If you are familiar with Command Line Interface (CLI): Navigate to the folder you want to install this project in and type in the following command
    ```bash
    git clone https://github.com/rutvikshah28/GoalTrack.git
    ```
    * Another option is to directly download the project as a zip using github
  2. Once you have the repository cloned to your local storage, you can open the *.git* folder to find the files associated with the project. Open this up in Android Studio to get started.
  3. Once Android Stuido loads this project, you can explore and play around with it as you like.
  4. When you are ready to test this, you can build and run the project on a physical device or on a virtual one which is built inside Android Studio. 
  5. Once you are perfectly happy, you can navigate to the build menu and click on building the apk or a bundle if need be. You can then navigate to the folder where it will be generated and directly install the apk to your android device to install the application inside it.
  6. After that, simply enjoy your personal goal tracker.

<!-- Dont forget to add images above, maybe gifs? -->
___
<h2 id="Manifest" />

## __Manifest Information__
This section provides the list of files that are used in this project. It contains all kotlin and xml fragments file list. Along with each list item here, a short description will be provided of what it does. This will hopefully explain the architecture of GoalTrack and make it clear how OOP concepts are followed with the use of the Model-View-Controller architecture that is implemented. If you want to see the whole file, you can view them by navigating to the following directory in your cloned repository.
* The follwoing path leads you to all kotlin files.
```
    GoalTrack\app\src\main\java\com\example\goaltrack
    or 
    GoalTrack\app\src\main\java\com\example\goaltrack\database
    or
    GoalTrack\app\src\main\java\com\example\goaltrack\database\model
    or
    GoalTrack\app\src\main\java\com\example\goaltrack\database\repository
    or
    GoalTrack\app\src\main\java\com\example\goaltrack\database\viewmodel
    or
    GoalTrack\app\src\main\java\com\example\goaltrack\fragments
```
* To reach the xml files use this path
```
    GoalTrack\app\src\main\res\layout
    or
    GoalTrack\app\src\main\res\navigation
    or
    GoalTrack\app\src\main\res\values
```
Provided below is the list of all files in our Manifest
___

<h3 id ="MainActivity" />

### __MainActivity.kt__
>The MainActivity.kt file contains GoalTrack's one and only activity. It is responsible to inflate the fragment on the start-up of the application. This links up with the activity_main.xml file which contains its corresponding view.
<h3 id ="ftFragment" />

### __FirstTimeSetup.kt__
> The First time Setup Kotlin file is the default home file in our navigation. It is responsible to check the database for the number of users. If there are no users, it will inflate the fragment_first_time_setup.xml file to ask the user for creating a profile. Once done, it will update the database and navigate to the HomePage.kt.
<h3 id ="homeFragment" />

### __HomePage.kt__
> The HomePage.kt is the main fragment which hosts our RecyclerView for the Goals that the user adds. There is also a floating add button which redirects to the AddGoal.kt. It is also responsible for implementing randomized motivational quotes
<h3 id ="addGoalFragment" />

### __AddGoal.kt__
>The AddGoal.kt file contains code to implement the addition of a user created goal into our local database. It is responsible for inflating the fragment_add_goal.xml and then set up onClickListeners for appropriate clicks. It will then add the data into the database, display a success message and navigate back to HomePage.kt
<h3 id ="updateGoalFragment" />

### __UpdateGoalFragment.kt__
>The UpdateGoalFragment.kt file contains code to implement the functionalies of updating the goal information or deleting the goal from the database. This will make use of our RVListAdapter.kt and the RecyclerView to get the information of the selected goal. The RecyclerView from the HomePage.kt will pass on the information when a goal is clicked. We will then make use of that information to initially fill out the goal details. The user can then cancel, update or delete the goal. We will implement this using appropriate onClickListeners and functions. Once we are done with the task, we display an appropriate message to the user and navigate back to the HomePage.kt

<h3 id ="rvListAdapter" />

### RVListAdapter.kt__
> The RVListAdapter.kt will be responsible to implement the Adapter functionality for our RecyclerView for the goals. It is an additional abstraction layer to follow OOP concepts and implement the updating goal functionality.
<h3 id ="GoalData" />

### __GoalData.kt__
> The GoalData.kt is a data class and is declared as an entity for our room database. We simply declare the fields for the table with their types and add a primary key aswell. This acts as a model in our architecture.
<h3 id ="UserData" />

### __UserData.kt__
> The UserData.kt is a data class and is declared as an entity for our room database. We simply declare the fields for the table with their types and add a primay key aswell. This acts as a model in our architecture.
<h3 id ="UserRepository" />

### __UserRepository.kt__
> The UserRepository.kt is an abstraction layer that has clean, simple and final communication with our database. It will connect with the UserViewModel.kt to cleanly implement database operations with the UserDao.kt
<h3 id ="UserViewModel" />

### __UserViewModel.kt__
> The UserViewModel.kt is another abstraction layer that communicates with our GoalTrack UI and the database repository. It is also responsible to implement the database functions using background threads since database access may be a heavy operation and it is not recommended to do so from the main thread since it may potentially block the application for a long period of time.
<h3 id ="UserDatabase" />

### __UserDatabase.kt__
> The UserDatabase.kt is responsible to create the database for our room database implementation. We also implement a companion object with it that returns the database instance along with the creation of an abstract function for our UserDao interface.
<h3 id ="UserDao" />

### __UserDao.kt__
> The UserDao.kt is an interface implementation of our Data Access Object. It is the main point through which we implement database data as objects for our application.
<h3 id ="stringsXML" />

### __strings.xml__
> The strings.xml file contains the re-used strings for our application. We can use these in our various xml files. It is a good practice to insert strings here instead of hardcoding them in every xml file so that we can change things with ease in future and maintain the ease of maintenance of the application.
<h3 id ="gtNavXML" />

### __goaltrack_nav.xml__
> This is a part of view architecture and implements the relationships between fragments to navigate throughout the application.
<h3 id ="activityMainXML" />

### __activity_main.xml__
> This is a part of view architecture and contains the main activity view for GoalTrack.
<h3 id ="fragmentAddGoalXML" />

### __fragment_add_goal.xml__
>This is a part of view architecture and contains the fragment to add goals for our application.
<h3 id ="fragmentFtSetupXML" />

### __fragment_first_time_setup.xml__
>This is a part of view architecture and contains the fragment to the first time setup for our application.
<h3 id ="fragmentHomePageXML" />

### __fragment_home_page.xml__
> This is a part of view architecture and contains the fragment for the home page for our application.
<h3 id ="fragmentUpdateGoalXML" />

### __fragment_update_goal.xml__
> This is a part of view architecture and contains the fragment for updating a goal in our application.
<h3 id ="goalRowXML" />

### __goal_row.xml__
>This is a part of view architecture for every goal that will be displayed by our RecyclerView. It contains the goal title and the corresponding due date for that goal.

___
<h2 id="Users" />

## __For the Users__
This section provides information about how to install the application on an android device. If you are not a developer and want to try it out, please follow the instructions below. If you are a developer but still want to try the application at its current stage, please follow the instructions below to get started.
___

<h3 id="uPre" />

### __Prerequisites__
* To install GoalTrack, you will need an android smartphone. 
* The device will have to run Android 8.0 or above
* 10 MB of space on the device is recommended for the application to run smoothly.
* On the device, make sure you allow the installation of applications by third party websites so you can download the apk file.

<h3 id="uIns" />

### __Installation Instructions__
To install this application on your device, it is assumed you match the prerequisites mentioned above. The next steps are outlined below:
1. Open this github repository from a browser in the device you want to install GoalTrack into. Alternatively, you can follow this link to download the *[apk.]()
2. Find the file named 'GoalTrack.apk' in this repository
3. Download this apk onto the device and simply follow the instructions on the device to install.
4. Once done, simply find the application on your device, open it up and start enjoying tracking of your tasks and goals.


<h2 id="Op" />

## __Operating Instructions__

Assuming that you have the application installed, we will now glance at how it work.


<h2 id="BugList" /> 

## __Bug List__

<h2 id="Troubleshooting" />

## __Troubleshooting__

<h2 id="License" />

## __License__

<h2 id="Contact" />

## __Contact__

<h2 id="Ack" />

## __Acknowledgements__