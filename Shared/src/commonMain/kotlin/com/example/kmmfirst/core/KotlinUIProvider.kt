package com.example.kmmfirst.core

import com.example.kmmfirst.core.types.KotlinUILayoutSubview
import com.example.kmmfirst.core.types.KotlinUIProviderContext
import com.example.kmmfirst.core.types.ProposedUISize
import com.example.kmmfirst.core.types.UIRect
import com.example.kmmfirst.core.types.UISize

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
