package org.d3if1016.mydrama

import Drama
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.SearchView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.d3if1016.mydrama.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    val listDrama = arrayListOf<Drama>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener{
            val negara = binding.negaraInp.text.toString()
            val genre = binding.genreInp.text.toString()
            tampilkanData(negara, genre)
            loadData()
        }

        if (listDrama.isEmpty()) {
            listDrama.addAll(getData())
            loadData()
        }
    }

    private fun loadData() {
        with(binding.recyclerView) {
            layoutManager = GridLayoutManager(this@MainActivity, 2)
            adapter = MainAdapter(listDrama)
            setHasFixedSize(true)
        }
    }

    private fun tampilkanData(negara: String, genre : String) : List<Drama> {
        if (listDrama.isNotEmpty()) {
            listDrama.clear()
        }

        getData().forEachIndexed { index, drama ->
            if (negara.isNotEmpty()) {
                if (negara.equals(drama.negara, true)) {
                        listDrama.add(getData()[index])
                }
            }

            else if (genre.isNotEmpty()) {
                if (genre.equals(drama.genre, true)) {
                    listDrama.add(getData()[index])
                }
            }

            else if (negara.isNotEmpty() && genre.isNotEmpty()) {
                if (genre.equals(drama.genre, true) && negara.equals(drama.negara, true)) {
                    listDrama.add(getData()[index])
                }
            }
        }
        return listDrama
    }
}

    private fun getData(): List<Drama> {
        return listOf(
            Drama( "Abbys", "Comedy, Romance", "Korea",  R.drawable.abbys),
            Drama( "Angel's Last Mission : 'Love'", "Romance, Fantasi\n", "Korea", R.drawable.angelslastmission),
            Drama( "Begin Again", "Comedy, Drama, Romance\n", "China", R.drawable.beginagain),
            Drama( "Business Proposal", "Comedy, Romance", "Korea", R.drawable.businessproposal),
            Drama( "Crash Landing On You", "Romance, Comedy", "Korea", R.drawable.crashlandingonyou),
            Drama( "Falling Into Your Smile", "Comedy, Romance, Youth, E-Sports\n", "China", R.drawable.fallingintoyoursmile),
            Drama( "Forecasting Love and Weather", "Comedy, romantis\n", "Korea",  R.drawable.forecastingloveandweather),
            Drama( "Go Go Squid", "Comedy, Romance, E-Sports\n", "China", R.drawable.gogosquid),
            Drama( "Healer", "Romance, Thiller, Comedy, Drama\n", "Korea", R.drawable.healer),
            Drama( "Hotel Del Luna", "Fantasi", "Korea", R.drawable.hoteldelluna),
            Drama( "Intense Love", "Frienship, Comedy, Romance, Life\n", "China", R.drawable.intenselove),
            Drama( "It's Okay To Be Not Okay", "Comedy, Romsnce\n", "Korea", R.drawable.itsokaytobenotokay),
            Drama( "Love 020", "Comedy, Romance, Youth\n", "Korea", R.drawable.love020),
            Drama( "Love Scenery", "Music, Comedy, Romance\n", "China", R.drawable.lovescenery),
            Drama( "My Dear Guardian", "Military, Romance, Drama, Medical\n", "China", R.drawable.mydearguardian),
            Drama( "My Little Happines", "Comedy, Romance", "Korea", R.drawable.mylittlehappines),
            Drama( "Our Beloved Summer", "Drama, Comedy, Romance", "Korea", R.drawable.ourbelovedsummer),
            Drama( "Our Glamorious Time", "Action, Business, Romance\n", "China", R.drawable.ourglamorioustime),
            Drama( "Put Your Head On My Shoulders", "Comedy, Romance, Slice of life, Teen Story\n", "China", R.drawable.putyourheadonmyshoulders),
            Drama( "Start-Up", "Drama, Romance", "Korea", R.drawable.startup),
            Drama( "The Flaming Heart", "Action, Romance, Drama, Medical\n", "China", R.drawable.theflamingheart),
            Drama( "The King: Eternal Monarch", "History, Fantasi, Time Travel, Romance\n", "Korea", R.drawable.theking),
            Drama( "The Tale of The Nine Tailed", "Drama, Fantasi", "Korea", R.drawable.thetaleoftheninetailed),
            Drama( "Touch Your Heart", "Comedy, Romance", "Korea", R.drawable.touchyourheart),
            Drama( "Twenty Five Twenty One", "Drama, Romance, Maturity\n", "Korea", R.drawable.twentyfivetwentyone),
            Drama( "Unconrollably Fond", "Melodrama, Romance", "Korea", R.drawable.uncontrollablyfond),
            Drama( "Vincenzo", "Comedy, Dark", "Korea", R.drawable.vincenzo),
            Drama( "Unforgottable Love", "Romance", "China", R.drawable.unforgottablelove),
            Drama( "You Are My Glory", "Comedy, Romance, Life, Youth\n", "China", R.drawable.youaremyglory),
            Drama("You Are My Hero", "Military, Romance, Drama, Medical\n", "China", R.drawable.youaremyhero)
            )
        }