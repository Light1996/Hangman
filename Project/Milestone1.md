<table><tr><td> <em>Assignment: </em> It114 Milestone1</td></tr>
<tr><td> <em>Student: </em> Nour Sadiq(nss63)</td></tr>
<tr><td> <em>Generated: </em> 6/26/2022 5:30:01 PM</td></tr>
<tr><td> <em>Grading Link: </em> <a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-450-M22/it114-milestone1/grade/nss63" target="_blank">Grading</a></td></tr></table>
<table><tr><td> <em>Instructions: </em> <ol><li>Create a new branch called Milestone1</li><li>At the root of your repository create a folder called Project</li><li>Create a milestone1.md file inside the project folder</li><li>Git add/commit/push it to Github</li><li>Create a pull request from Milestone1 to main (don't complete/merge it yet)</li><li>Copy in the latest Socket sample code from the most recent Socket Part example</li><ol><li>Recommended Part 5, but Part 4 should be sufficient</li></ol><li>Git add/commit the baseline</li><li>Ensure the sample is working and fill in the below deliverables</li><li>Get the markdown content or the file and paste it into the milestone1.md file or replace the file with the downloaded version</li><li>Git add/commit/push all changes</li><li>Complete the pull request merge from step 5</li><li>Locally checkout main</li><li>git pull origin main</li></ol></td></tr></table>
<table><tr><td> <em>Deliverable 1: </em> Startup </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="http://via.placeholder.com/400x120/009955/fff?text=Complete"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshot showing your server being started and running</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/60442273/175838540-139fbd34-c601-4371-b3c7-62409bc2b55b.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Server<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Add screenshot showing your client being started and running</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/60442273/175838558-e4563058-167a-4372-9c81-9b815a968e19.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Client 1<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/60442273/175838539-82b65ada-426e-4246-94eb-98b66d136096.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Client 2<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Briefly explain the connection process</td></tr>
<tr><td> <em>Response:</em> <p>Here the server is connected to a specific port using Server Socket from<br>the Java network library.<div>The client is connected to the server running on localhost<br>on a specific port using the network library socket.</div><br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 2: </em> Sending/Receiving </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="http://via.placeholder.com/400x120/009955/fff?text=Complete"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshot(s) showing evidence related to the checklist on the right</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/60442273/175838540-139fbd34-c601-4371-b3c7-62409bc2b55b.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Two clients are connected to the server<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/60442273/175838673-11f51219-f34a-4910-9f38-c82a1951d8f2.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Two clients communicating with each other<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/60442273/175838727-2adb7868-a407-467e-8b7b-e32f7542fd22.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Server is broadcasting the message between clients<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Briefly explain how the messages are sent, broadcasted, and received</td></tr>
<tr><td> <em>Response:</em> <p>The messages are sent using the Print writer from the input/output library in<br>Java.<div>The messages are received using the Buffered reader from the input/output library in<br>Java.</div><div>The messages are broadcasted using the Print writer of each individual user in<br>the same room.</div><br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 3: </em> Disconnecting / Terminating </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="http://via.placeholder.com/400x120/009955/fff?text=Complete"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshot(s) showing evidence related to the checklist on the right</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/60442273/175838875-28be6263-90fb-4f15-b19f-19078452b13c.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Server is running while the clients are disconnected<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/60442273/175838874-ee4bdc88-5d5b-4a4a-b836-d783bfcde06d.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Clients received the message about another user quitting<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Briefly explain how the various disconnects/terminations are handled</td></tr>
<tr><td> <em>Response:</em> <p>The termination condition of the client is handled by terminating the specific thread<br>upon which the client was connected.<div>The server functions normally after a client is<br>disconnected as it removes the client from the thread pool and all the<br>other clients remain connected.<br><div><br></div></div><br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 4: </em> Misc </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="http://via.placeholder.com/400x120/009955/fff?text=Complete"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add the pull request for this branch</td></tr>
<tr><td> <a rel="noreferrer noopener" target="_blank" href="https://github.com/Light1996/Hangman/pull/1">https://github.com/Light1996/Hangman/pull/1</a> </td></tr>
</table></td></tr>
<table><tr><td><em>Grading Link: </em><a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-450-M22/it114-milestone1/grade/nss63" target="_blank">Grading</a></td></tr></table>
