package org.d3if4131.latassulang3


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import org.d3if4131.latassulang3.databinding.FragmentMenuBinding

/**
 * A simple [Fragment] subclass.
 */
class MenuFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentMenuBinding>(inflater, R.layout.fragment_menu, container, false)
        binding.btnPersegiPanjang.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_menuFragment_to_persegiFragment)
        }
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item!! , view!!.findNavController()) || super.onOptionsItemSelected(item)
    }
}
