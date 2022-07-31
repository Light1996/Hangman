<table><tr><td> <em>Assignment: </em> IT114 Hangman Milestone3</td></tr>
<tr><td> <em>Student: </em> Nour Sadiq(nss63)</td></tr>
<tr><td> <em>Generated: </em> 8/1/2022 3:48:25 AM</td></tr>
<tr><td> <em>Grading Link: </em> <a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-450-M22/it114-hangman-milestone3/grade/nss63" target="_blank">Grading</a></td></tr></table>
<table><tr><td> <em>Instructions: </em> <p>Implement the features from Milestone3 from the proposal document:&nbsp;<a href="https://docs.google.com/document/d/1QkF94ar-x9LjnYjQfkjgKx7NfhJsailXF10o7GcQAd4/view">https://docs.google.com/document/d/1QkF94ar-x9LjnYjQfkjgKx7NfhJsailXF10o7GcQAd4/view</a></p>
</td></tr></table>
<table><tr><td> <em>Deliverable 1: </em> Connection Screens </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="http://via.placeholder.com/400x120/009955/fff?text=Complete"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshots showing the screens with the following data</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/60442273/182048116-c4133ce7-39a0-4f03-a11d-bfca89b5cc92.jpg"/></td></tr>
<tr><td> <em>Caption:</em> <p>Connection screen<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Briefly explain the code for each step of the process</td></tr>
<tr><td> <em>Response:</em> <ul><li>Here I have established the server on the localhost server and 5215 port</li><li>I<br>have used the Server Socket connection to establish server on specified path and<br>port</li><li>The server is waiting for clients on 5215 port</li><li>The port and server field<br>is filled in GUI of the client by default</li></ul><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 2: </em> Game view </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="http://via.placeholder.com/400x120/009955/fff?text=Complete"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshots showing the related UI</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/60442273/182048117-daee8b26-6dd1-40e3-896b-56100965d700.jpg"/></td></tr>
<tr><td> <em>Caption:</em> <p>Start game<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/60442273/182048118-ce1ef4fb-19ff-44a2-b40b-d3c6956cb64c.jpg"/></td></tr>
<tr><td> <em>Caption:</em> <p>Letter found<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/60442273/182048119-2df7dadc-2c2d-430a-833d-5e6e2bbd219a.jpg"/></td></tr>
<tr><td> <em>Caption:</em> <p>User score<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/60442273/182048121-b186e65b-d8a1-4172-88c5-d2c8c2efa83e.jpg"/></td></tr>
<tr><td> <em>Caption:</em> <p>User win the game<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/60442273/182048122-694726ca-ce5c-497e-9e50-ffd8cd606cf7.jpg"/></td></tr>
<tr><td> <em>Caption:</em> <p>Server picking word and sending blanks<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/60442273/182048123-dee6c7af-eebb-43ac-b7e3-907978ebcd57.jpg"/></td></tr>
<tr><td> <em>Caption:</em> <p>Client turn and guesses<br></p>
</td></tr>
</table></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 3: </em> Game Logic </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="http://via.placeholder.com/400x120/009955/fff?text=Complete"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Show the code snippets for part of the game flow</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/60442273/182048126-8a4b72fa-c3d1-49c9-9e0e-6fe29a95db9d.jpg"/></td></tr>
<tr><td> <em>Caption:</em> <p>Server controller<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/60442273/182048128-06102398-d501-4731-a978-4809975f3b35.jpg"/></td></tr>
<tr><td> <em>Caption:</em> <p>Game flow after getting input from user<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/60442273/182048131-d682e3c9-506e-4968-8649-07b0a320f4df.jpg"/></td></tr>
<tr><td> <em>Caption:</em> <p>User score updated every time a right letter is guessed<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Briefly explain the code flow for each of the steps of the game flow mentioned previously</td></tr>
<tr><td> <em>Response:</em> <ul><li>Here at first, I have run the server using threading so that multiple<br>clients can be handled at once</li><li>After that, I got input of the letter<br>from the user after establishing the connection with the server and selecting level</li><li>After<br>that, I checked the letter for multiple conditions including the possibility of one<br>letter guess correctly, one letter guessed wrong, one letter invalid occurrence, the word<br>being guessed correctly, and the tries of the user ended and the word<br>is not guessed</li><li>After that, I have updated the score of user after every<br>turn</li><li>User can see his score by clicking on the button score</li></ul><br></td></tr>
</table></td></tr>
<table><tr><td><em>Grading Link: </em><a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-450-M22/it114-hangman-milestone3/grade/nss63" target="_blank">Grading</a></td></tr></table>