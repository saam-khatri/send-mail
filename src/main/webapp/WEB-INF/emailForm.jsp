<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Email</title>
    <style>
body {
    font-family: 'Arial', sans-serif;
    background-color: #f4f7f6;
    margin: 0;
    padding: 0;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    color: #333;
}

.container {
    width: 100%;
    max-width: 600px;
    background-color: #ffffff;
    padding: 30px;
    border-radius: 8px;
    box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
    text-align: center;
}

h1 {
    font-size: 2.5em;
    color: #4caf50;
    margin-bottom: 30px;
    font-weight: bold;
}

/* Form Styling */
form {
    display: flex;
    flex-direction: column;
    gap: 20px;
}

/* Form Group Styling */
.form-group {
    display: flex;
    flex-direction: column;
    gap: 5px;
    text-align: left;
}

input[type="email"], input[type="text"], textarea, input[type="file"] {
    padding: 8px;
    border: 1px solid #ddd;
    border-radius: 5px;
    font-size: 1em;
    color: #333;
    transition: border-color 0.3s ease;
}

input[type="email"]:focus, input[type="text"]:focus, textarea:focus, input[type="file"]:focus {
    border-color: #4caf50;
    outline: none;
}

textarea {
    resize: vertical;
    height: 100px;
}
button {
    padding: 12px 20px;
    background-color: #4caf50;
    color: white;
    font-size: 1.2em;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    transition: background-color 0.3s ease;
}

button:hover {
    background-color: #45a049;
}

@media (max-width: 768px) {
    .container {
        padding: 20px;
    }

    h1 {
        font-size: 2em;
    }

    button {
        font-size: 1em;
    }
}


    </style>
</head>
<body>
    <div class="container">
         <h1>Email Sender</h1>
    <form action="${contextPath.request.pageContext}/send-email-html" method="POST" enctype="multipart/form-data">
        <div class="form-group">
             <label for="recipient">Your Email:</label>
            <input type="email" id="recipient" name="from" required>
        </div>
        <div class="form-group">
             <label for="recipient">Subject:</label>
        <input type="text" id="subject" name="subject" required>
        </div>
        <div class="form-group">
             <label for="recipient">Message:</label>
            <textarea id="message" name="message" required></textarea>
        </div>
        <div class="form-group">
             <label for="recipient">Documents:</label>
            <input type="file" id="file" name="file">
        </div>

        <button type="submit">Send Email</button>
    </form>
    </div>
</body>
</html>
