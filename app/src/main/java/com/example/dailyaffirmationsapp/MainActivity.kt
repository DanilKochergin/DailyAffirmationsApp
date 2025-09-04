package com.example.dailyaffirmationsapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.dailyaffirmationsapp.databinding.ActivityMainBinding
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        dropAffirmation()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }




    }
    //Список цитат
    val affirmations = listOf<String>("Не жди идеального момента — возьми этот момент и сделай его идеальным.",
        "Если ты не готов рискнуть обычным, тебе придётся довольствоваться заурядным.",
        "Страх — это всего лишь иллюзия. Его нет — его создаёшь ты сам.",
        "Даже если ты двигаешься медленно, главное — не останавливайся.",
        "Не ошибается только тот, кто ничего не делает. Не бойся ошибаться — бойся бездействовать.",
        "Мечты не работают, пока не работаешь ты.",
        "Ты — это то, что ты делаешь каждый день. Великие результаты начинаются с маленьких шагов.",
        "Ты сильнее, чем думаешь, и способен на большее, чем представляешь.",
        "Падение — не провал. Провал — это когда ты остаёшься на земле.",
        "Лучшее время что-то начать — сейчас. Второго подходящего момента не будет.",
        "Успех — это не случайность, это труд, настойчивость, обучение и самопожертвование.",
        "Если тебе не страшно — значит, цель слишком маленькая.",
        "Каждый день — шанс стать лучше, чем вчера.",
        "Препятствия — это те страшные вещи, которые ты видишь, когда отводишь взгляд от цели.")

    fun dropAffirmation(){
        //Считываем день
        val dayOfYear = Calendar.getInstance().get(Calendar.DAY_OF_YEAR)
        val uniqueIndex = (dayOfYear - 1) % affirmations.size // -1, так как dayOfYear от 1 до 366
        binding.tv.text = affirmations[uniqueIndex]
    }

}