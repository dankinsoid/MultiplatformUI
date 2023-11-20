package com.example.multiplatformuiapp.core

import com.example.multiplatformuiapp.core.types.KotlinUILayoutSubview
import com.example.multiplatformuiapp.core.types.KotlinUIProviderContext
import com.example.multiplatformuiapp.core.types.ProposedUISize
import com.example.multiplatformuiapp.core.types.UIRect
import com.example.multiplatformuiapp.core.types.UISize

interface KotlinUIProvider {

    fun makeText(context: KotlinUIProviderContext): KotlinUIComponent
    fun makeLayout(subviews: List<KotlinUILayoutSubview>, context: KotlinUIProviderContext): KotlinUILayout
    fun makeButton(context: KotlinUIProviderContext): KotlinUIComponent
}

interface KotlinUIComponent {

    fun sizeThatFits(proposal: ProposedUISize): UISize
    fun update(context: KotlinUIProviderContext)
}

interface KotlinUILayout: KotlinUIComponent {

    fun placeSubviewsIn(bounds: UIRect, proposal: ProposedUISize, subviews: List<KotlinUILayoutSubview>)
}
