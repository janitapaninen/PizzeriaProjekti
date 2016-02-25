$('.scroll').click(function(){
    $("html, body").animate({ scrollTop: 0 }, 800);
    return false;
});


/* detect mobile/desktop resolution & switch menu types accordingly */	
jQuery(document).ready(function(){

	var width = jQuery(window).width();

	if(width < 480)
	{
		jQuery('#desktopMenu').removeClass('visible');
		jQuery('#desktopMenu').addClass('hidden');
		jQuery('#mobileMenu').removeClass('hidden');
		jQuery('#mobileMenu').addClass('visible');
	}
	else
	{
		jQuery('#desktopMenu').removeClass('hidden');
		jQuery('#desktopMenu').addClass('visible');
		jQuery('#mobileMenu').removeClass('visible');
		jQuery('#mobileMenu').addClass('hidden');
	}
});	



