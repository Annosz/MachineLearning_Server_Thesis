package com.annosz.smartrealestate

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.provider.MediaStore
import android.support.annotation.StringRes
import android.support.design.widget.NavigationView
import android.support.v4.app.ActivityCompat
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.preference.PreferenceFragmentCompat
import android.view.MenuItem
import android.view.View
import com.annosz.smartrealestate.converters.Converters
import com.annosz.smartrealestate.database.AdvertisementDatabase
import com.annosz.smartrealestate.database.DbWorkerThread
import com.annosz.smartrealestate.fragments.AddHouseFragment
import com.annosz.smartrealestate.fragments.ListHousesFragment
import com.annosz.smartrealestate.fragments.ListOwnHousesFragment
import com.annosz.smartrealestate.fragments.WelcomeScreenFragment
import com.annosz.smartrealestate.model.AdvertisementData
import com.annosz.smartrealestate.network.AdViewCountEvent
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar.*
import kotlinx.android.synthetic.main.fragment_add_house.*
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.io.ByteArrayOutputStream
import java.time.LocalDateTime
import java.util.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener,
        WelcomeScreenFragment.OnFragmentInteractionListener, ListHousesFragment.OnFragmentInteractionListener,
        ListOwnHousesFragment.OnFragmentInteractionListener {

    companion object {
        private const val REQUEST_IMAGE_CAPTURE = 200
    }

    private var mDb: AdvertisementDatabase? = null
    private lateinit var mDbWorkerThread: DbWorkerThread
    private lateinit var actualFragment: Fragment

    //region setup
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        if (savedInstanceState == null) {
            nav_view.setCheckedItem(R.id.nav_welcome)
            actualFragment = WelcomeScreenFragment.newInstance()
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.app_content, actualFragment)
                    .commit()
        }
        else {
            var fragments = supportFragmentManager.fragments
            if (fragments != null)
                for (fragment in fragments)
                    if (fragment != null && !fragment.isHidden)
                        actualFragment = fragment
        }

        nav_view.setNavigationItemSelectedListener(this)

        mDbWorkerThread = DbWorkerThread("dbWorkerThread")
        mDbWorkerThread.start()

        mDb = AdvertisementDatabase.getInstance(this)
    }

    public override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState?.putCharSequence("savedText", "saved")
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
    //endregion

    //region menu navigation
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        actualFragment = WelcomeScreenFragment.newInstance()

        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_welcome -> {
                // Fragment already initialized
                nav_view.setCheckedItem(R.id.nav_welcome)
            }
            R.id.nav_explore -> {
                actualFragment = ListHousesFragment.newInstance()
                nav_view.setCheckedItem(R.id.nav_explore)
            }
            R.id.nav_create -> {
                actualFragment = AddHouseFragment.newInstance()
                nav_view.setCheckedItem(R.id.nav_create)
            }
            R.id.nav_own -> {
                actualFragment = ListOwnHousesFragment.newInstance()
                getHouses((actualFragment as ListOwnHousesFragment)::AddHouseList)
                nav_view.setCheckedItem(R.id.nav_own)
            }
            R.id.nav_settings -> {
                actualFragment = FragmentSettingsBasic()
                nav_view.setCheckedItem(R.id.nav_settings)
            }
        }

        supportFragmentManager
                .beginTransaction()
                .replace(R.id.app_content, actualFragment)
                .commit()

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onCreateNewAdClicked() {
        actualFragment = AddHouseFragment.newInstance()
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.app_content, actualFragment)
                .commit()

        nav_view.setCheckedItem(R.id.nav_create)
    }

    fun onListOwnHousesClicked() {
        actualFragment = ListOwnHousesFragment.newInstance()
        getHouses((actualFragment as ListOwnHousesFragment)::AddHouseList)
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.app_content, actualFragment)
                .commit()

        nav_view.setCheckedItem(R.id.nav_own)
    }

    override fun onDetailsClicked(id: Int) {
        //TODO részletek fragment
    }
    //endregion

    //region database
    fun onAddButtonPressed(view: View) {
        val fragment = (actualFragment as AddHouseFragment)

        fragment.createAd()
        addHouse(fragment.advertisemendData)
        onListOwnHousesClicked()
    }

    fun addHouse(advertisementData: AdvertisementData) {
        val task = Runnable { mDb?.advertisementDataDao()?.insert(advertisementData) }
        mDbWorkerThread.postTask(task)
    }

    fun getHouses(listSetter: (List<AdvertisementData>) -> Unit) {
        val task = Runnable {
            var list = mDb?.advertisementDataDao()?.getAll() ?: emptyList()

            val updateTask = Runnable {
                listSetter(list)
            }
            runOnUiThread(updateTask)
        }
        mDbWorkerThread.postTask(task)
    }
    //endregion

    //region camera
    fun onCameraButtonPressed(view: View) {
        handlePhotoPermission()
    }

    private fun makePhoto() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            takePictureIntent.resolveActivity(packageManager)?.also {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
            }
        }
    }
    //endregion

    //region permissions
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            data?.also {
                val imageBitmap = it.extras.get("data") as Bitmap
                FormImage.setImageBitmap(imageBitmap)

                (actualFragment as AddHouseFragment).madeImage = true
            }
        }
    }

    private fun showRationaleDialog(
            @StringRes title: Int = R.string.rationale_dialog_title,
            @StringRes explanation: Int,
            onPositiveButton: () -> Unit,
            onNegativeButton: () -> Unit = this::finish
    ) {
        val alertDialog = AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(explanation)
                .setCancelable(false)
                .setPositiveButton(R.string.proceed) { dialog, id ->
                    dialog.cancel()
                    onPositiveButton()
                }
                .setNegativeButton(R.string.exit) { dialog, id -> onNegativeButton() }
                .create()
        alertDialog.show()
    }

    private fun handlePhotoPermission() {
        if (ContextCompat.checkSelfPermission(this,
                        Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

                showRationaleDialog(
                        explanation = R.string.photo_permission_explanation,
                        onPositiveButton = this::requestPhotoPermission
                )

            } else {
                // No explanation needed, we can request the permission.
                requestPhotoPermission()
            }
        } else {
            makePhoto()
        }
    }

    private fun requestPhotoPermission() {
        ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.CAMERA),
                REQUEST_IMAGE_CAPTURE
        )
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {
            REQUEST_IMAGE_CAPTURE -> {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                    makePhoto()
                } else {
                    // permission denied! Disable the
                    // functionality that depends on this permission.
                }
                return
            }
        }
    }
    //endregion

    //region preferences
    class FragmentSettingsBasic : PreferenceFragmentCompat() {
        override fun onCreatePreferences(savedInstanceState: Bundle?, key: String?) {
            addPreferencesFromResource(R.xml.preferences)
        }
    }
    //endregion
}
