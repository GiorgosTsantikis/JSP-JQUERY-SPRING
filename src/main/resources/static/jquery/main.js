  $(document).ready(function(){

    $('.create-listing-btn').on('click',function(){
        window.location.href='/addListing';
    });

    
    $('#city').on('input',(evt)=>{
      const filter=evt.target.value.toLowerCase();
      
      $('.results a').each(function(){
        console.log(this);
        const city=$(this).data('city').toLowerCase();
        if(city.includes(filter)){
          $(this).show();
        }else{
          $(this).hide();
        }
      });

    });

    

    

  });