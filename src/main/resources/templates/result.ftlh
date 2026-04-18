<!DOCTYPE html>
<html>
<head>
    <title>Movie Result</title>
    <link rel="stylesheet" href="/style.css">
</head>
<body style="font-family: Arial; background-color: #f4f4f4;">

<div style="width: 600px; margin: 50px auto; background: white; padding: 20px; border-radius: 10px;">
    <h2>Movie Submitted Successfully</h2>

    <p><b>Movie Name:</b> ${movie.movieName}</p>
    <p><b>Description:</b> ${movie.description}</p>
    <p><b>Uploaded File:</b> ${fileName!}</p>

    <a href="/form">
        <button style="padding:10px 20px; background-color:green; color:white; border:none; border-radius:5px;">
            Add Another Movie
        </button>
    </a>
</div>

</body>
</html>