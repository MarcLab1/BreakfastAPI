package com.breakfastapi.ui.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.breakfastapi.model.Recipe
import com.breakfastapi.repository.Repository
import com.breakfastapi.util.NetworkStatus
import com.breakfastapi.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    var recipes : MutableState<List<Recipe>> = mutableStateOf(listOf())
    var networkCallCount = mutableStateOf(0)
    var networkStatus = mutableStateOf(NetworkStatus.WAITING)

    init {
       loadRecipe()
    }

    fun loadRecipe() {
        viewModelScope.launch {
            networkStatus.value = NetworkStatus.LOADING
            var result = repository.getRecipe()
            when(result)
            {
                is Resource.Success ->
                {
                    recipes.value += result.data
                    networkStatus.value = NetworkStatus.SUCCESS
                }
                is Resource.Error ->
                {
                    networkStatus.value = NetworkStatus.ERROR
                    networkStatus.value.msg = result.exception.localizedMessage
                }
                is Resource.Loading ->
                {
                    networkStatus.value = NetworkStatus.LOADING
                }
            }
            networkCallCount.value ++
        }
    }
}