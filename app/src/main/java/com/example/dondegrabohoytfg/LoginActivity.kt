package com.example.dondegrabohoytfg


import android.os.Bundle
import android.telecom.Call
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import com.example.dondegrabohoytfg.databinding.ActivityLoginBinding
import org.imaginativeworld.whynotimagecarousel.ImageCarousel
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem


class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    private val sliderInicio= mutableListOf<CarouselItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Slider de imagenes
        val carousel: ImageCarousel = findViewById(R.id.carousel)
        sliderInicio.add(CarouselItem(""))
        sliderInicio.add(CarouselItem("https://www.google.com/search?q=restaurante+monico&rlz=1C1MSIM_enES739ES739&sxsrf=ALiCzsZB5S3YhlPWq1i6KB4yrr8ZwWkhaw:1652391598165&source=lnms&tbm=isch&sa=X&ved=2ahUKEwiK8POx9tr3AhVmMewKHYpxD2QQ_AUoAnoECAIQBA&biw=1920&bih=969&dpr=1#imgrc=wemvX7vGfKOo0M"))
        sliderInicio.add(CarouselItem("https://www.google.com/search?q=casa+de+comerte+entera&rlz=1C1MSIM_enES739ES739&sxsrf=ALiCzsaW61ooTD1Sc6tJRNzYTXL_rvxaPA:1652392496794&source=lnms&tbm=isch&sa=X&ved=2ahUKEwiP6bPe-dr3AhV2R_EDHV-RBoIQ_AUoAXoECAEQAw&biw=1920&bih=969&dpr=1#imgrc=GkaeTSE0XmD6XM"))
        carousel.addData(sliderInicio)
        //union entre activities

        binding.lUsu.doAfterTextChanged {
            comprobartexto()
        }
        binding.lPass.doAfterTextChanged {
            comprobartexto()
        }
        binding.bContinue.setOnClickListener {

            MainActivity.launch(this@LoginActivity)
        }

    }
    fun comprobartexto(){
        if(binding.lUsu.text.length>3 && binding.lPass.text.length==8 ){
            binding.bContinue.visibility= View.VISIBLE
        }else{
            binding.bContinue.visibility= View.GONE
        }
    }
}

