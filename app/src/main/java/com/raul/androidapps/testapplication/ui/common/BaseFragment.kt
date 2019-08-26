package com.raul.androidapps.testapplication.ui.common

import com.raul.androidapps.testapplication.databinding.BindingComponent
import com.raul.androidapps.testapplication.resources.ResourcesManager
import dagger.android.support.DaggerFragment
import javax.inject.Inject


abstract class BaseFragment : DaggerFragment() {

    @Inject
    protected lateinit var viewModelFactory: ViewModelFactory

    @Inject
    protected lateinit var bindingComponent: BindingComponent

    @Inject
    lateinit var resourcesManager: ResourcesManager

}