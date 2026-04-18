<!DOCTYPE html>
<html>
<head>
    <title>Add Movie</title>
    <link rel="stylesheet" href="/style.css">
</head>
<body>

<div class="container">

    <h2>Add Movie</h2>

    <div class="form-page">
        <img src="/movie.jpg" alt="Movie Image" class="side-image">

        <form action="/submit" method="post" class="movie-form">
            <label>Movie Name:</label><br>
            <input type="text" name="movieName" value="${movieForm.movieName!}"><br>

            <#if springMacroRequestContext??>
                <#assign errors = springMacroRequestContext.getErrors("movieForm") />
                <#if errors?? && errors.hasFieldErrors("movieName")>
                    <span class="error">${errors.getFieldError("movieName").defaultMessage}</span><br>
                </#if>
            </#if>

            <label>Director:</label><br>
            <input type="text" name="director" value="${movieForm.director!}"><br>

            <#if springMacroRequestContext??>
                <#assign errors = springMacroRequestContext.getErrors("movieForm") />
                <#if errors?? && errors.hasFieldErrors("director")>
                    <span class="error">${errors.getFieldError("director").defaultMessage}</span><br>
                </#if>
            </#if>

            <label>Year:</label><br>
            <input type="number" name="year" value="${movieForm.year!}"><br>

            <#if springMacroRequestContext??>
                <#assign errors = springMacroRequestContext.getErrors("movieForm") />
                <#if errors?? && errors.hasFieldErrors("year")>
                    <span class="error">${errors.getFieldError("year").defaultMessage}</span><br>
                </#if>
            </#if>

            <label>Category:</label><br>
            <select name="categoryId">
                <#list categories![] as category>
                    <option value="${category.id}">${category.name}</option>
                </#list>
            </select><br><br>

            <button type="submit">Save Movie</button>
            <a href="/" class="back-link">Back</a>
        </form>
    </div>

</div>

</body>
</html>