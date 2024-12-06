
$(document).ready(function(){

    const id=window.location.pathname.split('/').pop();
    console.log(id," idddd");
    //click edit button on a listing takes you to editListing/id
    $(`#edit-listing${id}`).on('click',()=>{
        console.log("edit from details ",id);
        window.location.href=`/editListing/${id}`;
      });

      //click delete on a listing sends a delete request and redirects to home
      $(`#delete-listing${id}`).on('click',()=>{
        console.log("delete",id);
        $.ajax({
          url:`http://localhost:8080/listing/${id}`,
          method:'DELETE',
          success:()=>window.location.href='/home'
        })
      });
      //click apply button creates a form
      $(`#apply-button${id}`).on('click',()=>{
        $('#apply-form').show();
        $('#apply-success').empty();
        //check if form has already been rendered
        if($('#application-form'+id).length===0){
        $('#apply-form').prepend(`
            <form class="apply-form" id="application-form${id}">
            <label for="email">Email:</label>
    <input
      type="email"
      id="email"
      name="email"
      required
      />
      
      <label for="firstName">First Name:</label>
      <input
        type="text"
        id="firstName"
        name="firstName"
        required
        />
        <label for="lastName">Last Name:</label>
        <input
          type="text"
          id="lastName"
          name="lastName"
          required
          />
          <label for="phoneNum">Phone Number(with 3 digit country code):</label>
          <input
            type="text"
            id="phoneNum"
            name="phoneNum"
            required
            />
            <div class="email-warn" hidden="true">

              Please enter a phone number in the form +030XXXXXXXXXX
            </div>
      <button type="submit" id="apply-btn" >Sign up</button>
            </form>`);
        }
      });
      
      //turns form into json
      function getFormData($form){
          var unindexed_array = $form.serializeArray();
          var indexed_array = {};

          $.map(unindexed_array, function(n, i){
              indexed_array[n["name"]] = n["value"];
          });

          return indexed_array;
      }

      //submit application form
      $(document).on('submit',`#application-form${id}`,function(evt) {
        evt.preventDefault();
        const formData = getFormData($(this));
        console.log(formData.phoneNum);
        //phone number reg-ex +123 plus 10 digits
        const regex=/[+]\d{13}$/;
        if(regex.test(formData.phoneNum)){
         $('.email-warn').hide();
        //post the application get the application data back 
        $.ajax({
            url:`http://localhost:8080/application/${id}`,
            contentType:'application/json',
            method:'POST',
            data:JSON.stringify(formData),
            success:function(response){
                console.log('yes');
                $('#apply-form').hide();
                $('#apply-success').prepend(`
                    <div>
                    <p>Email:${response.email}</p>
                    <p>First name:${response.firstName}</p>
                    <p>Last name:${response.lastName}</p>
                    <p>Phone number:${response.phoneNum}</p>
                    </div>
                    `);
            },
            error:function(response){
                console.log('error');
            }
        });
      }else{
        $('.email-warn').show();
      }  // Logs the serialized form data (e.g., email, firstName, etc.)

      });

});