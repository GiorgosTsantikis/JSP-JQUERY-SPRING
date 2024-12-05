
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<form  class="edit-form">
    <label for="name">Name:</label>
    <input
        type="text"
        id="name"
        />
    <label for="city">City:</label>
    <input
        type="text"
        id="city"
        />
    <label for="state">State:</label>
    <input
           type="text"
           id="state"
        />
    <label for="availableUnits">Available Units:</label>
    <input
            type="number"
            id="availableUnits"
         />
    <label for="wifi">Wifi:</label>
    <input
             type="checkbox"
             id="wifi"
        />
    <label for="laundry">Laundry:</label>
    <input
            type="checkbox"
            id="laundry"
       />
    <label for="price">Price:</label>
    <input
           type="number"
           id="price"
    />
    <label for="rooms">Rooms</label>
    <input
        type="number"
        id="rooms"
    />
    <button type="submit">Submit</button>
</form>

