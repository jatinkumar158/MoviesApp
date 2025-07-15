OVERVIEW
Using the TmDB api [https://developers.themoviedb.org/3/getting-started/introduction] create
a movies application which shows the trending and now playing movies. Let’s user search
for a movie and bookmark movies.

TASKS
1. Create a home page which shows trending movies and now playing movies (Use TMDB API) => Done
2. Create a Movie details page and navigate user when they click on the movie => Done 
3. Allow users to bookmark a movie and show a saved movies page => Done ((Added filtering in same recycler view))
4. Make sure the app works offline and save the responses in a local DB use any orm like (greendao,
room, realm, etc) => Done (Used Room DB to store data offline)
5. Create a search Tab where users can search for their movies => Skipped for now (Since api for search already exists so current solution can be extended easily)
6. BONUS TASK: In search PAGE: Instead of giving a text and search button make network calls
after some time when the user stops typing, update the results as the user is typing. => skipped for now
7. BONUS TASK: Allow users to share the movie and create a dummy deeplink which will take users => skipped for now
to shared movie directly

SPECIFICATIONS
1. Use Java/Kotlin as the language for the app.. => Done (Used kotlin)
2. For networking use Okhttp and Retrofit with and JSON Adapter (eg. GSON) => Done (Used retrofit)
3. Setup any architecture for the app (MVVM, MVP, etc) => Done (Used MVVM Clean Architecture)
4. App should be presentable with decent UX (You can take any popular app
home screen as inspiration) => Done
5. Use Repository Pattern for data storing => Done (MVVM clean architecture already uses repository)
6. Store movies from the api in database and load the movies from in ui from
local database => Done (Used remote, local and cached data sources)
7. BONUS: Use viewmodels for storing UI state => Done (MVVM already uses view models)
8. BONUS: Use Rx Java or Coroutines for making calls to db and network instead of the
default call structure of retrofit => Done (All db and network calls are from Coroutines)
