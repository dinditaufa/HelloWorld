package org.d3if4131.latassulang3


import android.content.ActivityNotFoundException
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ShareCompat
import androidx.databinding.DataBindingUtil
import kotlinx.android.synthetic.main.fragment_persegi.*
import org.d3if4131.latassulang3.databinding.FragmentPersegiBinding

/**
 * A simple [Fragment] subclass.
 */
class PersegiFragment : Fragment() {

    companion object {
        var KEYLUAS = "1"
        var KEYKELILING = "2"
        var P = 0
        var L = 0
        var Luas = 0
        var Keliling = 0
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentPersegiBinding>(inflater, R.layout.fragment_persegi, container, false)

        if (savedInstanceState != null) {
            Luas = savedInstanceState.getInt(KEYLUAS)
            Keliling = savedInstanceState.getInt(KEYKELILING)
            binding.apply {
                tvLuasPp.setText(Luas.toString())
                tvKelPp.setText(Keliling.toString())
            }
        }

        binding.btnHitungPp.setOnClickListener {
            if (edLebarPp.text.isEmpty() && edPanjangPp.text.isEmpty()) {
                Toast.makeText(context, "Harus Diisi !!", Toast.LENGTH_LONG).show()
            }else {
                P = edPanjangPp.text.toString().toInt()
                L = edLebarPp.text.toString().toInt()

                Luas = (P*L)
                Keliling = (P+P+L+L)

                tvLuasPp.setText(Luas.toString())
                tvKelPp.setText(Keliling.toString())
            }
        }

        binding.btnSharePp.setOnClickListener {
            val shareIntent = ShareCompat.IntentBuilder.from(requireActivity())
                .setType("text/plaint")
                .setText(getString(R.string.share_pp, P, L, Luas, Keliling))
                .intent
            try {
                startActivity(shareIntent)
            } catch (ex: ActivityNotFoundException) {
                Toast.makeText(context, "Share Tidak Ditemukan", Toast.LENGTH_LONG).show()
            }
        }
        return binding.root
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(KEYLUAS, Luas)
        outState.putInt(KEYKELILING, Keliling)
        super.onSaveInstanceState(outState)
    }
}
