<!DOCTYPE html>
<html>
<head>
    <title>${title!"Movie Page"}</title>
    <link rel="stylesheet" href="/style.css">
</head>
<body>
<div class="container">

    <h1>${title!"Movie Page"}</h1>

    <div class="hero">
<img src="/movie.jpg" alt="Movie Image" width="500">
        <div class="hero-text">

            <h2>Welcome to Movie Page</h2>
            <p>Add your favorite movies, choose category, and manage them easily.</p>
            <a href="/form"><button>Add Movie</button></a>
        </div>
    </div>

    <br><br>

    <table border="1" cellpadding="10">
        <tr>
            <th>ID</th>
            <th>Movie Name</th>
            <th>Director</th>
            <th>Year</th>
            <th>Category</th>
            <th>Action</th>
        </tr>

        <#list movies![] as movie>
            <tr>
                <td>${movie.id!}</td>
                <td>${movie.movieName!}</td>
                <td>${movie.director!}</td>
                <td>${movie.year!}</td>
                <td><#if movie.category??>${movie.category.name!}</#if></td>
                <td><a href="/delete/${movie.id}">Delete</a></td>
            </tr>
        </#list>
    </table>

</div>

</body>
</html>