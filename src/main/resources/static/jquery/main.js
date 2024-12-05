  $(document).ready(function(){

    $('.create-listing-btn').on('click',function(){
        window.location.href='/addListing';
    });

    


    function getDetails(id){
      console.log("get",id);
    }

    $.ajax({
      url:'http://localhost:8080/getListingNumber',
      method:'GET',
      success:(res)=>{
        console.log(res);
        for(let i=1;i<=parseInt(res);i++){
          $(`#edit-listing${i}`).on('click',()=>{
            console.log("edit",i);
            //getDetails(1);
          });
          $(`#delete-listing${i}`).on('click',()=>{
            console.log("delete",i);
            $.ajax({
              url:`http://localhost:8080/listing/${i}`,
              method:'DELETE',
              success:()=>window.location.href='/home'
            })
          });
          $(`#apply-button${i}`).on('click',()=>{
            console.log("apply",i);
          })

        }
      }
    })

  });