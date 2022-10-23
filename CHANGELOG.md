Version 0.0.4 :

Feature:
 - On search the text preview is now centered on the string searched.
Fix:
 - The search included previously the URL text, but the results where incoherent. The search is now only on title and fact text.
 - Some link preview didn't show the correct language. Now if the URL contains .fr the language is french otherwise the language from the page.

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