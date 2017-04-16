# Todo list exercise

### Install

- Install https://nodejs.org/en/
- Download archive from link provided
- Unzip file and cd into it
- run `npm install`

### Run
`node app.js`

Visit http://localhost:8080 in your browser

### High level application requirements
1. Multiple users should be able to view the shared public todo list
2. Should be able to add items
3. Should be able to delete items
4. Should be able to edit items (Missing feature)
5. Must be able to deploy in docker (Missing feature)

### Tasks
1. Add missing requirement #4 to the application
2. Add sufficient test coverage to the application and update readme on howto run the tests
3. Add missing requirement #5 to the application (Dockerfile and update readme with instructions)

### Bonus
4. Display test coverage after tests are executed
5. Find and fix the XSS vulnerability in the application. Also make sure that it wont happen again by including a test.

> ### Notes
> - Update the code as needed and document what you have done in the readme below
> - Will be nice if you can git tag the tasks by number

### Solution
Please note: My solution is for a windows environment. Check out all my code from https://github.com/garthbosch/Entersekt_Assessment.git

I've changed the Nodejs application a bit. I hope it is not problem.
> ### Changes to the app
> - created public folder with images and a stylesheet
> - created a public folder which has the index.js
> - created a views folder which has the edit.ejs, index.ejs and layout.ejs files.
> - added a mongodb; so list items are added, edited and deleted from the db.

Setting up mongodb:
-------------------
1. Install mongodb from https://www.mongodb.com/download-center#community
2. Create a folder C:\data\db
3. Run mongodb as follows: <InstalledDirectory>\bin\mongod.exe

Requirement 4:
--------------
1. List item needs to added to the list. To edit the item, you need to click on the list item type the new value and press enter.
2. Test coverage has been created with the following setup:
> ### Test Framework
> - Technologies used: Java, TestNG, Ant, Selenium
> - How to run the tests: In the run_Entersekt_Assessment_project.bat file change the projectPath and classPath to your paths, then run the file.
3. Unfortunately not done...
4. Test logs and screenshots are created in the logs folder.
5. XSS vulnerability was overcome with creating user sessions and not allowing javascript injection into the text field. A test is included to make sure if you try to inject javascript into the text field that the script does not perform it's function but handles it as if it is normal text.
