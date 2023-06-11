package com.example.kidzlearn

import android.content.Context
import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AnimalFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AnimalFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    var animal = intArrayOf(R.drawable.a0, R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.a4)
    var itemBackground = 0
    var mp = MediaPlayer()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        var style = activity?.obtainStyledAttributes(R.styleable.MyStyle)
        itemBackground = style!!.getResourceId(R.styleable.MyStyle_android_galleryItemBackground,0   )
        var v = inflater.inflate(R.layout.fragment_animal, container, false)

        var iv = v.findViewById<ImageView>(R.id.imageView3)
        iv.setImageResource(animal[0])
        iv.setBackgroundResource(itemBackground)

        var gv = v.findViewById<GridView>(R.id.gridview2)
        gv.numColumns = animal.size
        gv.adapter = ImageAdapter(v.context)

        gv.setOnItemClickListener { parent, view, position, id ->
            iv.setImageResource(animal[position])
            var mid =resources.getIdentifier("a"+position,"raw",activity?.packageName)
            if(mp.isPlaying)
                mp.stop()
            mp=MediaPlayer.create(v.context,mid)
            mp.start()
        }
        return v
    }
    inner class ImageAdapter(context: Context) : BaseAdapter(){
        override fun getCount(): Int {
            return animal.size
        }

        override fun getItem(position: Int): Any {
           return position
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?) : View {
          var iv = ImageView(context)
            iv.setImageResource(animal[position])
            iv.layoutParams = ViewGroup.LayoutParams(200,200)
            iv.setBackgroundResource(itemBackground)
            return iv
        }

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AnimalFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AnimalFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}