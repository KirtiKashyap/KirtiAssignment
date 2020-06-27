package com.wiprotest.demo
import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import com.wiprotest.demo.model.PopuralAlbum
import com.wiprotest.demo.ui.AlbumAdapter
import com.wiprotest.demo.util.AlbumPresenter
import com.wiprotest.demo.util.AlbumService
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Response

class MainActivity : AppCompatActivity(),UiView {
    var screenSizeName : String=""
    lateinit var gridLayoutManager : GridLayoutManager
    lateinit var albumPresenter: AlbumPresenter
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val albumService = AlbumService(this)
         albumPresenter=
             AlbumPresenter(this, albumService)
        val screenLayout: Int = getResources().getConfiguration().screenLayout
        screenSizeName = getScreenSize(screenLayout)

        gridLayoutManager = GridLayoutManager(this, 3)
        albumPresenter.getAlbum(getString(R.string.album))
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_search, menu)
        var  searchText =""

        val menuSearch:MenuItem = menu.findItem(R.id.search)
        val searchView : SearchView= menuSearch.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextChange(newText: String): Boolean {
                searchText=newText
                return false
            }
            override fun onQueryTextSubmit(query: String): Boolean {
                albumPresenter.getAlbum(query)
                return false
            }

        })
        val menuSearchClick:MenuItem = menu.findItem(R.id.click)
        val clickTV : ImageButton= menuSearchClick.actionView as ImageButton
        clickTV.setOnClickListener {
            albumPresenter.getAlbum(searchText)
        }
        return true

    }


    override fun startMainActivity(apiResponse : Response<PopuralAlbum>) {
        progress_bar.visibility = View.GONE
        rv_album_list.apply {
            setHasFixedSize(true)
            layoutManager = gridLayoutManager
            if (apiResponse != null) {
                if(apiResponse.isSuccessful)
                    adapter =
                        AlbumAdapter(apiResponse.body()!!.results,screenSizeName)
                (adapter as AlbumAdapter).notifyDataSetChanged()
            }
        }
    }

    override fun getScreenSize(screenInt: Int): String{
        val screenSizeInt = screenInt and Configuration.SCREENLAYOUT_SIZE_MASK
        return when (screenSizeInt) {
            Configuration.SCREENLAYOUT_SIZE_SMALL -> "small"
            Configuration.SCREENLAYOUT_SIZE_NORMAL -> "medium"
            Configuration.SCREENLAYOUT_SIZE_LARGE -> "large"
            4 -> "extralarge"
            else -> "undefined"
        }
    }
}