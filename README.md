# WeatherApp

This is a simple demonstration for creating project using MVP+Repository pattern. 

Used Dagger2 for dependncy injection and retrofit for using rest API.

I focused mainly on Architecture since this is a crtical design decision that hard to change later.

when your components loosely coupled and UI separted from buisness logic it's easy to change and design the UI later.

at this point it may seems like over engineering but as soon as the project starts to grow it pays off very quickly.



for production code
1. use Fragments
2. handle errors and edge cases properly add logs
3. handle orientation change
4. polish and create beautiful UI
5. remove hard coded Strings
6. handle network connection
7. add caching and local storage
8. add Interceptor
