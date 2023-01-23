Version 1.0.1 :

Feature:
 - 4 NEW 23 FACTS
 - 11 UPDATED 23 FACTS with translations and fixing typos

Version 1.0.0 :

Release

Version 0.0.5 :

Feature:
 - 3 NEW 23 FACTS
 - Change settings randomness
Improvement:
 - Storing settings values
Tech:
 - domain layer in a :domain module

Version 0.0.4 :

Feature:
 - 5 NEW 23 FACTS
 - Fact sharing : Click on floating button on fact screen and send to your friend. Your friend will click on the link and be redirected to its browser and then can open the app top left 
 - On search the text preview is now centered on the string searched.
Improvement:
 - Improving the fact top bar title with short names for categories with long name
Fix:
 - The search included previously the URL text, but the results where incoherent. The search is now only on title and fact text.
 - Some link preview didn't show the correct language. Now if the URL contains .fr the language is french otherwise the language from the page.
Tech:
 - Refactoring the settings screen architecture

Version 0.0.3 :

Feature:
 - 3 NEW 23 FACTS
 - Settings: Reset Data
 - On secret snackbar clicked, navigate to secrets view
 - Add a border to secret snackbar to entice user look and click it
Improvement:
 - Fact loading: Loading fact details, then sources for better display with less waiting time
Fix:
 - Topbar title when fact selected and going back to the screen category
 - Topbar title when random is clicked
 - Snackbar containing secrets blinked randomly
Tech:
 - Refactoring all the :app module with a clean mainView and navHost