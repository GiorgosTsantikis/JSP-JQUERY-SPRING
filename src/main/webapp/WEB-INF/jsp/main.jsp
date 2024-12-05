<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

    <head>
        <title>Home</title>
        <link href="/css/home.css" rel="stylesheet" type="text/css">
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script src=/jquery/main.js></script>

    </head>
    <body>
    <main>
  <header class="brand-name">
  <a href="/home">
  <img class="brand-logo" src="/assets/logo.svg" />
  </a>
  </header>
  
  <section class="content">

  <jsp:include page="${contentPage}"/>

  </section>

  </main>
        
                
            
    </body>
</html>