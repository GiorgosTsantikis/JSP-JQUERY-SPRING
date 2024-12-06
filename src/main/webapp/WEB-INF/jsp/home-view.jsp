
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  

  <section>
        <input type="text" id="city" placeholder="Filter By City">

        <button class="create-listing-btn" enable="true" >Add Listing</button>
    </section>
    <section class="results">


    <c:forEach items="${listings}" var="listing">
    <a href="/listing/${listing.id}" data-city="${listing.city}" class="click-listing">
    <section class="listing-home">
    <img src="${listing.photo}" class="listing-home-photo"/>
    <h2 class="listing-home-heading">${listing.name}</h2>
    <p class="listing-home-location">${listing.city}, ${listing.state}</p>
    <p class="listing-home-price">${listing.price}.0$</p>
    <div>${listing.id}</div>
    </section>
     </a>                              
    </c:forEach>
    </section>


        
                
