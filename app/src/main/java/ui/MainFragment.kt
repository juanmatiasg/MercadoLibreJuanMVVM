package ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.*
import androidx.navigation.ui.NavigationUI

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmmercadolibrejuan.R
import com.example.mvvmmercadolibrejuan.model.Items
import com.example.mvvmmercadolibrejuan.model.api.ApiHelper
import com.example.mvvmmercadolibrejuan.model.retrofit.Api
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_main.view.*
import viewmodel.MainViewModel
import viewmodel.VMFactory
import utils.Resource
import utils.Status


class MainFragment : Fragment() {

    private lateinit var mRecyclerView: RecyclerView
    private val viewModel by activityViewModels<MainViewModel> {
        VMFactory(ApiHelper(Api.apiService))
    }
    private lateinit var mAdapter: ProductosAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView(view)
        setupObservers()
    }



    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.nav_menu,menu )
    }


    private fun setupObservers() {
        viewModel.getListProduct().observe(viewLifecycleOwner, Observer {
            it?.let {resource ->
                when(resource.status){
                    Status.LOADING ->{
                        mRecyclerView.visibility = View.GONE
                        progressBar.visibility = View.VISIBLE
                    }

                    Status.SUCCESS ->{
                        progressBar.visibility = View.GONE
                        mRecyclerView.visibility = View.VISIBLE
                        resource.data?.let { producto -> retrieveList(producto.items) }
                    }

                    Status.ERROR ->{

                    }
                }
            }
        })
    }

    private fun retrieveList(list:List<Items>) {
        mAdapter.apply {
            getAddListProducto(list)
        }
    }

    private fun setupRecyclerView(view: View) {
      /*  mRecyclerView = view.findViewById(R.id.rv_listaProductos)
        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        mAdapter = ProductosAdapter(arrayListOf())
        mRecyclerView.adapter = mAdapter*/

        /*para evitar repeticiones uso el apply*/

        mRecyclerView = view.findViewById(R.id.rv_listaProductos)

        mRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext())
            mAdapter = ProductosAdapter(arrayListOf())
            adapter = mAdapter
        }
    }


}