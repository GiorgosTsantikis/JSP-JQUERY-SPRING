<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<script src="/jquery/details.js"></script>
  <article class="details-article">
    <section class="details-description">
      <h2 class="details-heading">${listing.name}</h2>
      <p class="details-location">${listing.city}, ${listing.state}</p>
    </section>
    <img class="details-photo" src="${listing.photo}"/>

    <section class="details-features">
      <h2 class="details-heading">About this location
      <span class="details-price">${listing.price}.0$</span>
      </h2>

      <ul class="details-ul">
        <li class="details-li">Units available:${listing.availableUnits}</li>
        <li class="details-li">Rooms:${listing.rooms}</li>
        <li class="details-li">Wifi:${listing.wifi}</li>
        <li class="details-li">Laundry:${listing.laundry}</li>
      </ul>
      <button class="delete-listing${listing.id}" id="delete-listing${listing.id}">Delete Listing</button>
    </section>

<%--hide this after application--%>
    <section class="listing-apply" id="if-not-applied">
      <h2 class="details-heading">Apply to live here</h2>
      <%--show application form--%>
      <button id="apply-button${listing.id}">Apply</button>
      <%--show edit form--%>
      <button id="edit-listing${listing.id}">Edit Listing</button>

      <div id="apply-form"></div>
    </section>


    <div id="apply-success"></div>


    <div id="edit-form"></div>
  </article>

    
