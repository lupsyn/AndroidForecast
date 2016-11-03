# AndroidForecast

Fetch OpenWeather.com api forecast data (5 days) for a specific place, 
or a "pinpointed" one, and display with a simple UI, a good code base for starting a weather app.

It's divided in 4 layers: app, business, location, and data.

App is the ui and the real android app, with all UI staff.

Location is an android library in which is implemented the location controller 
(using a gps data from google location controller and from the plain one). 

Data is also an android library where the real data (in this case OpenWeather data) is coming from,
but as the others, you can use data if you want.

In these layers two (data+location) i use a combination of popular libraries : Retrofit+rxJava for 
retrive data for example. I suggest to use Dagger for dependecy injection (TBD).

Business layer is the logic one,the most important and it's plain java, you can test it
without thinking to android. For absurd, you can take the same code, put 
in another os, and it should work.


![Preview](https://s15.postimg.org/5a84jmue3/device_2016_11_03_010901.png)
