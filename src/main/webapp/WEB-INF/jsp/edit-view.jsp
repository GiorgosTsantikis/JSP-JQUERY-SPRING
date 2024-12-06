<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="form-container">
<form  action="/updateListing/${listing.id}" method="POST" class="edit-form">
    <label for="name">Name:</label>
    <input
        type="text"
        id="name"
        name="name"
        value="${listing.name}"
        required
        />
    <label for="city">City:</label>
    <input
        type="text"
        id="city"
        name="city"
        value="${listing.city}"
        required
        />
    <label for="state">State:</label>
    <input
           type="text"
           id="state"
           name="state"
           value="${listing.state}"
           required
        />
    <label for="availableUnits">Available Units:</label>
    <input
            type="number"
            id="availableUnits"
            name="availableUnits"
            value=${listing.availableUnits}
            required
         />
    <label for="wifi">Wifi:</label>
    <input
             type="checkbox"
             id="wifi"
             name="wifi"
             value=${listing.wifi}
        />
    <label for="laundry">Laundry:</label>
    <input
            type="checkbox"
            id="laundry"
            name="laundry"
            value=${listing.laundry}
       />
    <label for="price">Price:</label>
    <input
           type="number"
           id="price"
           name="price"
           value=${listing.price}
           required
    />
    <label for="rooms">Rooms</label>
    <input
        type="number"
        id="rooms"
        name="rooms"
        value=${listing.rooms}
        required
    />
    <button id="create-btn" type="submit">Submit</button>
</form>
</div>