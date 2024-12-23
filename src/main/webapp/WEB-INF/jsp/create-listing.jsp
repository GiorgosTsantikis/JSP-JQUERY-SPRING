
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="form-container">
<form  action="/addListing" method="POST" class="edit-form">
    <label for="name">Name:</label>
    <input
        type="text"
        id="name"
        name="name"
        required
        />
    <label for="city">City:</label>
    <input
        type="text"
        id="city"
        name="city"
        required
        />
    <label for="state">State:</label>
    <input
           type="text"
           id="state"
           name="state"
           required
        />
    <label for="availableUnits">Available Units:</label>
    <input
            type="number"
            id="availableUnits"
            name="availableUnits"
            required
         />
    <label for="wifi">Wifi:</label>
    <input
             type="checkbox"
             id="wifi"
             name="wifi"
        />
    <label for="laundry">Laundry:</label>
    <input
            type="checkbox"
            id="laundry"
            name="laundry"
       />
    <label for="price">Price:</label>
    <input
           type="number"
           id="price"
           name="price"
           required
    />
    <label for="rooms">Rooms</label>
    <input
        type="number"
        id="rooms"
        name="rooms"
        required
    />
    <button id="create-btn" type="submit">Submit</button>
</form>
</div>

