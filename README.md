# Game Timer

his is an Android application that allows users to manage two countdown timers (upper and lower) for any game or activity where two timers are required. The app includes functionality to increment the timer by a set amount of time when interacted with and automatically switches between the two timers when needed. Additionally, users can configure the starting time and increment values for each timer through a custom setup screen.

The app is useful for games or activities where two players alternate turns and you want to add a time limit element for fun or to handicap one of the players to even the odds.

## Features
Two timers: An upper timer and a lower timer that count down simultaneously or alternately.
Time Increment: You can increment the time of the current active timer by a configurable amount of seconds.
Automatic Switching: When one timer is paused, the other starts automatically from the remaining time.
Interactive Timer: Touch areas assigned to each timer allow you to pause and increment time based on the current active timer.
Custom Timer Setup: Configure the starting time and increment values for each timer through a custom setup screen.

## Usage
Custom Timer Setup:

When the app is launched, the user is prompted to enter the time and increment values for both timers (upper and lower).

The CustomTimerSetUp screen lets the user input values for:
Player One Time (in minutes)
Player Two Time (in minutes)
Player One Increment (in seconds)
Player Two Increment (in seconds)

Timer Interaction:
After the setup, you are directed to the TimerActivity where you can interact with the two timers.
Each timer can be paused and incremented by the respective increment value.

Timer Management:
Upper Timer: Tapping on the upper touch area pauses the upper timer and increments it by the set value (in seconds). Once paused, the lower timer starts.
Lower Timer: Tapping on the lower touch area pauses the lower timer and increments it by the set value (in seconds). Once paused, the upper timer starts.

Timer Finish:
When the upper timer finishes, the message "Timeout" is displayed on the upper timer and "You win" is displayed on the lower timer.
Similarly, when the lower timer finishes, the message "Timeout" is displayed on the lower timer and "You win" is displayed on the upper timer.

Time Limits and Increments:
The CustomTimerSetUp class allows you to set custom time limits and increments before entering the timer activity. These values are passed as extras to TimerActivity.

## Installation Instructions
Follow these steps to install GameTimer on your Android device:

Download the APK: 
Click the following link to download the GameTimer APK: https://drive.google.com/file/d/14WNbhVs01CpFqqn5Gs66zIHlPa7tYoGu/view?usp=drive_link

Allow Installation from Unknown Sources: 
Go to your Settings app. Navigate to Security (or Apps & notifications > Install unknown apps). 
Enable the option to install from the file manager or browser app where you will open the APK.

Install the APK: 
Once the APK file has been downloaded, open the file from your Downloads or the location where you saved it. 
Tap Install to start the installation process. 

