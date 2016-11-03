# AndroidForecast
Fetch OpenWeather data, and display with a simple UI, 
a good code base for starting a weather app.
It's divided in 4 layers: app, business, location, and data.

App is the ui and the real android app, location is an android library in which you 
can implement your location controller (using a gps or something else), and data 
is the layer where the real data (in this case Open wheater data) is coming from,
but as the others, you can use another api if you want.
In these layers i use a combination of popular libraries : Retrofit+rxJava for 
retrive data for example. I suggest to use Dagger for dependecy injection (TBD).

Business layer is the logic one, it's plain java, and you can test it
without thinking to android. For absurd, you can take the same code, put 
in another os, and it should work.


![Preview](https://s15.postimg.org/5a84jmue3/device_2016_11_03_010901.png)
